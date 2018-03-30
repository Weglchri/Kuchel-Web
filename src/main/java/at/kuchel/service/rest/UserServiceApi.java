package at.kuchel.service.rest;

import at.kuchel.api.ProfileResponse;
import at.kuchel.mapper.ProfileMapper;
import at.kuchel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceApi {

    private final UserService userService;
    private final ProfileMapper profileMapper;

    @Autowired
    public UserServiceApi(ProfileMapper profileMapper, UserService userService) {
        this.profileMapper = profileMapper;
        this.userService = userService;
    }

    public ProfileResponse getUserprofile(User user) {
        return profileMapper.map(userService.getUserByUsername(user.getUsername()));
    }


}
