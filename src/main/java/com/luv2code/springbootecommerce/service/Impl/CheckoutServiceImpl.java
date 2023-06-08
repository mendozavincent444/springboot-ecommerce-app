package com.luv2code.springbootecommerce.service.Impl;

import com.luv2code.springbootecommerce.entity.Customer;
import com.luv2code.springbootecommerce.entity.Order;
import com.luv2code.springbootecommerce.entity.OrderItem;
import com.luv2code.springbootecommerce.payload.PurchaseDto;
import com.luv2code.springbootecommerce.payload.PurchaseResponse;
import com.luv2code.springbootecommerce.repository.CustomerRepository;
import com.luv2code.springbootecommerce.service.CheckoutService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public PurchaseResponse placeOrder(PurchaseDto purchaseDto) {

        // retrieve the order info from dto
        Order order = purchaseDto.getOrder();

        // generate tracking number
        String orderTrackingNumber = this.generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with orderItems
        Set<OrderItem> orderItems = purchaseDto.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchaseDto.getBillingAddress());
        order.setShippingAddress(purchaseDto.getShippingAddress());


        // populate customer with order
        Customer customer = purchaseDto.getCustomer();

        // check if this is an existing customer
        String theEmail = customer.getEmail();

        Customer customerFromDB = this.customerRepository.findByEmail(theEmail);

        if (customerFromDB != null) {
            customer = customerFromDB;
        }

        customer.add(order);

        // save to the database
        this.customerRepository.save(customer);
        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        // generate a random UUID number (UUID version-4)
        // For details see: https//:en.wikipedia.org/wiki/Universally_unique_identifier
        return UUID.randomUUID().toString();
    }
}
