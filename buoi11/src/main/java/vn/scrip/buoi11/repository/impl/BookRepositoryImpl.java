package vn.scrip.buoi11.repository.impl;
import vn.scrip.buoi11.db.BookDB;
import vn.scrip.buoi11.model.Book;
import vn.scrip.buoi11.repository.BookRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @Override
    public List<Book> findAll() {
        return BookDB.books;
    }
}





