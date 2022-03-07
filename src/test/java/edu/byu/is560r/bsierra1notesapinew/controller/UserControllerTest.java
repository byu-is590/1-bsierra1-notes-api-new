package edu.byu.is560r.bsierra1notesapinew.controller;

import edu.byu.is560r.bsierra1notesapinew.Application;
import edu.byu.is560r.bsierra1notesapinew.model.User;
import edu.byu.is560r.bsierra1notesapinew.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Objects;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { Application.class, UserController.class, UserService.class })
class UserControllerTest {

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUser() {
        Mockito.when(userService.getUserById(1l)).thenReturn(new User() {{
            setFirstName("Mock user name");
        }});
        var testName = userController.getUser(1l);
        Assertions.assertEquals("Mock user name", Objects.requireNonNull(testName.getBody()).getFirstName());
    }
}