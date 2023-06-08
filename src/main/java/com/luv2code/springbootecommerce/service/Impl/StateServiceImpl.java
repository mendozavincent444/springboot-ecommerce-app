package com.luv2code.springbootecommerce.service.Impl;

import com.luv2code.springbootecommerce.entity.State;
import com.luv2code.springbootecommerce.payload.StateDto;
import com.luv2code.springbootecommerce.repository.StateRepository;
import com.luv2code.springbootecommerce.service.StateService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateServiceImpl implements StateService {

    private final StateRepository stateRepository;
    private final ModelMapper modelMapper;

    public StateServiceImpl(StateRepository stateRepository, ModelMapper modelMapper) {
        this.stateRepository = stateRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<StateDto> getAllStatesByCountryCode(String code) {
        List<State> states = this.stateRepository.findByCountryCode(code);

        return states.stream().map(state -> this.mapToDto(state)).collect(Collectors.toList());
    }

    private StateDto mapToDto(State state) {
        StateDto stateDto = this.modelMapper.map(state, StateDto.class);
        return stateDto;
    }

    private State mapToEntity(StateDto stateDto) {
        State state = this.modelMapper.map(stateDto, State.class);
        return state;
    }
}
