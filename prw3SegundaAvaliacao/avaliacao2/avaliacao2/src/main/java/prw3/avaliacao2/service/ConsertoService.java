package prw3.avaliacao2.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import prw3.avaliacao2.models.*;
import prw3.avaliacao2.repository.ConsertoDAO;

import java.util.List;
import java.util.Optional;


@Service
public class ConsertoService {

    @Autowired
    private ConsertoDAO dao;

    public List<ConsertoEssencialDTO> getAllEssential() {
        return dao.findAllByAtivoTrue()
                .stream()
                .map(ConsertoEssencialDTO::new)
                .toList();
    }

    public Page<ConsertoDTO> getAllPageable(
            Pageable pageable) {
        return dao.findAll(pageable).map(conserto -> new ConsertoDTO(
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                new MecanicoDTO(
                        conserto.getMecanico().getNome(),
                        conserto.getMecanico().getAnosExperiencia()),
                new VeiculoDTO(
                        conserto.getVeiculo().getMarca(),
                        conserto.getVeiculo().getModelo(),
                        conserto.getVeiculo().getAno(),
                        conserto.getVeiculo().getCor())));
    }


    public Optional<ConsertoDTO> getConsertoById(int id) {
        var consertoOPT = dao.findById(id);
        if (consertoOPT.isEmpty()) return Optional.empty();
        var conserto = consertoOPT.get();
        return Optional.of(
                new ConsertoDTO(
                        conserto.getDataEntrada(),
                        conserto.getDataSaida(),
                        new MecanicoDTO(
                                conserto.getMecanico().getNome(),
                                conserto.getMecanico().getAnosExperiencia()),
                        new VeiculoDTO(
                                conserto.getVeiculo().getMarca(),
                                conserto.getVeiculo().getModelo(),
                                conserto.getVeiculo().getAno(),
                                conserto.getVeiculo().getCor())));
    }

    public Conserto save( ConsertoDTO body) {
        var conserto = new Conserto(body);
        dao.save(conserto);
        return conserto;

    }

    public boolean delete(int id) {
        var conserto = dao.findById(id);
        if (conserto.isEmpty()) return false;
        conserto.get().excluir();
        return true;
    }

    public Optional<ConsertoDTO> update(ConsertoAtualizarDTO dto, int id) {
        var consertoOptional = dao.findById(id);

        if (consertoOptional.isEmpty()) {
            return Optional.empty();
        }

        var conserto = consertoOptional.get();
        conserto.update(dto);

        return Optional.of(
                new ConsertoDTO(
                        conserto.getDataEntrada(),
                        conserto.getDataSaida(),
                        new MecanicoDTO(conserto.getMecanico()),
                        new VeiculoDTO(conserto.getVeiculo())
                )
        );
    }
}
