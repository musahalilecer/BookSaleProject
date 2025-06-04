package com.musahalilecer.booksaleproject.dto.response;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LanguageResponse {
    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LanguageResponse(Integer id, String languageName) {
        this.id = id;
        this.languageName = languageName;
    }

    private Integer id;
    private String languageName;

    public List<BookResponse> getBooks() {
        return books;
    }

    public void setBooks(List<BookResponse> books) {
        this.books = books;
    }

    private List<BookResponse> books;
}
