package vn.scrip.buoi11.repository;
import vn.scrip.buoi11.model.Book;
import java.util.List;
public interface BookRepository {
    List<Book> findAll();
}



