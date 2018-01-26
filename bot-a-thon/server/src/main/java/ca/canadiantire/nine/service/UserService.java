package ca.canadiantire.nine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.canadiantire.nine.dao.UserRepository;

/**
 * @author Victor Letunovsky
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Long getUserIdByEmail(String email) {
        return userRepository.getUserByEmail(email).getId();
    }

}
