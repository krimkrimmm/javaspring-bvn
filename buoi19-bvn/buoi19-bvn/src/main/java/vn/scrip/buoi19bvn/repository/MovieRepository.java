package vn.scrip.buoi19bvn.repository;

import vn.scrip.buoi19bvn.entity.Movie;
import vn.scrip.buoi19bvn.model.enums.MovieType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Page<Movie> findByType(MovieType type, Pageable pageable);
    List<Movie> findTop6ByTypeAndStatusOrderByRatingDesc(MovieType type, boolean status);
}
