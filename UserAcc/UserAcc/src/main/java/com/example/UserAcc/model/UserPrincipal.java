package com.example.UserAcc.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

    private UserAcc acc;

    public UserPrincipal(UserAcc acc) {
        this.acc = acc;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return acc.getAuthorities().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return acc.getPassword();
    }

    @Override
    public String getUsername() {
        return acc.getUserName();
    }
}
