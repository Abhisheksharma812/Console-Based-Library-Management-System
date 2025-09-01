package App;

import Exceptions.*;
import Models.*;

public class MAIN {

    public static void main(String[] args) {
        // Create a library instance
        Library library = new Library();

        // Add some books
        library.addBook(new Book("123", "Java Programming", "James Gosling"));
        library.addBook(new Book("456", "Effective Java", "Joshua Bloch"));
        library.addBook(new Book("789", "Clean Code", "Robert C. Martin"));

        // Add some users
        library.addUser(new User(1, "Alice"));
        library.addUser(new User(2, "Bob"));

        // Display current books & users
        library.displayBooks();
        library.displayUsers();

        System.out.println("\n--- Borrowing Books ---");
        try {
            library.borrowBook("123", 1); // Alice borrows Java Programming
            library.borrowBook("456", 2); // Bob borrows Effective Java
            // Trying to borrow the same book again (should throw exception)
            library.borrowBook("123", 2);
        } catch (BookNotFoundException | UserNotFoundException |
                 BookAlreadyBorrowedException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        System.out.println("\n--- Returning Books ---");
        try {
            library.returnBook("123", 1); // Alice returns Java Programming
            // Trying to return a book that wasn’t borrowed (should throw exception)
            library.returnBook("789", 2);
        } catch (BookNotFoundException | UserNotFoundException |
                 BookNotBorrowedException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        System.out.println("\n--- Final Library State ---");
        library.displayBooks();
        library.displayUsers();
    }
}