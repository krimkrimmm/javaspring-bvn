package vn.scrip.buoi23.repository;
import vn.scrip.buoi23.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
}