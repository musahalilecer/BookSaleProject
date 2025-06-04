package com.musahalilecer.booksaleproject.service.services;

import com.musahalilecer.booksaleproject.dto.request.CountryRequest;
import com.musahalilecer.booksaleproject.dto.response.CountryResponse;

import java.util.List;

public interface CountryService {
    List<CountryResponse> getAllCountries();
    CountryResponse getCountryById(int id);
    CountryResponse createCountry(CountryRequest countryRequest);
    CountryResponse updateCountry(CountryRequest countryRequest, int id);
    void deleteCountry(int id);
}
