package com.luv2code.springbootecommerce.controller;

import com.luv2code.springbootecommerce.payload.CountryDto;
import com.luv2code.springbootecommerce.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<CountryDto>> getAllCountries() {
        List<CountryDto> countryDtoList = this.countryService.getAllCountries();

        return new ResponseEntity<>(countryDtoList, HttpStatus.OK);
    }
}
