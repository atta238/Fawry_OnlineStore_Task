package Services;

import Main_Classes.Paper_Book;

public interface ShippingService {
    void send_book(Paper_Book book, String address);
}
