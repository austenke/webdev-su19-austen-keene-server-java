package com.example.webdevsu19austenkeeneserverjava.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevsu19austenkeeneserverjava.models.User;

@RestController
public class UserController {
    private List<User> users = Arrays.asList(
            new User(1, "superman", "1234", "Clark", "Kent"),
            new User(2, "black panther", "12345", "King", "T'Challa"),
            new User(3, "wonder woman", "123456", "Diana", "Prince"));

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return users;
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId") int userId) {
        User u = null;

        for(User user : users) {
            if(user.getId() == userId) {
                u = user;
            }
        }

        return u;
    }

    @DeleteMapping("/users/{userId}")
    public List<User> deleteUser(@PathVariable("userId") int userId) {
        User u = null;

        for(User user : users) {
            if(user.getId() == userId) {
                u = user;
            }
        }

        if (u == null) {
            return users;
        }

        users.remove(u);
        return users;
    }

    @PostMapping("/users/{userId}")
    public List<User> updateUser(@PathVariable("userId") int userId, @RequestBody User newUser) {
        User u = null;

        for(User user : users) {
            if(user.getId() == userId) {
                u = user;
            }
        }

        if (u == null) {
            return users;
        }

        users.remove(u);
        users.add(newUser);
        return users;
    }

    @PostMapping("/users")
    public List<User> createUser(@RequestBody User user) {
        users.add(user);
        return users;
    }
}