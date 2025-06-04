package com.musahalilecer.booksaleproject.dto.response;

import lombok.*;

import java.util.List;

@Data
@Builder
public class AuthorResponse {

    public AuthorResponse(Integer id, String name, String image, List<BookResponse> books) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.books = books;
    }

    private Integer id;
    private String name;
    private String image;
    private List<BookResponse> books;

    public AuthorResponse(Integer id, String name, String image) {
    }


    /*
    public <R> AuthorResponse(Integer id, String name, String image, R collect) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthorResponse(Integer id, String image, String name) {
        this.id = id;
        this.image = image;
        this.name = name;
    }

    private Integer id;
    private String name;
    private String image;

    public List<BookResponse> getBooks() {
        return books;
    }

    public void setBooks(List<BookResponse> books) {
        this.books = books;
    }

    private List<BookResponse> books;

     */
}
