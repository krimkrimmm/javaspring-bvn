package vn.scrip.buoi11.utils.file;
import org.apache.logging.log4j.Logger;
import vn.scrip.buoi11.model.Book;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
@Component
public class JsonfileReader implements IfileReader {
    private Logger log;

    @Override
    public List<Book> readFile(String filePath)
    {
        log.info("Json file");
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(filePath), new TypeReference<List<Book>>() {});
        } catch (IOException e) {
            log.error("Error reading JSON file: {}", filePath, e);

            return List.of();
        }
    }
}