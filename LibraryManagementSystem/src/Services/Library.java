package Services;

import Models.Book;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Attribute
//The Library class manages a collection of books.
// It handles adding, removing, searching, borrowing, and returning books.

public class Library {

    //List to store the books
    private final List<Book> listOfBook = new ArrayList<>();

    public Library() {
    }


    //toString

    @Override
    public String toString() {
        System.out.println();
        return "Library{" +
                "listOfBook=" + listOfBook +
                '}';
    }


    //Methods

    //TO add the books
    public void addBook(String isbn, String title, String author, boolean isBorrowed) {
        Book book = new Book(isbn, title, author, isBorrowed);
        listOfBook.add(book);
    }

    //to display the books in my local database
    public void display() {
        for (Book book : listOfBook) {
            System.out.println(book);
        }
    }

    //Find a book by ISBN and remove it.
    public void removeBook(String ISBN) {
        Iterator<Book> iterator = listOfBook.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (ISBN.equals(book.getIsbn())) {
                iterator.remove();
                System.out.println("✅ Book removed: " + book.getTitle());
                return;
            }
        }
        System.out.println("❌ Book with ISBN " + ISBN + " not found.");
    }


    //Return matching books (partial match can use .contains()).
    public List<Book> searchByTitle(String title) {

        List<Book> listOfBookPresent = new ArrayList<>();
        for (int i = 0; i < listOfBook.size(); i++) {
            Book book = listOfBook.get(i);
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                listOfBookPresent.add(book);
            }
        }
        return listOfBookPresent;
    }

    //         searchByAuthor(String author)
    public List<Book> searchByAuthor(String author) {
        List<Book> listOfBookPresent = new ArrayList<>();
        for (int i = 0; i < listOfBook.size(); i++) {
            Book book = listOfBook.get(i);
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                listOfBookPresent.add(book);
            }
        }
        return listOfBookPresent;
    }

    //Mark book as isBorrowed = true only if it's available.
    public void borrowBook(String isbn) {
        for (Book book : listOfBook) {
            if (isbn.equals(book.getIsbn())) {
                if (book.isBorrowed()) {
                    System.out.println("❌ Book is already borrowed: " + book.getTitle());
                } else {
                    book.setBorrowed(true);  // ✅ Mark it as borrowed
                    System.out.println("✅ Book borrowed successfully: " + book.getTitle());
                }
                return; // Exit after finding the book
            }
        }
        System.out.println("❌ Book with ISBN " + isbn + " not found.");
    }


    //Mark book as isBorrowed = false.
    public void returnBook(String isbn) {
        for (Book book : listOfBook) {
            if (isbn.equals(book.getIsbn())) {
                if (book.isBorrowed()) {
                    book.setBorrowed(false);  // ✅ Mark it as returned
                    System.out.println("✅ Book returned successfully: " + book.getTitle());
                } else {
                    System.out.println("⚠️ This book was not borrowed: " + book.getTitle());
                }
                return; // Exit after finding the book
            }
        }
        System.out.println("❌ Book with ISBN " + isbn + " not found.");
    }


    //Filter the list based on isBorrowed status.
    public void listAvailableBooks() {
        boolean anyAvailable = false;
        for (Book book : listOfBook) {
            if (!book.isBorrowed()) {
                System.out.println(book);  // Print directly
                anyAvailable = true;
            }
        }
        if (!anyAvailable) {
            System.out.println("📕 No available books at the moment.");
        }
    }
    //listBorrowedBooks()
    //Filter the list based on isBorrowed status.
    public void listBorrowedBooks() {
        boolean anyAvailable = false;
        for (Book book : listOfBook) {
            if (book.isBorrowed()) {
                System.out.println(book);  // Print directly
                anyAvailable = true;
            }
        }
        if (!anyAvailable) {
            System.out.println("No books are currently borrowed.");
        }
    }
}
