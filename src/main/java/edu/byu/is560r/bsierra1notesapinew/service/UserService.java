package edu.byu.is560r.bsierra1notesapinew.service;

import edu.byu.is560r.bsierra1notesapinew.model.User;

import java.util.Optional;

public interface UserService {
    User getUserById(Long id);

    Optional<User> getUserByEmail(String email);

    User saveUser(User user);

    boolean validateUserByEmail(String email);
}