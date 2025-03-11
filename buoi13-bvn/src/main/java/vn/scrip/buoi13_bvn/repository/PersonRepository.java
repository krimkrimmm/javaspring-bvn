package vn.scrip.buoi13_bvn.repository;
import vn.scrip.buoi13_bvn.model.Person;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {
    private List<Person> people = new ArrayList<>();
    public PersonRepository() {
        people.add(new Person(1L, "Alice", "male"));
        people.add(new Person(2L, "Bob", "male"));
        people.add(new Person(3L, "Charle", "female"));
        people.add(new Person(4L, "Emma", "female"));
        people.add(new Person(5L, "Dave", "male"));

        people.add(new Person(6L, "Fiona", "female"));
        people.add(new Person(7L, "George", "Male"));
        people.add(new Person(8L, "Hannah", "male"));
    }
    public List<Person> findAll() {
        return people;
    }
    public Optional<Person> findById(Long id) {
        return people.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
}

