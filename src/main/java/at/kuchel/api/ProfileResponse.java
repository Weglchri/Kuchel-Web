package at.kuchel.api;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProfileResponse {

    private String username;
    private Date birthday;
    private String mailAddress;
    private List<String> roles;
}
