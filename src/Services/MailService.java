package Services;

import Main_Classes.EBook;

public interface MailService {
    void send_book(EBook book, String email);
}
