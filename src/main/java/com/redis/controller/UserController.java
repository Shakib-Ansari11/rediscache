package com.redis.controller;

import com.redis.model.User;
import com.redis.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
//@ComponentScan(basePackages = "com.redis")
public class UserController {

//    @Autowired
//    private UserRepoImpl userRepo;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        userRepo.save(user);
        return userRepo.findById(user.getId());

    }

    @GetMapping("/user")
    public Map<String, User> allUser() {
        return userRepo.findAll();
    }

    @GetMapping("/user/{id}")
    public User userById(@PathVariable String id) {
        return userRepo.findById(id);
    }

    @DeleteMapping("/user/{id}")
    public Map<String, User> delete(@PathVariable("id") final String id) {
        userRepo.delete(id);
        return allUser();
    }
    @PutMapping("/user/{id}/{name}")
    public User update(@PathVariable("id") final String id, @PathVariable("name") final String name) {
       userRepo.update(new User(id,name,122L));
        return userRepo.findById(id);
    }

}
