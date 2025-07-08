package Main_Classes;

import Services.MailService;

public class EBook extends Book implements MailService {
    private String filetype;

    public EBook(String ISBN, String title, int year, double price, String filetype) {
        super(ISBN, title, year, price);
        this.filetype = filetype;
    }
    public String getFiletype() {
        return filetype;
    }

    @Override
    public void send_book(EBook book, String email) {

    }
    @Override
    public void deliver(String email, String address) {
        send_book(this, email);
    }

    @Override
    public double buy_book(int quantity, String email, String address) {
        deliver(email, address);
        return this.price;
    }
}
