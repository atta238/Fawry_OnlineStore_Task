import Inventory.Inventory;
import Main_Classes.Book;
import Main_Classes.Demo_Book;
import Main_Classes.EBook;
import Main_Classes.Paper_Book;

import java.util.List;

public class Testing {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.add_books(new Paper_Book("PB123", "Java Programming", 2000, 29.99, 10));
        inventory.add_books(new EBook("EB456", "Python Programming", 2010, 14.99, "PDF"));
        inventory.add_books(new Demo_Book("SB789", "Kotlin Basics", 2021, 0.0));

        try {
            System.out.println("Paid Amount : "+inventory.buy_book("SB789", 1, "mohamed@gmail.com", "")); //Demo_Book not for sale
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try{
            System.out.println("Paid Amount : "+inventory.buy_book("EB456", 12, "ahmed@gmail.com", "") + "$"); // showing paid amount ( quantity not used in EBook)
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Paid Amount : "+inventory.buy_book("PB123", 11, "atta@gmail.com", "123 Main Street") + "$"); // showing not enough stock of paper_book
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Paid Amount : "+inventory.buy_book("PB123", 8, "atta@gmail.com", "123 Main Street") + "$"); // showing paid amount for paper_books
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Paid Amount : "+inventory.buy_book("PB123", 3, "atta@gmail.com", "123 Main Street") + "$"); // showing changing stock after the last payment of paper_books
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }


        List<Book>out_dated_books;
        out_dated_books=inventory.remove_out_dated_books(5);
        if(out_dated_books.isEmpty()){
            System.out.println("There is no outdated books");
        }
        else {
            System.out.println("Outdated Books: ");
            for (Book book : out_dated_books) {
                System.out.println("Book's Title: "+book.getTitle()); // Showing out_dated_books
            }
        }
    }
}