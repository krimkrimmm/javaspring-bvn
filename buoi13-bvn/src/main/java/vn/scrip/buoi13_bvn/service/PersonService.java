package vn.scrip.buoi13_bvn.service;
import org.springframework.stereotype.Service;
import vn.scrip.buoi13_bvn.model.Person;
import vn.scrip.buoi13_bvn.repository.PersonRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }
    public void addPerson(Person person) {
        personRepository.save(person);
    }
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}

