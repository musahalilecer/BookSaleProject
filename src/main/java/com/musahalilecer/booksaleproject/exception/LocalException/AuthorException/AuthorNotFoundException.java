package com.musahalilecer.booksaleproject.exception.LocalException.AuthorException;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(String message) {
        super(message);
    }
}
