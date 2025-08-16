package App;

import Services.Library;

public class MAIN {
    public static void main(String[] args) {
        Library book = new Library();
        book.addBook("9780134685991", "Effective Java", "Joshua Bloch", false);
        book.addBook("9780596009205", "Head First Java", "Kathy Sierra, Bert Bates", false);
        book.addBook("9780132350884", "Clean Code", "Robert C. Martin", false);
        book.addBook("9780201633610", "Design Patterns: Elements of Reusable Object-Oriented Software","Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides" ,false);
        book.addBook("9781617294945", "Java Concurrency in Practice", "Brian Goetz", false);
        book.display();
//        book.display();
//        book.removeBook("9781617294945");
//        book.display();
//        System.out.println(book.searchByTitle("Effective Java"));
//        System.out.println(book.searchByAuthor("Brian Goetz"));

//        book.borrowBook("9781617294945");
//        book.returnBook("9781617294945");
//        book.borrowBook("9781617294945");

//        book.listAvailableBooks();
        book.removeBook("9781617294945");


    }
}
