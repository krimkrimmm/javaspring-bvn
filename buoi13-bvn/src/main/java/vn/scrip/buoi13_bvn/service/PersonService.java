package vn.scrip.buoi13_bvn.service;
import vn.scrip.buoi13_bvn.model.Person;
import vn.scrip.buoi13_bvn.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.stream.Collectors;
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }
    public List<Person> getRelatedPersons(Long personId) {

        // Lấy thông tin person hiện tại
        Person currentPerson = getPersonById(personId);
        if (currentPerson == null) return List.of();
        // Tìm các person liên quan
        return personRepository.findAll().stream()
                .filter(p -> !p.getId().equals(personId)) // Không trùng ID
                .filter(p -> p.getGender().equals(currentPerson.getGender())) // Cùng gender
                .sorted((p1, p2) -> p2.getId().compareTo(p1.getId())) // Sắp xếp ID giảm dần
                .limit(4) // Giới hạn 4 người

                .collect(Collectors.toList());
    }
}
