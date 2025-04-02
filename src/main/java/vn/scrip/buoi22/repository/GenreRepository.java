package vn.scrip.buoi22.repository;
import vn.scrip.buoi22.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}