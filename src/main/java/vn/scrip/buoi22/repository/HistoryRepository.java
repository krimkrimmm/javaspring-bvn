package vn.scrip.buoi22.repository;
import vn.scrip.buoi22.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Integer> {
}