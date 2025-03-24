package vn.scrip.buoi20.repository;

import vn.scrip.buoi20.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}

