package ca.canadiantire.nine.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.canadiantire.nine.dto.UserLoginDto;
import ca.canadiantire.nine.service.UserService;

/**
 * @author Victor Letunovsky
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Long authenticate(@RequestBody UserLoginDto userLoginDto) {
        return userService.getUserIdByEmail(userLoginDto.getUsername());
    }

}
