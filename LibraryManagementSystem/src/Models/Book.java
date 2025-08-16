package Models;

public class Book {

    //Attributes
    protected  String isbn;            //Unique identifier for the book
    protected String title;           //Title of the book
    protected String author;          //Author's name
    protected boolean isBorrowed;      //Tracks if the book is currently borrowed or not
    //why Use protected, I want that this Attributes can be access by the sub_class Library


    //getter and setter

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    //Constructor

    public Book(String isbn, String title, String author, boolean isBorrowed) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isBorrowed = isBorrowed;
    }

    //toString methods
    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }

//    // lest add some books here
//    public static void main(String[] args) {
//
//        //lest store the book into a list
//        List<Book>list_of_Book = new ArrayList<>();
//        Book book1 = new Book("9780134685991", "Effective Java", "Joshua Bloch", false);
//        Book book2 = new Book("9780596009205", "Head First Java", "Kathy Sierra, Bert Bates", false);
//        Book book3 = new Book("9780132350884", "Clean Code", "Robert C. Martin", false);
//        Book book4 = new Book("9780201633610", "Design Patterns: Elements of Reusable Object-Oriented Software","Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides" ,false);
//        Book book5 = new Book("9781617294945", "Java Concurrency in Practice", "Brian Goetz", false);
//        list_of_Book.add(book1);
//        list_of_Book.add(book2);
//        list_of_Book.add(book3);
//        list_of_Book.add(book4);
//        list_of_Book.add(book5);
//
//        System.out.println(list_of_Book);
//    }
}
