package edu.byu.is560r.bsierra1notesapinew.service;

import edu.byu.is560r.bsierra1notesapinew.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.servlet.http.HttpServletRequest;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {UserService.class})
class SimpleUserServiceTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private HttpServletRequest request;

    @Test
    void getUserName() {
        Mockito.when(request.getScheme()).thenReturn("http");
        var userService = new SimpleUserService("salt", userRepository);
        var testEmail = "testUser";
        var testResult = String.format("Hello, %s, from the UserService", testEmail);
        var result = userService.getUserByEmail(testEmail);
        Assertions.assertEquals(testResult, result.get().getEmail());
    }
}