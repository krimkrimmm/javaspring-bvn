package vn.scrip.buoi22.repository;
import vn.scrip.buoi22.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CountryRepository extends JpaRepository<Country, Integer> {
}