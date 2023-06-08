package com.luv2code.springbootecommerce.utils;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderGenerator {
    public static void main(String[] args) {


        System.out.println(passwordEncoder().encode("admin"));
    }


    private static PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
