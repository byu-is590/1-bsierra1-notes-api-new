package edu.byu.is560r.bsierra1notesapinew.service;

import org.springframework.stereotype.Service;

@Service
public class DummyUserService implements UserService {
    @Override
    public String getUsername(String userName) {
        var user = String.format("Hello, %s, from User Service",userName);
        return user;
    }
}
