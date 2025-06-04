package com.musahalilecer.booksaleproject.controller;

import com.musahalilecer.booksaleproject.dto.request.CountryRequest;
import com.musahalilecer.booksaleproject.dto.response.CountryResponse;
import com.musahalilecer.booksaleproject.service.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<CountryResponse>> getAllCountry() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryResponse> getCountryById(@PathVariable int id) {
        CountryResponse country = countryService.getCountryById(id);
        return ResponseEntity.ok(country);
    }

    @PostMapping
    public ResponseEntity<CountryResponse> createCountry(@RequestBody CountryRequest countryRequest) {
        CountryResponse newCountry = countryService.createCountry(countryRequest);
        return ResponseEntity.ok(newCountry);
    }
}
