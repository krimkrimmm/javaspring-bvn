package vn.scrip.buoi20.repository;
import vn.scrip.buoi20.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Integer> {
}