package vn.scrip.buoi11.utils.file;

import io.micrometer.observation.Observation;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import vn.scrip.buoi11.model.Book;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Component
public class ExcelfileReader implements IfileReader {
    private Logger log;

    @Override
    public List<Book> readFile(String filePath) {
        if (!Files.exists(Paths.get(filePath))) {
            log.error("File không tồn tại: {}", filePath);
            return List.of();
        }

        List<Book> books = new ArrayList<>();
        try (InputStream excelFile = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(excelFile)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            if (rowIterator.hasNext()) rowIterator.next(); // Bỏ qua tiêu đề nếu có

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Book book = new Book();
                book.setId(getCellValueAsString(row.getCell(0)));
                book.setTitle(getCellValueAsString(row.getCell(1)));
                book.setAuthor(getCellValueAsString(row.getCell(2)));
                book.setYear((int) getCellValueAsDouble(row.getCell(3)));

                books.add(book);
            }
        } catch (IOException e) {
            log.error("Lỗi khi đọc file Excel: {}", filePath, e);
        }
        return books;
    }

    private String getCellValueAsString(Cell cell) {
        return cell != null ? switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            default -> "";
        } : "";
    }

    private double getCellValueAsDouble(Cell cell) {
        return (cell != null && cell.getCellType() == CellType.NUMERIC) ? cell.getNumericCellValue() : 0;
    }
}
