package at.kuchel.service;

import at.kuchel.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User getUserByUsername(String username);

    void addUser(User user);

    List<User> getAllUsers();
}
