package Exceptions;

// Exception when a user is not found in the library
public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}
