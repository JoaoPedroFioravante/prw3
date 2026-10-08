package prw3.avaliacao2.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import prw3.avaliacao2.models.*;
import prw3.avaliacao2.service.ConsertoService;


import java.util.List;

@RestController
@RequestMapping("conserto")
public class consertoController {

    @Autowired
    private ConsertoService consertoService;

    @PostMapping
    @Transactional
    public ResponseEntity<ConsertoDTO> cadastrarConserto(@RequestBody @Valid ConsertoDTO body, UriComponentsBuilder uriComponentsBuilder) {
        var conserto = consertoService.save(body);
        var uri = uriComponentsBuilder.path("/conserto/{id}").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.
                created(uri).
                body(
                        new ConsertoDTO(
                                conserto.getDataEntrada(),
                                conserto.getDataSaida(),
                                new MecanicoDTO(conserto.getMecanico()),
                                new VeiculoDTO(conserto.getVeiculo())));
    }

    @GetMapping("essencial")
    public  ResponseEntity<List<ConsertoEssencialDTO>> getAllEssencial() {
        return ResponseEntity.ok( consertoService.getAllEssential());

    }

    @GetMapping
    public ResponseEntity<Page<ConsertoDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok( consertoService.getAllPageable(pageable));
    }

    @GetMapping("{id}")
    public ResponseEntity<ConsertoDTO> getConsertoById(@PathVariable int id) {
        var conserto = consertoService.getConsertoById(id);
        return conserto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<ConsertoDTO> logicalDelete(@PathVariable int id) {
        if (consertoService.delete(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<ConsertoDTO> updateConserto(
            @RequestBody @Valid ConsertoAtualizarDTO body, @PathVariable int id) {

        var conserto = consertoService.update(body, id);

        return conserto
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

