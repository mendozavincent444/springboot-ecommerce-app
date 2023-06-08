package com.luv2code.springbootecommerce.controller;

import com.luv2code.springbootecommerce.entity.State;
import com.luv2code.springbootecommerce.payload.StateDto;
import com.luv2code.springbootecommerce.service.StateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/states")
public class StateController {

    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/search/findByCountryCode")
    public ResponseEntity<List<StateDto>> getStatesByCountryCode(@RequestParam(name = "code") String code) {
        List<StateDto> stateDtos = this.stateService.getAllStatesByCountryCode(code);

        return new ResponseEntity<>(stateDtos, HttpStatus.OK);
    }
}
