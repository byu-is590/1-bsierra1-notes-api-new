package edu.byu.is560r.bsierra1notesapinew.service;

import org.springframework.stereotype.Service;

@Service
public class DummyUserService implements UserService {
    @Override
    public String getUserName(String userName) {
        return String.format("Hello, %s, from the UserService",userName);
    }
}
