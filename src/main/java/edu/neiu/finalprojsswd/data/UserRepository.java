package edu.neiu.finalprojsswd.data;

import edu.neiu.finalprojsswd.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User findByEmal(String email);
}
