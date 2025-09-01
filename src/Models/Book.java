package Models;

import java.util.Objects;

/**
 * Represents a Book in the Library system.
 * Each book has a unique ISBN, title, author, and availability status.
 */
public class Book {
    private final String isbn;     // Unique identifier (cannot change)
    private String title;          // Title of the book
    private String author;         // Author name
    private boolean isBorrowed;    // true if currently borrowed, false if available

    /**
     * Constructor to create a new book (default: not borrowed).
     */
    public Book(String isbn, String title, String author) {
        this(isbn, title, author, false);
    }

    /**
     * Constructor with borrowed status (for preloaded data).
     */
    public Book(String isbn, String title, String author, boolean isBorrowed) {
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("ISBN cannot be null/empty");
        }
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isBorrowed = isBorrowed;
    }

    // Getters
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isBorrowed() { return isBorrowed; }

    // Convenience: check if book is available
    public boolean isAvailable() {
        return !isBorrowed;
    }

    // State changes (controlled by Library)
    public void markBorrowed() {
        if (isBorrowed) {
            throw new IllegalStateException("Book already borrowed: " + isbn);
        }
        isBorrowed = true;
    }

    public void markReturned() {
        if (!isBorrowed) {
            throw new IllegalStateException("Book was not borrowed: " + isbn);
        }
        isBorrowed = false;
    }

    // Uniqueness: based only on ISBN
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return String.format("Book[ISBN=%s, Title=%s, Author=%s, Borrowed=%s]",
                isbn, title, author, isBorrowed ? "Yes" : "No");
    }
}
