package at.kuchel.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

public class UserUnitTest {


    private User user;
    private Role role;

    @Before
    public void SetupUser() {

        user = new User();
        role = new Role();
        Set<Role> roles = Collections.singleton(role);

        user.setUsername("Random User");
        user.setPassword("***");
        user.setBirthday(LocalDate.now());
        user.setMailAddress("radnom.user@gmail.com");
        user.setRoles(roles);
    }

    @Test
    public void getUserData() {
        Assert.assertEquals("Random User", user.getUsername());
        Assert.assertEquals(true, user.getRoles().contains(role));
    }
}
