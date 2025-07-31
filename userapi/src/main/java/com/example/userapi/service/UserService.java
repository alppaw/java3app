package com.example.userapi.service;

import com.example.userapi.model.User;
import com.example.userapi.model.Country;
import com.example.userapi.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public List<User> getUsersByCountries(List<Country> countries) {
        return repository.findByCountryIn(countries, Sort.by("country").ascending());
    }

}
