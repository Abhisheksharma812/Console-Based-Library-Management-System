package Exceptions;

// Exception when trying to borrow a book that is already borrowed
public class BookAlreadyBorrowedException extends Exception {
    public BookAlreadyBorrowedException(String message) {
        super(message);
    }
}