package at.kuchel.service;

import at.kuchel.model.User;
import at.kuchel.repostitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserByUsername(String username){
        return userRepository.findOneByUsername(username);
    }

    public void addUser(User user){
        userRepository.save(user);
    }

}
