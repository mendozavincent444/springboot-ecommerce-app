package com.luv2code.springbootecommerce.service.Impl;

import com.luv2code.springbootecommerce.entity.Country;
import com.luv2code.springbootecommerce.entity.ProductCategory;
import com.luv2code.springbootecommerce.payload.CountryDto;
import com.luv2code.springbootecommerce.payload.ProductCategoryDto;
import com.luv2code.springbootecommerce.repository.CountryRepository;
import com.luv2code.springbootecommerce.service.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;

    public CountryServiceImpl(CountryRepository countryRepository, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CountryDto> getAllCountries() {
        List<Country> countries = this.countryRepository.findAll();

        return countries.stream().map((country -> this.mapToDto(country))).collect(Collectors.toList());
    }

    private CountryDto mapToDto(Country country) {
        CountryDto countryDto = this.modelMapper.map(country, CountryDto.class);
        return countryDto;
    }

    private Country mapToEntity(CountryDto countryDto) {
        Country country = this.modelMapper.map(countryDto, Country.class);
        return country;
    }
}
