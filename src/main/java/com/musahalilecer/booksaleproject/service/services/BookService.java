package com.musahalilecer.booksaleproject.service.services;

import com.musahalilecer.booksaleproject.dto.request.BookRequest;
import com.musahalilecer.booksaleproject.dto.response.BookResponse;

import java.util.List;

public interface BookService {
    List<BookResponse> getAllBooks();
    BookResponse getBookById(int id);
    BookResponse createBook(BookRequest bookRequest);
    BookResponse updateBook(int id, BookRequest bookRequest);
    void deleteBook(int id);
}
