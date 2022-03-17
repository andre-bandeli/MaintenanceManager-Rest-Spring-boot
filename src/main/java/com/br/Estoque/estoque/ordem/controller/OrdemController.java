package com.br.Estoque.estoque.ordem.controller;

import com.br.Estoque.estoque.ordem.model.Ordem;
import com.br.Estoque.estoque.ordem.servico.OrdemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdemController {

    @Autowired
    private OrdemService ordemService;

    @GetMapping("/ordem")
    public String index() {
        return "Ordens";
    }

    @PostMapping("/ordem/add")
    public Ordem save(Ordem ordemServico){
        return ordemService.saveOrdem(ordemServico);
    }

    @PostMapping("/ordem/addList")
    public List<Ordem> addListOrdem(List<Ordem> ordemServico) {
        return ordemService.salvarOrdem(ordemServico);
    }

    @GetMapping("/ordem/{id}")
    public Ordem getOrdemById(@PathVariable Long id) {
        return ordemService.getOrdemById(id);
    }

    @GetMapping("/ordem/remove/{id}")
    public String  removeOrdem(@PathVariable Long id) {
        return ordemService.deleteOrdemById(id);
    }

    @PutMapping("/ordem/update/{id}")
    public Ordem updateOrdem(Ordem ordemServico) {
        return  ordemService.updateOrdem(ordemServico);
    }
}
