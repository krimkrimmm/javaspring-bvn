package vn.scrip.buoi12_bvn.service;
import vn.scrip.buoi12_bvn.model.People;
import vn.scrip.buoi12_bvn.repository.PeopleRepository;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
    public List<People> getAllPeople() {
        return peopleRepository.findAll();
    }
    public List<People> getPeopleSortedByFullName() {
        return peopleRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(People::getFullName))
                .collect(Collectors.toList());
    }
    public List<String> getSortedJobs() {
        return peopleRepository.findAll()
                .stream()

                .map(People::getJob)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
    public List<String> getSortedCities() {
        return peopleRepository.findAll()
                .stream()
                .map(People::getCity)

                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
    public Map<String, List<People>> groupPeopleByCity() {
        return peopleRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(People::getCity));
    }

    public Map<String, Long> groupJobByCount() {
        return peopleRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(People::getJob, Collectors.counting()));
    }
    public List<People> getPeopleAboveAverageSalary() {
        double avgSalary = peopleRepository.findAll()
                .stream()
                .mapToDouble(People::getSalary)

                .average()
                .orElse(0);
        return peopleRepository.findAll()
                .stream()
                .filter(p -> p.getSalary() > avgSalary)
                .collect(Collectors.toList());
    }















    public People getPersonWithLongestName() {
        return peopleRepository.findAll()
                .stream()
                .max(Comparator.comparingInt(p -> p.getFullName().length()))
                .orElse(null);
    }
}


