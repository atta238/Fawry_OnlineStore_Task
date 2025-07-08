package Main_Classes;

public abstract class Book {
    protected String ISBN;
    protected String title;
    protected int year;
    protected double price;
    public Book(String ISBN, String title, int year, double price) {
        this.title = title;
        this.ISBN = ISBN;
        this.price = price;
        this.year = year;
    }
    public String getISBN() {
        return ISBN;
    }
    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }
    public String getTitle() {
        return title;
    }
    public abstract void deliver(String email, String address);
    public abstract double buy_book(int quantity, String email, String address);
}
