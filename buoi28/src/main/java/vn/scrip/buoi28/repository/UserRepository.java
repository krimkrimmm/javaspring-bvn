package vn.scrip.buoi26.repository;
import vn.scrip.buoi26.entity.User;
import vn.scrip.buoi26.model.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByRole(UserRole userRole);
    Optional<User> findByEmail(String email);
}








