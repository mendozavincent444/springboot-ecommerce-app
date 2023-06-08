package com.luv2code.springbootecommerce.payload;

import com.luv2code.springbootecommerce.entity.Address;
import com.luv2code.springbootecommerce.entity.Customer;
import com.luv2code.springbootecommerce.entity.Order;
import com.luv2code.springbootecommerce.entity.OrderItem;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PurchaseDto {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
