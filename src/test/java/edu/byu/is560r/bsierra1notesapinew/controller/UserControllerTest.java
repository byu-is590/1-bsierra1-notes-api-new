package edu.byu.is560r.bsierra1notesapinew.controller;

import edu.byu.is560r.bsierra1notesapinew.Application;
import edu.byu.is560r.bsierra1notesapinew.service.UserService;
import org.apache.catalina.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {Application.class, UserController.class,UserService.class})

class UserControllerTest {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    private UserController userController;


//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }

    @Test
    void getUser() {
        Mockito.when(userService.getUserName("SomeId")).thenReturn(("Mock user name"));
        String testName = userController.getUserName("SomeId");
        Assertions.assertEquals("Mock user name", testName);
    }
}