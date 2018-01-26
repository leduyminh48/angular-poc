package ca.canadiantire.nine.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ca.canadiantire.nine.domain.User;

import static org.junit.Assert.assertTrue;

/**
 * @author Victor Letunovsky
 */
public class UserRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldGetUserIdByEmail() {
        User user = userRepository.getUserByEmail("viktor_letunovskyi@epam.com");
        assertTrue(user.getId() > 0);
    }

}
