package com.br.Estoque.estoque.controller;

import com.br.Estoque.estoque.model.SolicitacaoServico;
import com.br.Estoque.estoque.service.SolicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SolicitacaoController {

    @Autowired
    private SolicitacaoService solicitacaoService;

    @GetMapping("/solicitacoes")
    public String index() {
        return "Solicitações";
    }

    @GetMapping("/solicitacoes/add")
    public SolicitacaoServico save(SolicitacaoServico solicitacaoServico) {
        return solicitacaoService.saveSolicitacao(solicitacaoServico);
    }

    @GetMapping("/solicitacoes/addList")
    public List<SolicitacaoServico> addListSolicitacoess(List<SolicitacaoServico> solicitacaoServicos) {
        return solicitacaoService.salvarSolicitacoes(solicitacaoServicos);
    }

    @GetMapping("/solicitacoes/{id}")
    public SolicitacaoServico getSolicitacaoById(@PathVariable Long id) {
        return solicitacaoService.getSolicitacaoById(id);
    }

    @GetMapping("/solicitacoes/remove/{id}")
    public String  removeSolicitacao(@PathVariable Long id) {
        return solicitacaoService.deleteSolicitacaoById(id);
    }

    @PutMapping("/solicitacoes/update/{id}")
    public SolicitacaoServico updateSolicitacao(SolicitacaoServico solicitacaoServico) {
        return  solicitacaoService.updateSolicitacao(solicitacaoServico);
    }
}
