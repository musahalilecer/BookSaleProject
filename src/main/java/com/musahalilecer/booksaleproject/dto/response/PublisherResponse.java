package com.musahalilecer.booksaleproject.dto.response;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublisherResponse {
    private Integer id;
    private String publisherName;
    private String publisherAddress;
    private String publisherImage;

    public PublisherResponse(Integer id, String publisherName) {
    }

    public List<BookResponse> getBooks() {
        return books;
    }

    public void setBooks(List<BookResponse> books) {
        this.books = books;
    }

    private List<BookResponse> books;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    public String getPublisherImage() {
        return publisherImage;
    }

    public void setPublisherImage(String publisherImage) {
        this.publisherImage = publisherImage;
    }

    public PublisherResponse(Integer id, String publisherName, String publisherAddress, String publisherImage) {
        this.id = id;
        this.publisherName = publisherName;
        this.publisherAddress = publisherAddress;
        this.publisherImage = publisherImage;
    }
}
