package com.br.Estoque.estoque.ordem.controller;

import com.br.Estoque.estoque.ordem.model.Ordem;
import com.br.Estoque.estoque.ordem.servico.OrdemService;
import com.br.Estoque.estoque.solicitacao.model.Solicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordem")
public class OrdemController {

    @Autowired
    private OrdemService ordemService;

    @GetMapping("/")
    public String index() {
        return "Ordens";
    }

    @PostMapping("/add")
    public Ordem save(Ordem ordemServico, Solicitacao solicitacao){
        return ordemService.saveOrdem(ordemServico);
    }

    @PostMapping("/addList")
    public List<Ordem> addListOrdem(List<Ordem> ordemServico) {
        return ordemService.salvarOrdem(ordemServico);
    }

    @GetMapping("/{id}")
    public Ordem getOrdemById(@PathVariable Long id) {
        return ordemService.getOrdemById(id);
    }

    @GetMapping("/remove/{id}")
    public String  removeOrdem(@PathVariable Long id) {
        return ordemService.deleteOrdemById(id);
    }

    @PutMapping("/update/{id}")
    public Ordem updateOrdem(Ordem ordemServico) {
        return  ordemService.updateOrdem(ordemServico);
    }
}
