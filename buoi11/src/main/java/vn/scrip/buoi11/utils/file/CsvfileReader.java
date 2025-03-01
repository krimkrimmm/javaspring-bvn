package vn.scrip.buoi11.utils.file;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import vn.scrip.buoi11.model.Book;
import java.io.IOException;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Component
public class CsvfileReader implements IfileReader
{
    private Logger log;
    @Override
    public List<Book> readFile(String filePath) {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            CsvToBean<Book> csvToBean = new CsvToBeanBuilder<Book>(reader)
                    .withType(Book.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        }
        catch (IOException e) {
            log.error("Lỗi khi đọc file CSV: {}", filePath, e);
            return List.of(); // Trả về danh sách rỗng thay vì null
        }
    }
}






