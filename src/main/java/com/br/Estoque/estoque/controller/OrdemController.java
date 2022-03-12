package com.br.Estoque.estoque.controller;

import com.br.Estoque.estoque.model.OrdemServico;
import com.br.Estoque.estoque.model.SolicitacaoServico;
import com.br.Estoque.estoque.repository.OrdemRepository;
import com.br.Estoque.estoque.service.OrdemService;
import com.br.Estoque.estoque.service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public class OrdemController {

    @Autowired
    private OrdemService ordemService;

    @GetMapping("/ordem")
    public String index() {
        return "Ordens";
    }

    @GetMapping("/ordem/add")
    public OrdemServico save(OrdemServico ordemServico) {
        return ordemService.saveOrdem(ordemServico);
    }

    @GetMapping("/ordem/addList")
    public List<OrdemServico> addListOrdem(List<OrdemServico> ordemServico) {
        return ordemService.salvarOrdem(ordemServico);
    }

    @GetMapping("/ordem/{id}")
    public OrdemServico getOrdemById(@PathVariable Long id) {
        return ordemService.getOrdemById(id);
    }

    @GetMapping("/ordem/remove/{id}")
    public String  removeOrdem(@PathVariable Long id) {
        return ordemServico(id);
    }

    @PutMapping("/ordem/update/{id}")
    public OrdemServico updateOrdem(OrdemServico ordemServico) {
        return  ordemService.updateOrdem(ordemServico);
    }
}
