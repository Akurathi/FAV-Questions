package com.example.fordav.service;

import com.example.fordav.entity.User;
import com.example.fordav.entity.UserInput;
import com.example.fordav.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Long addUser(UserInput input) {
        String fullName = input.getFirstName() + " " + input.getLastName();
        User user = new User(fullName);
        return repository.save(user).getId();
    }
}
