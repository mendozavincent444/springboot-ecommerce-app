package com.luv2code.springbootecommerce.service;

import com.luv2code.springbootecommerce.entity.State;
import com.luv2code.springbootecommerce.payload.StateDto;

import java.util.List;

public interface StateService {
    List<StateDto> getAllStatesByCountryCode(String code);
}
