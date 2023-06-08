package com.luv2code.springbootecommerce.security;

import com.luv2code.springbootecommerce.entity.Role;
import com.luv2code.springbootecommerce.repository.UserRepository;

import com.luv2code.springbootecommerce.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username or email: " + usernameOrEmail));


        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), this.mapRolesToAuthorities(user.getRoles()));

    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {

        return roles.stream().map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }


}
