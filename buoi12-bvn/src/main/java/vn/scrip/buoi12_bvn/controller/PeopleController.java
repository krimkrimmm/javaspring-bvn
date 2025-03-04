package vn.scrip.buoi12_bvn.controller;
import vn.scrip.buoi12_bvn.model.People;
import vn.scrip.buoi12_bvn.service.PeopleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
@Controller
public class PeopleController {
    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/getAll")
    public String getAllPeople(Model model) {
        model.addAttribute("people", peopleService.getAllPeople());
        return "peopleList";
    }

    @GetMapping("/sortPeopleByFullName")
    public String sortPeopleByFullName(Model model) {
        model.addAttribute("people", peopleService.getPeopleSortedByFullName());
        return "peopleList";
    }
    @GetMapping("/getSortedJobs")
    public String getSortedJobs(Model model) {
        model.addAttribute("jobs", peopleService.getSortedJobs());
        return "sortedJobs";
    }
    @GetMapping("/getSortedCities")
    public String getSortedCities(Model model) {
        model.addAttribute("cities", peopleService.getSortedCities());
        return "sortedCities";
    }
    @GetMapping("/groupPeopleByCity")
    public String groupPeopleByCity(Model model) {
        model.addAttribute("cityGroups", peopleService.groupPeopleByCity());
        return "groupedByCity";
    }
    @GetMapping("/groupJobByCount")
    public String groupJobByCount(Model model) {
        model.addAttribute("jobGroups", peopleService.groupJobByCount());
        return "groupedByJob";
    }
    @GetMapping("/aboveAverageSalary")
    public String aboveAverageSalary(Model model) {
        model.addAttribute("people", peopleService.getPeopleAboveAverageSalary());
        return "aboveAverageSalary";
    }
    @GetMapping("/longestName")
    public String longestName(Model model) {
        model.addAttribute("person", peopleService.getPersonWithLongestName());
        return "longestName";
    }
}





