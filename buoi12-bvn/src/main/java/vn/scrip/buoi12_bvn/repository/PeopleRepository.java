package vn.scrip.buoi12_bvn.repository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import vn.scrip.buoi12_bvn.model.People;
import org.springframework.stereotype.Repository;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PeopleRepository {
    private final List<People> peopleList = new ArrayList<>();
    @PostConstruct
    public PeopleRepository() {
        loadPeopleData();
    }

    private void loadPeopleData() {
        try (InputStream inputStream = new ClassPathResource("people.csv").getInputStream();
             InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             CSVReader reader = new CSVReader(streamReader)) {

            List<String[]> records = reader.readAll();
            for (String[] nextLine : records) {
                if (nextLine.length >= 4) { // Đảm bảo đủ cột dữ liệu
                    try {
                        double salary = Double.parseDouble(nextLine[3]);
                        peopleList.add(new People(nextLine[0], nextLine[1], nextLine[2], salary));
                    } catch (NumberFormatException e) {
                        System.err.println("Lỗi chuyển đổi lương: " + nextLine[3]);
                    }
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    public List<People> findAll() {
        return peopleList;
    }
}
