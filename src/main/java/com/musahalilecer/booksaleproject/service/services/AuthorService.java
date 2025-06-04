package com.musahalilecer.booksaleproject.service.services;

import com.musahalilecer.booksaleproject.dto.request.AuthorRequest;
import com.musahalilecer.booksaleproject.dto.response.AuthorResponse;

import java.util.List;

public interface AuthorService {
    List<AuthorResponse> getAllAuthors();
    AuthorResponse getAuthorById(int id);
    AuthorResponse createAuthor(AuthorRequest authorRequest);
    AuthorResponse updateAuthor(int id, AuthorRequest authorRequest);
    void deleteAuthor(int id);
}
