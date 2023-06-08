package com.luv2code.springbootecommerce.repository;

import com.luv2code.springbootecommerce.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
