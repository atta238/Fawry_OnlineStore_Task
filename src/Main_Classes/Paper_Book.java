package Main_Classes;

import Services.ShippingService;

public class Paper_Book extends Book implements ShippingService {
    private int Stock;
    public Paper_Book(String ISBN, String title, int year, double price,int Stock) {
        super(ISBN, title, year, price);
        this.Stock = Stock;
    }
    public int getStock() {
        return Stock;
    }
    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    @Override
    public void send_book(Paper_Book book, String address) {

    }
    @Override
    public void deliver(String email, String address) {
        send_book(this, address);
    }

    @Override
    public double buy_book(int quantity, String email, String address) {
        if(quantity>this.Stock){
            throw new RuntimeException("There is no enough stock of Book with ISBN " + ISBN);
        }
        this.Stock -= quantity;
        deliver(email, address);
        double paid_amount=quantity*this.price;
        return paid_amount;
    }
}
