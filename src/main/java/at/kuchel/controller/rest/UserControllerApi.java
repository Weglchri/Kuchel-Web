package at.kuchel.controller.rest;

import at.kuchel.Context;
import org.slf4j.Logger;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping(Context.REST_API + "users")
public class UserControllerApi {
    private static final Logger LOG = getLogger(UserControllerApi.class);

    @RequestMapping(method = RequestMethod.GET)
    public void areUserCredentialsValid(@AuthenticationPrincipal User user) {
        LOG.info("User sent valid Credentials '{}'", user.getUsername());
    }
}
