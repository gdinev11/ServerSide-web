package edu.neiu.finalprojsswd.security;

import edu.neiu.finalprojsswd.data.UserRepository;
import edu.neiu.finalprojsswd.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserDataLoader implements CommandLineRunner {

    private UserRepository userRepo;
    private BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UserDataLoader(UserRepository userRepo, BCryptPasswordEncoder passwordEncoder){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("gdinev@neiu.edu", "GDinny", passwordEncoder.encode("password"), "George");
        user1.setRoles(Set.of(User.Role.ROLE_ADMIN));
        user1.setEnabled(true);
        userRepo.save(user1);

        User user2 = new User("foo2@foo.com", "foo2", passwordEncoder.encode("password"), "foo");
        user2.setRoles(Set.of(User.Role.ROLE_USER));
        user2.setEnabled(true);
        userRepo.save(user2);

    }
}
