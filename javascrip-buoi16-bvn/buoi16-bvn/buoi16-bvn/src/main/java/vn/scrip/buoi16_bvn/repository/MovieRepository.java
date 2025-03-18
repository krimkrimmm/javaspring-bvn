package vn.scrip.buoi16_bvn.repository;
import vn.scrip.buoi16_bvn.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
