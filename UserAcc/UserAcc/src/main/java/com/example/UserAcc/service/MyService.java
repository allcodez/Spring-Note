package com.example.UserAcc.service;

import com.example.UserAcc.Repository.AllRepo;
import com.example.UserAcc.model.UserAcc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {
    @Autowired
    private final AllRepo repo;

    public MyService(AllRepo repo) {
        this.repo = repo;
    }
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


//    public UserAcc createUser(UserAcc user) {
//        if (user.getAuthorities() == null || user.getAuthorities().isEmpty()) {
//            user.setAuthorities(List.of("USER")); // Assign default role if none provided
//        }
//        return userRepository.save(user);
//    }
    public UserAcc register(UserAcc useracc) {
        useracc.setPassword(encoder.encode(useracc.getPassword()));
        return repo.save(useracc);
    }

    public UserAcc updateUser(String id, UserAcc userAcc) {
        return  repo.save(userAcc);
    }

    public List<UserAcc> getUsers() {
        return repo.findAll();
    }

    public void deleteuser(int id) {
        repo.deleteById(id);
    }


    public void deleteall(List<Integer> ids) {
        repo.deleteAllById(ids);
    }
}
