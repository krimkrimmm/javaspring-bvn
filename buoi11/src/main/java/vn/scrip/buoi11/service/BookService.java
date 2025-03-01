package vn.scrip.buoi11.service;
import vn.scrip.buoi11.model.Book;
import java.util.List;
public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(String id);
}


