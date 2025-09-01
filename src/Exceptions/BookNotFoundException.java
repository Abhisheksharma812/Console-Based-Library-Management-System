package Exceptions;

// Exception when a book is not found in the library
public class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}
