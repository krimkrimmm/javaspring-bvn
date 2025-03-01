package vn.scrip.buoi11.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Shop {
    // C1: Field injection

//    @Autowired
//    private Book book;

    // C2: Constructor injection
    private String name;
    private final Book book;

    public Shop(Book book) {
        this.book = book;
    }
//    public Shop(Book book) {
//        this.book = book;
//    }
}