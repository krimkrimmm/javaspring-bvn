package vn.scrip.buoi11.utils.file;
import vn.scrip.buoi11.model.Book;
import java.util.List;
public interface IfileReader {
    List<Book> readFile(String filePath);
}



