package at.kuchel.tmp;

import at.kuchel.model.User;
import at.kuchel.repostitory.UserRepository;
import at.kuchel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Analyzer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    public Analyzer (UserRepository userRepository, UserService userService){
        User newUser = new User();
        newUser.setUsername("tempuser");
        newUser.setBirthday(LocalDate.now());
        newUser.setPassword("gemheim");


        System.out.println(newUser);
        userService.addUser(newUser);

        System.out.println(userRepository.findOneByUsername("tempuser"));
        System.out.println(userRepository.findAll().size());

    }

}
