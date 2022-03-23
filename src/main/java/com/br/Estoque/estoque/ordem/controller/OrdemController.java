package com.br.Estoque.estoque.ordem.controller;

import com.br.Estoque.estoque.ordem.model.Ordem;
import com.br.Estoque.estoque.ordem.servico.OrdemService;
import com.br.Estoque.estoque.solicitacao.model.Solicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ordem")
public class OrdemController {

    @Autowired
    private OrdemService ordemService;

    @GetMapping
    public String homeOrdem(Model model) {

        Ordem ordem = new Ordem();
        List<Ordem> list = ordemService.listOrdem(ordem);
        model.addAttribute("ordem", list);

        return "template/pages/solicitacao/ordem";
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
