package com.br.Estoque.estoque.solicitacao.controller;

import com.br.Estoque.estoque.solicitacao.model.Solicitacao;
import com.br.Estoque.estoque.solicitacao.servico.serviceSolicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SolicitacaoController {

    @Autowired
    private serviceSolicitacao solicitacaoService;

    @GetMapping("/solicitacoes")
    public String index() {
        return "Solicitações";
    }

    @GetMapping("/so")
    public List<Solicitacao> solicitacaoServicos(Solicitacao solicitacaoServico){
        return solicitacaoService.listSolicitacoes(solicitacaoServico);
    }

    @PostMapping("/solicitacoes/add")
    public Solicitacao save(Solicitacao solicitacaoServico) {
        return solicitacaoService.saveSolicitacao(solicitacaoServico);
    }

    @PostMapping("/solicitacoes/addList")
    public List<Solicitacao> addListSolicitacoes(List<Solicitacao> solicitacaoServicos) {
        return solicitacaoService.salvarSolicitacoes(solicitacaoServicos);
    }

    @GetMapping("/solicitacoes/{id}")
    public Solicitacao getSolicitacaoById(@PathVariable Long id) {
        return solicitacaoService.getSolicitacaoById(id);
    }

    @GetMapping("/solicitacoes/remove/{id}")
    public String  removeSolicitacao(@PathVariable Long id) {
        return solicitacaoService.deleteSolicitacaoById(id);
    }

    @PutMapping("/solicitacoes/update/{id}")
    public Solicitacao updateSolicitacao(Solicitacao solicitacaoServico) {
        return  solicitacaoService.updateSolicitacao(solicitacaoServico);
    }
}
