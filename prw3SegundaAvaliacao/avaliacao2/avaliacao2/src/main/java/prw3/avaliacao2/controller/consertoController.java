package prw3.avaliacao2.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prw3.avaliacao2.models.Conserto;
import prw3.avaliacao2.models.ConsertoDTO;
import prw3.avaliacao2.repository.ConsertoDAO;

import java.util.List;

@RestController
@RequestMapping("conserto")
public class consertoController {

    @Autowired
    private ConsertoDAO consertoDAO;

    @PostMapping
    @Transactional
    public void cadastrarConserto(@RequestBody @Valid ConsertoDTO body){
        consertoDAO.save(new Conserto(body));
    }

    @GetMapping
    public List<Conserto> getAll(){
        return consertoDAO.findAll();

    }
}
