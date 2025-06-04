package com.musahalilecer.booksaleproject.mapper;

import com.musahalilecer.booksaleproject.dto.request.LanguageRequest;
import com.musahalilecer.booksaleproject.dto.response.LanguageResponse;
import com.musahalilecer.booksaleproject.model.Language;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LanguageMapper {
    public static LanguageResponse toLanguageResponse(Language language) {
        return new LanguageResponse(
                language.getId(),
                language.getLanguageName(),
                language.getBooks() != null
                        ? language.getBooks().stream().map(BookMapper::toBookResponse).collect(Collectors.toList())
                        : new ArrayList<>()
        );
    }

    /*
    author.getBooks() != null
                        ? author.getBooks().stream().map(BookMapper::toBookResponse).collect(Collectors.toList())
                        : new ArrayList<>()
     */

    public static Language toLanguageEntity(String languageName) {
        return Language.builder()
                .languageName(languageName)
                .build();
    }

    public static void languageToRequest(Language language, LanguageRequest request) {
        language.setLanguageName(request.getLanguageName());
    }
}
