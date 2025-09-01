package Exceptions;

public class BookNotBorrowedException extends Throwable {
    public BookNotBorrowedException(String text) {
        super(text);
    }
}
