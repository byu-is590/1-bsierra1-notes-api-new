package edu.byu.is560r.bsierra1notesapinew.service;


import edu.byu.is560r.bsierra1notesapinew.model.User;
import org.springframework.http.ResponseEntity;


public interface UserService {
    User getUserById(Long id);

    User saveUser(User user);
}