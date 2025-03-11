package vn.scrip.buoi13_bvn.controller;

import vn.scrip.buoi13_bvn.model.Person;
import vn.scrip.buoi13_bvn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{id}")
    public String getPersonDetail(@PathVariable Long id, Model model) {
        Person person = personService.getPersonById(id);
        List<Person> relatedPersons = personService.getRelatedPersons(id);

        model.addAttribute("person", person);
        model.addAttribute("relatedPersons", relatedPersons);
        return "person";
    }
}
