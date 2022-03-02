package edu.byu.is560r.bsierra1notesapinew.service;

import org.springframework.stereotype.Service;

import edu.byu.is560r.bsierra1notesapinew.model.User;
import edu.byu.is560r.bsierra1notesapinew.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@Service
@AllArgsConstructor
public class DummyUserService implements UserService {

    private String salt;
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        var user = userRepository.findFirstById(id);
        return user;
    }

    @Override
    public User saveUser(User user) {
        user.setCreatedAt(Instant.now());
        user.setPasswordHash(DigestUtils.sha256Hex(user.getPassword() + salt));
        return userRepository.save(user);
    }

}