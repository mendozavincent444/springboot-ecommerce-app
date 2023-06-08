package com.luv2code.springbootecommerce.service;

import com.luv2code.springbootecommerce.entity.Country;
import com.luv2code.springbootecommerce.payload.CountryDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> getAllCountries();
}
