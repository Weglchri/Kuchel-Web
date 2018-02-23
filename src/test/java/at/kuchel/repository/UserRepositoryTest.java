package at.kuchel.repository;

import at.kuchel.model.User;
import at.kuchel.repostitory.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void getUserByUsername() {
        User user = userRepository.getUserByUsername("bernhard");
        Assert.assertEquals("bernhard", user.getUsername());
    }

}
