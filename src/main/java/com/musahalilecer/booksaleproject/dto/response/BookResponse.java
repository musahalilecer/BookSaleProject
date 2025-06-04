package com.musahalilecer.booksaleproject.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    public BookResponse(Integer id, String title, String description, Double price, String image, Integer page,
                        String authorName, String languageName, String countryName, String publisherName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
        this.page = page;
        this.authorName = authorName;
        this.languageName = languageName;
        this.countryName = countryName;
        this.publisherName = publisherName;
    }

    private Integer page;

    private String authorName;
    private String languageName;
    private String countryName;
    private String publisherName;

    private AuthorResponse author;
    private LanguageResponse language;
    private CountryResponse country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    private int id;
    private String title;
    private String description;
    private String image;
    private Double price;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }



    public CountryResponse getCountry() {
        return country;
    }

    public void setCountry(CountryResponse country) {
        this.country = country;
    }

    public AuthorResponse getAuthor() {
        return author;
    }

    public void setAuthor(AuthorResponse author) {
        this.author = author;
    }

    public LanguageResponse getLanguage() {
        return language;
    }

    public void setLanguage(LanguageResponse language) {
        this.language = language;
    }

    public PublisherResponse getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherResponse publisher) {
        this.publisher = publisher;
    }

    private PublisherResponse publisher;


/*
    public AuthorResponse getAuthorName() {
        return authorName;
    }

    public void setAuthorName(AuthorResponse authorName) {
        this.authorName = authorName;
    }

    public CountryResponse getCountryName() {
        return countryName;
    }

    public void setCountryName(CountryResponse countryName) {
        this.countryName = countryName;
    }

    public PublisherResponse getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(PublisherResponse publisherName) {
        this.publisherName = publisherName;
    }

    public LanguageResponse getLanguageName() {
        return languageName;
    }

    public void setLanguageName(LanguageResponse languageName) {
        this.languageName = languageName;
    }

 */
}
