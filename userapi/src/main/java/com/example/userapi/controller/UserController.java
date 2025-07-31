package com.example.userapi.controller;


import com.example.userapi.model.User;
import com.example.userapi.model.Country;
import com.example.userapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user-api/v1")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @GetMapping("/additional-info")
    public List<User> getUsersByCountries(@RequestParam String countries) {
        List<Country> countryList = Arrays.stream(countries.split(","))
                .map(String::toUpperCase)
                .map(Country::valueOf)
                .collect(Collectors.toList());
        return service.getUsersByCountries(countryList);
    }
}
