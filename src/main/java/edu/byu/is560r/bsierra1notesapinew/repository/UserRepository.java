package edu.byu.is560r.bsierra1notesapinew.repository;


import edu.byu.is560r.bsierra1notesapinew.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findFirstById(Long id);
    Optional<User> findFirstByEmail(String email);
}