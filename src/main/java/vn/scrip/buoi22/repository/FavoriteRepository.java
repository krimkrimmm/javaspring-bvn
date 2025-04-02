package vn.scrip.buoi22.repository;
import vn.scrip.buoi22.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
}