package Models;

import Models.Book;
import Exceptions.*;
import Models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Library class manages books, users, and borrowing/returning operations.
 */
public class Library {

    private List<Book> books;   // list of all books in the library
    private List<User> users;   // list of all registered users

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // ------------------ BOOK OPERATIONS ------------------

    /**
     * Add a book to the library
     */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    /**
     * Find a book by ISBN
     */
    public Book findBookByIsbn(String isbn) throws BookNotFoundException {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                return b;
            }
        }
        throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
    }

    // ------------------ USER OPERATIONS ------------------

    /**
     * Add a user
     */
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    /**
     * Find a user by their ID
     */
    public User findUserById(int userId) throws UserNotFoundException {
        for (User u : users) {
            if (u.getUserId() == userId) {
                return u;
            }
        }
        throw new UserNotFoundException("User with ID " + userId + " not found.");
    }

    // ------------------ BORROW / RETURN OPERATIONS ------------------

    /**
     * Borrow a book for a given user
     */
    public void borrowBook(String isbn, int userId)
            throws BookNotFoundException, UserNotFoundException, BookAlreadyBorrowedException {
        Book book = findBookByIsbn(isbn);
        User user = findUserById(userId);

        if (book.isBorrowed()) {
            throw new BookAlreadyBorrowedException("Book " + book.getTitle() + " is already borrowed.");
        }

        book.markBorrowed();      // ✅ safer way
        user.borrowBook(book);
        System.out.println(user.getName() + " borrowed " + book.getTitle());
    }

    /**
     * Return a book for a given user
     */
    public void returnBook(String isbn, int userId)
            throws BookNotFoundException, UserNotFoundException, BookNotBorrowedException {
        Book book = findBookByIsbn(isbn);
        User user = findUserById(userId);

        if (!book.isBorrowed()) {
            throw new BookNotBorrowedException("Book " + book.getTitle() + " was not borrowed.");
        }

        book.markReturned();      // ✅ safer way
        user.returnBook(book);
        System.out.println(user.getName() + " returned " + book.getTitle());
    }

    // ------------------ DISPLAY METHODS ------------------

    /**
     * Display all books in the library
     */
    public void displayBooks() {
        System.out.println("📚 Library Books:");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    /**
     * Display all registered users
     */
    public void displayUsers() {
        System.out.println("👤 Library Users:");
        for (User u : users) {
            System.out.println(u);
        }
    }
}
