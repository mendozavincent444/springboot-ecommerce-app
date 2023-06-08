package com.luv2code.springbootecommerce.payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseResponse {
    private String orderTrackingNumber;
}
