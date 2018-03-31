package at.kuchel.controller.rest;

import at.kuchel.Context;
import at.kuchel.api.ProfileResponse;
import at.kuchel.service.rest.UserServiceApi;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping(Context.REST_API + "profiles")
public class ProfileControllerApi {
    private static final Logger LOG = getLogger(ProfileControllerApi.class);

    @Autowired
    private UserServiceApi userService;

    @RequestMapping(method = RequestMethod.GET)
    public ProfileResponse getProfileForUser(@AuthenticationPrincipal User user) {
        LOG.info("Return Profile for user '{}'", user.getUsername());
        return userService.getUserProfile(user);
    }
}
