package ca.canadiantire.nine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.canadiantire.nine.dao.UserRepository;
import ca.canadiantire.nine.domain.User;
import ca.canadiantire.nine.exception.UserNotFoundException;

/**
 * @author Victor Letunovsky
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Long getUserIdByEmail(String email) {
        User user = userRepository.getUserByEmail(email);
        if (user == null) {
            throw new UserNotFoundException(email);
        }
        return user.getId();
    }

}
