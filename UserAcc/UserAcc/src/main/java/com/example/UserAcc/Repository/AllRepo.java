package com.example.UserAcc.Repository;

import com.example.UserAcc.model.UserAcc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllRepo extends JpaRepository<UserAcc, Integer> {

    UserAcc findByuserName(String username);
}
