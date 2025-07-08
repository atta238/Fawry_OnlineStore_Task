package Main_Classes;

public class Demo_Book extends Book {
    public Demo_Book(String ISBN, String title, int year, double price) {
        super(ISBN, title, year, price);
    }

    @Override
    public void deliver(String email, String address) {
        throw new RuntimeException("Book with ISBN " + ISBN + " is not for sale");
    }
    @Override
    public double buy_book(int quantity, String email, String address) {
        throw new RuntimeException("Book with ISBN " + ISBN + " is not for sale");
    }
}
