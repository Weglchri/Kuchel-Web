package at.kuchel.util;

import at.kuchel.model.User;
import at.kuchel.repostitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

@Component
public class SessionHelper {

    @Autowired
    private UserRepository userRepository;

    public User getCurrentUser() {
        String currentUserName = getUserNameFromSecuritySession();

        if (!StringUtils.isEmpty(currentUserName)) {
            return userRepository.getUserByUsername(currentUserName);
        }
        throw new IllegalStateException("User have to be set");
    }

    public boolean isUserLoggedIn() {
        return getUserNameFromSecuritySession() != null;
    }

    private String getUserNameFromSecuritySession() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication.getName();
        }
        return null;
    }
}
