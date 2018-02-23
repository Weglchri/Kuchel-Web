package at.kuchel.service;

import at.kuchel.model.User;

import java.util.List;


public interface UserService {

    User getUserByUsername(String username);

    void addUser(User user);

    List<User> getAllUsers();
}
