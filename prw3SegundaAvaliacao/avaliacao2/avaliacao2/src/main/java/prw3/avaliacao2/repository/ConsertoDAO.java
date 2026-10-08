package prw3.avaliacao2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prw3.avaliacao2.models.Conserto;

public interface ConsertoDAO extends JpaRepository<Conserto, Integer> {
}
