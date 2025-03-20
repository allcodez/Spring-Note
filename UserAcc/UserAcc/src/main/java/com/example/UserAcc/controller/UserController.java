package com.example.UserAcc.controller;

import com.example.UserAcc.model.UserAcc;
import com.example.UserAcc.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private final MyService service;

    public UserController(MyService service) {
        this.service = service;
    }

    @GetMapping("/userhome")
    public List<UserAcc> getalluser(){
        return service.getUsers();
    }

    @PostMapping("/userhome")
    public UserAcc register(@RequestBody UserAcc useracc){
        return service.register(useracc);
    }

    @PutMapping("/userhome")
    public UserAcc updateuser(@PathVariable String id, UserAcc userAcc){
        return service.updateUser(id, userAcc);
    }

    @DeleteMapping("/userhome/{id}")
    public void deleteuser(@PathVariable int id){
         service.deleteuser(id);
    }

    @DeleteMapping("/deleteall/{id}")
    public void deleteall(@RequestBody List<Integer> ids){
        service.deleteall(ids);
    }
}
