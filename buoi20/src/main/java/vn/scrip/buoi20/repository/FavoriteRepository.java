package vn.scrip.buoi20.repository;
import vn.scrip.buoi20.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
}