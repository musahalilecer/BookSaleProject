package com.musahalilecer.booksaleproject.mapper;

import com.musahalilecer.booksaleproject.dto.response.CountryResponse;
import com.musahalilecer.booksaleproject.model.Country;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class CountryMapper {
    public static CountryResponse toCountryResponse(Country country) {
        return new CountryResponse(
            country.getId(),
            country.getCountryName(),
            country.getFlag(),
            country.getBooks() != null
                ? country.getBooks().stream().map(BookMapper::toBookResponse).collect(Collectors.toList())
                : new ArrayList<>()
        );
    }
    /*
    author.getBooks() != null
                        ? author.getBooks().stream().map(BookMapper::toBookResponse).collect(Collectors.toList())
                        : new ArrayList<>()
     */
    public static Country toCountryEntity(String countryName, String flag) {
        return Country.builder()
                .countryName(countryName)
                .flag(flag)
                .build();
    }
}
