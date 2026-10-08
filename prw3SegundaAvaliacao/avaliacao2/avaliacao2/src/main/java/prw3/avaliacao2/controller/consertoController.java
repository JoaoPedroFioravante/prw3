package prw3.avaliacao2.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import prw3.avaliacao2.models.Conserto;
import prw3.avaliacao2.models.ConsertoDTO;
import prw3.avaliacao2.models.ConsertoEssencialDTO;
import prw3.avaliacao2.service.ConsertoService;


import java.util.List;

@RestController
@RequestMapping("conserto")
public class consertoController {

    @Autowired
    private ConsertoService consertoService;

    @PostMapping
    @Transactional
    public void cadastrarConserto(@RequestBody ConsertoDTO body){
        consertoService.save(body);
    }
    @GetMapping("essencial")
    public List<ConsertoEssencialDTO> getAllEssencial(){
        return consertoService.getAllEssential();

    }
    @GetMapping
    public Page<Conserto> getAll(Pageable pageable){
        return consertoService.getAllPageable(pageable);
    }
}
