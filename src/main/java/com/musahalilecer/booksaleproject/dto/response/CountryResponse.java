package com.musahalilecer.booksaleproject.dto.response;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryResponse {
    /*
    public CountryResponse(Integer id, String countryName, String flag) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

     */

    private Integer id;
    private String countryName;
    private String flag;
/*
    public List<BookResponse> getBooks() {
        return books;
    }

    public void setBooks(List<BookResponse> books) {
        this.books = books;
    }

 */

    private List<BookResponse> books;

    public CountryResponse(Integer id, String countryName) {
    }
}
