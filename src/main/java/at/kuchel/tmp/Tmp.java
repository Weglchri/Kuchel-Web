package at.kuchel.tmp;

import at.kuchel.repostitory.RoleRepository;
import at.kuchel.repostitory.UserRepository;
import at.kuchel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tmp {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

//    @Autowired
//    public Tmp(UserRepository userRepository, UserService userService,RoleRepository roleRepository){
//        User newUser = new User();
//        newUser.setUsername("bob");
//        newUser.setBirthday(LocalDate.now());
//        Role userRole = roleRepository.findByRole("USER");
//        newUser.setRoles(new HashSet<>(Arrays.asList(userRole)));
//        newUser.setPassword("pass");
//
//        userService.addUser(newUser);
//    }
}
