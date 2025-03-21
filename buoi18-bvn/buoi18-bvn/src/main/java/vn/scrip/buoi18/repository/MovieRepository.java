package vn.scrip.buoi18.repository;

import vn.scrip.buoi18.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Page<Movie> findByType(String type, Pageable pageable);
}
