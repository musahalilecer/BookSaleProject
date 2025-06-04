package com.musahalilecer.booksaleproject.exception.LocalException.BookException;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message){
        super(message);
    }
}
