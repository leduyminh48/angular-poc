package ca.canadiantire.nine.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ca.canadiantire.nine.dao.UserRepository;
import ca.canadiantire.nine.domain.Product;
import ca.canadiantire.nine.domain.User;
import ca.canadiantire.nine.dto.UserLoginDto;
import ca.canadiantire.nine.exception.UserNotFoundException;
import ca.canadiantire.nine.service.EmailService;
import ca.canadiantire.nine.service.ProductService;
import ca.canadiantire.nine.service.UserService;

/**
 * @author Victor Letunovsky
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Long authenticate(@RequestBody UserLoginDto userLoginDto) {
        final Long userId = userService.getUserIdByEmail(userLoginDto.getUsername());

        final User user = userRepository.findOne(userId);
        final List<Product> products = new ArrayList<>(productService.getMostPopularProducts());
        emailService.sendRepeatableItemsOrderedNotification(user.getEmail(), user, products);

        return userId;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFoundException(UserNotFoundException ex) {
        return String.format("User '%s' was not found", ex.getUserName());
    }
}
