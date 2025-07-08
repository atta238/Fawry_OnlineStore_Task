package Inventory;

import Main_Classes.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private Map<String, Book> inventory_books= new HashMap<>();

    public void add_books(Book s){
        inventory_books.put(s.getISBN(),s);
    }
    public void remove_books(String ISBN){
        if(inventory_books.containsKey(ISBN)){
            inventory_books.remove(ISBN);
        }
        else{
            System.out.println("Book with "+ISBN+" is not found");
        }
    }
    public List<Book> remove_out_dated_books(int max_year){
        int curr_year=LocalDate.now().getYear();
        List<Book> books_outdated = new ArrayList<>();
        for(String i : inventory_books.keySet()){
            if( max_year < (curr_year - inventory_books.get(i).getYear()) ){
                books_outdated.add(inventory_books.get(i));
            }
        }
        for(Book b : books_outdated){
            inventory_books.remove(b.getISBN());
        }
        return books_outdated;
    }
    public double buy_book(String ISBN, int quantity,String email,String address){
        if(!inventory_books.containsKey(ISBN)){
            throw new RuntimeException("Book with ISBN " + ISBN + " is not found");
        }
        return inventory_books.get(ISBN).buy_book(quantity,email,address);
    }
}
