package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a User (Library Member).
 * Each user has a unique ID, name, and a list of borrowed books.
 */
public class User {
    private final int userId;                 // Unique user ID
    private String name;                      // User's name
    private final List<Book> borrowedBooks;   // Books currently borrowed

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public int getUserId() { return userId; }
    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    // Update name
    public void setName(String name) { this.name = name; }

    /**
     * Add a book to user's borrowed list (Library handles availability).
     */
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        System.out.println(name + " borrowed: " + book.getTitle());
    }

    /**
     * Remove a book from user's borrowed list.
     */
    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            System.out.println(name + " returned: " + book.getTitle());
        } else {
            System.out.println("Book not found in " + name + "'s borrowed list.");
        }
    }

    @Override
    public String toString() {
        return String.format("User[ID=%d, Name=%s, BorrowedBooks=%d]",
                userId, name, borrowedBooks.size());
    }
}
