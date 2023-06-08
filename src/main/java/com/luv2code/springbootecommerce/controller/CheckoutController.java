package com.luv2code.springbootecommerce.controller;

import com.luv2code.springbootecommerce.payload.PurchaseDto;
import com.luv2code.springbootecommerce.payload.PurchaseResponse;
import com.luv2code.springbootecommerce.service.CheckoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }
    @RequestMapping("/purchase")
    public ResponseEntity<PurchaseResponse> placeOrder(@RequestBody PurchaseDto purchaseDto) {

        PurchaseResponse purchaseResponse = this.checkoutService.placeOrder(purchaseDto);

        return new ResponseEntity<>(purchaseResponse, HttpStatus.CREATED);
    }


}
