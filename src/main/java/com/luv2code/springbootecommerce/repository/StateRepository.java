package com.luv2code.springbootecommerce.repository;

import com.luv2code.springbootecommerce.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {

    List<State> findByCountryCode(String code);
}
