package com.musahalilecer.booksaleproject.mapper;

import com.musahalilecer.booksaleproject.dto.response.*;
import com.musahalilecer.booksaleproject.model.*;

import java.util.Optional;

public class BookMapper {

    public static BookResponse toBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .description(book.getDescription())
                .price(book.getPrice())
                .image(book.getImage())
                .page(book.getPage())
                .author(Optional.ofNullable(book.getAuthor()).map(author ->
                        AuthorResponse.builder()
                                .id(author.getId())
                                .name(author.getName())
                                .image(author.getImage())
                                .build()
                ).orElse(null))
                .language(Optional.ofNullable(book.getLanguage()).map(lang ->
                        LanguageResponse.builder()
                                .id(lang.getId())
                                .languageName(lang.getLanguageName())
                                .build()
                ).orElse(null))
                .country(Optional.ofNullable(book.getCountry()).map(cntry ->
                        CountryResponse.builder()
                                .id(cntry.getId())
                                .countryName(cntry.getCountryName())
                                .build()
                ).orElse(null))
                .publisher(Optional.ofNullable(book.getPublisher()).map(pub ->
                        PublisherResponse.builder()
                                .id(pub.getId())
                                .publisherName(pub.getPublisherName())
                                .build()
                ).orElse(null))
                .build();
    }


    /*
    public static BookResponse toBookResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getDescription(),
                book.getPrice(),
                book.getImage(),
                book.getPage(),
                Optional.ofNullable(book.getAuthor()).map(Author::getName).orElse(null),
                Optional.ofNullable(book.getLanguage()).map(Language::getLanguageName).orElse(null),
                Optional.ofNullable(book.getCountry()).map(Country::getCountryName).orElse(null),
                Optional.ofNullable(book.getPublisher()).map(Publisher::getPublisherName).orElse(null)
        );
    }

     */
    public static Book toBookEntity(String title, Author author, String description, Language language, Integer page, String image, Double price, Publisher publisher, Country country) {
        return Book.builder()
                .title(title)
                .author(author)
                .description(description)
                .language(language)
                .image(image)
                .page(page)
                .price(price)
                .publisher(publisher)
                .country(country)
                .build();
    }
}
