package vn.scrip.buoi13_bvn.repository;
import org.springframework.stereotype.Repository;
import vn.scrip.buoi13_bvn.model.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {
    private final List<Person> personList = new ArrayList<>();
    public PersonRepository() {
        // Dữ liệu mẫu
        personList.add(new Person(1L, "Alice", "Female", 25));
        personList.add(new Person(2L, "Bob", "Male", 30));
        personList.add(new Person(3L, "Charlie", "Male", 22));
        personList.add(new Person(4L, "Diana", "Female", 29));
    }

    public List<Person> findAll() {
        return new ArrayList<>(personList); // Trả về bản sao danh sách để tránh thay đổi dữ liệu gốc
    }

    public Optional<Person> findById(Long id) {
        return personList.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
    public void save(Person person)
    {
        personList.add(person);
    }

    public void deleteById(Long id) {
        personList.removeIf(p -> p.getId().equals(id));
    }
}





