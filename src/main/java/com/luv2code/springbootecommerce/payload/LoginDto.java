package com.luv2code.springbootecommerce.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    private String usernameOrEmail;
    private String password;
}
