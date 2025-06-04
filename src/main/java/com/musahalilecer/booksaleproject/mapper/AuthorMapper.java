package com.musahalilecer.booksaleproject.mapper;

import com.musahalilecer.booksaleproject.dto.request.AuthorRequest;
import com.musahalilecer.booksaleproject.dto.response.AuthorResponse;
import com.musahalilecer.booksaleproject.model.Author;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class AuthorMapper {
    public static AuthorResponse toAuthorResponse(Author author) {
        return new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getImage(),
                author.getBooks() != null
                        ? author.getBooks().stream().map(BookMapper::toBookResponse).collect(Collectors.toList())
                        : new ArrayList<>()
        );
    }
    public static Author toAuthorEntity(String name, String image) {
        Author author = new Author();
        author.setName(name);
        author.setImage(image);
        return author;
    }
    public static void toAuthorRequest(AuthorRequest authorRequest, Author author) {
        author.setName(authorRequest.getName());
        author.setImage(authorRequest.getImage());
    }
}
