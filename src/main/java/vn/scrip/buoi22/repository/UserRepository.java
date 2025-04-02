package vn.scrip.buoi22.repository;
import vn.scrip.buoi22.entity.User;
import vn.scrip.buoi22.model.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface UserRepository extends JpaRepository<User, Integer>
{
    List<User> findByRole(UserRole userRole);
}
