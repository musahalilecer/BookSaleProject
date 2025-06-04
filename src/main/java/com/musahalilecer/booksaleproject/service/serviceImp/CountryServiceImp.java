package com.musahalilecer.booksaleproject.service.serviceImp;

import com.musahalilecer.booksaleproject.dto.request.CountryRequest;
import com.musahalilecer.booksaleproject.dto.response.CountryResponse;
import com.musahalilecer.booksaleproject.mapper.CountryMapper;
import com.musahalilecer.booksaleproject.model.Country;
import com.musahalilecer.booksaleproject.repository.CountryRepository;
import com.musahalilecer.booksaleproject.service.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImp implements CountryService {
    @Autowired
    private CountryRepository countryRepository;


    @Override
    public List<CountryResponse> getAllCountries() {
        List<Country> countries = countryRepository.findAll();
        return countries.stream().map(CountryMapper::toCountryResponse).collect(Collectors.toList());
    }

    @Override
    public CountryResponse getCountryById(int id) {
        return CountryMapper.toCountryResponse(countryRepository.findById(id).get());
    }

    @Override
    public CountryResponse createCountry(CountryRequest countryRequest) {
        Country newCountry = CountryMapper.toCountryEntity(countryRequest.getCountryName(), countryRequest.getFlag());
        Country savedCountry = countryRepository.save(newCountry);
        return CountryMapper.toCountryResponse(savedCountry);
    }

    @Override
    public CountryResponse updateCountry(CountryRequest countryRequest, int id) {
        return null;
    }

    @Override
    public void deleteCountry(int id) {
    countryRepository.deleteById(id);
    }
}
