package com.example.fordav;

import com.example.fordav.controller.UserController;
import com.example.fordav.entity.UserInput;
import com.example.fordav.repository.UserRepository;
import com.example.fordav.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class FordAvApplicationTests {

    @Autowired
    private UserController controller;

    @Mock
    UserService service;

    @Mock
    UserRepository repository;


    @Test
    void contextLoads() {
    }

    @Test
    void addUserControllerTest(){
        when(repository.save(any())).thenReturn(1);
        UserInput userInput = new UserInput("Sri Harsha", "Akurathi");
        Assertions.assertEquals(1, controller.addUser(userInput));
    }

    @Test
    void addUserServiceTest(){
        UserInput userInput = new UserInput("Sri Harsha", "Akurathi");
        when(repository.save(any())).thenReturn(1);
        ArgumentCaptor<UserInput> fullName = ArgumentCaptor.forClass(UserInput.class);
        service.addUser(userInput);
        verify(service).addUser(fullName.capture());
        Assertions.assertEquals(userInput, fullName.getValue());
    }
}
