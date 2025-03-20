package com.example.UserAcc.service;

import com.example.UserAcc.Repository.AllRepo;
import com.example.UserAcc.model.UserAcc;
import com.example.UserAcc.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private AllRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAcc userAcc = repo.findByuserName(username);

        if(userAcc == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");

        }
        return new UserPrincipal(userAcc);

//        Now, if the user is not found, Spring Security will reject the login attempt properly.
    }
}
