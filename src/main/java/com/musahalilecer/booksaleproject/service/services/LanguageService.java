package com.musahalilecer.booksaleproject.service.services;

import com.musahalilecer.booksaleproject.dto.request.LanguageRequest;
import com.musahalilecer.booksaleproject.dto.response.LanguageResponse;

import java.util.List;

public interface LanguageService {
    List<LanguageResponse> getAlllanguages();
    LanguageResponse getlanguageById(int id);
    LanguageResponse createLanguage(LanguageRequest languageRequest);
    LanguageResponse updateLanguage(int id, LanguageRequest languageRequest);
    void deleteLanguage(int id);
}
