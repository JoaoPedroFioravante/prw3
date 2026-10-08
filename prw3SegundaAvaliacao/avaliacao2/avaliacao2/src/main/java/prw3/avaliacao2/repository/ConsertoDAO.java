package prw3.avaliacao2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import prw3.avaliacao2.models.Conserto;
import prw3.avaliacao2.models.ConsertoDTO;
import prw3.avaliacao2.models.ConsertoEssencialDTO;

import java.util.List;

public interface ConsertoDAO extends JpaRepository<Conserto, Integer> {
    List<Conserto> findAllByAtivoTrue();
}
