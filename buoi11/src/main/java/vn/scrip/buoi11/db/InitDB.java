package vn.scrip.buoi11.db;
import org.apache.logging.log4j.Logger;
import vn.scrip.buoi11.model.Book;
import vn.scrip.buoi11.utils.file.IfileReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import vn.scrip.buoi11.utils.file.Slf4j;
import java.util.List;
 
@Slf4j
@Configuration
public class InitDB implements CommandLineRunner {
    private final IfileReader fileReader;
    private Logger log;

    public InitDB(@Qualifier("csvFileReader") IfileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Start init data");
        List<Book> books = fileReader.readFile("books.json");
        log.info("Books size: {}", books.size());

        BookDB.books = books;
    }

    // Json: Jackson
    // Csv: OpenCSV
    // Excel: Apache POI
}