package vn.scrip.buoi13_bvn.controller;
import org.springframework.web.bind.annotation.*;
import vn.scrip.buoi13_bvn.model.Person;
import vn.scrip.buoi13_bvn.service.PersonService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping
    public List<Person> getAllPersons()
    {
        return personService.getAllPersons();
    }
    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }
    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }
}







