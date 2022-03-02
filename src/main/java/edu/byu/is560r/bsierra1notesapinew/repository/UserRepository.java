package edu.byu.is560r.bsierra1notesapinew.repository;

import edu.byu.is560r.bsierra1notesapinew.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User, Long>  {
    User findFirstById(Long id);
}
