package prw3.avaliacao2.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import prw3.avaliacao2.models.Conserto;
import prw3.avaliacao2.models.ConsertoDTO;
import prw3.avaliacao2.models.ConsertoEssencialDTO;
import prw3.avaliacao2.repository.ConsertoDAO;

import java.util.List;


@Service
public class ConsertoService {

    @Autowired
    private ConsertoDAO dao;

    public List<ConsertoEssencialDTO> getAllEssential() {
        return dao.findAll()
                .stream()
                .map(conserto -> new ConsertoEssencialDTO(
                        conserto.getDataEntrada(),
                        conserto.getDataSaida(),
                        conserto.getVeiculo().getMarca(),
                        conserto.getVeiculo().getModelo(),
                        conserto.getMecanico().getNome()))
                .toList();

    }

    public Page<Conserto> getAllPageable(
            Pageable pageable) {
        return dao.findAll(pageable);
    }

    public void save(@Valid ConsertoDTO body){
        dao.save(new Conserto(body));
    }
}
