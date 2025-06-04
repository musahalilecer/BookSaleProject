package com.musahalilecer.booksaleproject.service.serviceImp;

import com.musahalilecer.booksaleproject.dto.request.LanguageRequest;
import com.musahalilecer.booksaleproject.dto.response.LanguageResponse;
import com.musahalilecer.booksaleproject.mapper.LanguageMapper;
import com.musahalilecer.booksaleproject.model.Language;
import com.musahalilecer.booksaleproject.repository.LanguageRepository;
import com.musahalilecer.booksaleproject.service.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImp implements LanguageService {
    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public List<LanguageResponse> getAlllanguages() {
        List<Language> languages = languageRepository.findAll();
        return languages.stream().map(LanguageMapper::toLanguageResponse).collect(Collectors.toList());
    }

    @Override
    public LanguageResponse getlanguageById(int id) {
        return languageRepository
                .findById(id)
                .map(LanguageMapper::toLanguageResponse)
                .orElse(null);
    }

    @Override
    public LanguageResponse createLanguage(LanguageRequest languageRequest) {
        Language newLanguage = LanguageMapper.toLanguageEntity(languageRequest.getLanguageName());
        Language savedLanguage = languageRepository.save(newLanguage);
        return LanguageMapper.toLanguageResponse(savedLanguage);
    }

    @Override
    public LanguageResponse updateLanguage(int id, LanguageRequest languageRequest) {

        Language existingLanguage = languageRepository.findById(id).orElseThrow();
        LanguageMapper.languageToRequest(existingLanguage, languageRequest);
        Language updatedLanguage = languageRepository.save(existingLanguage);
        return LanguageMapper.toLanguageResponse(updatedLanguage);
/*
        return languageRepository.findById(id)
                .map(language -> {
                    LanguageMapper.languageToRequest(language, languageRequest);
                    return LanguageMapper.toLanguageResponse(languageRepository.save(language));
                })
                .orElseThrow(() -> new RuntimeException("Language not found with id: " + id));

 */

    }

    @Override
    public void deleteLanguage(int id) {
    languageRepository.deleteById(id);
    }
}
