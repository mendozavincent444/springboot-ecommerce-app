package com.luv2code.springbootecommerce.service;

import com.luv2code.springbootecommerce.payload.PurchaseDto;
import com.luv2code.springbootecommerce.payload.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(PurchaseDto purchaseDto);
}
