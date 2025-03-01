package vn.scrip.buoi11.service.impl;
import vn.scrip.buoi11.model.Book;
import vn.scrip.buoi11.repository.BookRepository;
import vn.scrip.buoi11.service.BookService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }
    @Override
    public Book getBookById(String id){
        //c1: query truc tiep tu db
        //return bookRepository.findById(id);
        //c2: lay toan bo books ra -> tim kiem trong list
        List<Book> books =bookRepository.findAll();
        for (Book book: books)
        {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }
}





