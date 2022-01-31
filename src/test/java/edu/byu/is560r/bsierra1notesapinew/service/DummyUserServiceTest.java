package edu.byu.is560r.bsierra1notesapinew.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DummyUserServiceTest {

    @Test
    public void getUserName() {
        var dummyUserService = new DummyUserService();
        var testUser = "testUser";
        var testResult = String.format("Hello, %s, from the UserService", testUser);
        var result = dummyUserService.getUserName(testUser);
        Assertions.assertEquals(testResult, result);
    }
}