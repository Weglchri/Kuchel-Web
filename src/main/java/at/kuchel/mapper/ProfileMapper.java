package at.kuchel.mapper;

import at.kuchel.api.ProfileResponse;
import at.kuchel.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileMapper {

    public ProfileResponse map(User user) {
        ProfileResponse response = new ProfileResponse();
        response.setBirthday(user.getBirthday());
        response.setMailAddress(user.getMailAddress());
        response.setUsername(user.getUsername());
        List<String> roles = new ArrayList<>();
        user.getRoles().forEach(role -> roles.add(role.getRole()));
        response.setRoles(roles);
        return response;
    }
}
