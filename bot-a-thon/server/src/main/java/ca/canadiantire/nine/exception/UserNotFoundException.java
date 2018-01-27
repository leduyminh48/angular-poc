package ca.canadiantire.nine.exception;

/**
 * @author Victor Letunovsky
 */
public class UserNotFoundException extends RuntimeException {

    private final String userName;

    public UserNotFoundException(final String userName) {
        super();
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
