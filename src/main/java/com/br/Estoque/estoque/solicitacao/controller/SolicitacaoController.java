package com.br.Estoque.estoque.solicitacao.controller;

import com.br.Estoque.estoque.solicitacao.model.Solicitacao;
import com.br.Estoque.estoque.solicitacao.servico.serviceSolicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
public class SolicitacaoController {

    @Autowired
    private serviceSolicitacao solicitacaoService;

    @GetMapping("/solicitacoes")
    public String solicitacoesHome(Model model) {
        Solicitacao solicitacao = new Solicitacao();
        List<Solicitacao> list = solicitacaoService.listSolicitacoes(solicitacao);
        model.addAttribute("solicitacao", list);
        return "template/pages/solicitacao";
    }
    @GetMapping("/so")
    public List<Solicitacao> solicitacaoServicos(Solicitacao solicitacaoServico){
        return solicitacaoService.listSolicitacoes(solicitacaoServico);
    }

    @PostMapping("/add")
    public Solicitacao save(Solicitacao solicitacaoServico) {
        return solicitacaoService.saveSolicitacao(solicitacaoServico);
    }

    @PostMapping("/addList")
    public List<Solicitacao> addListSolicitacoes(List<Solicitacao> solicitacaoServicos) {
        return solicitacaoService.salvarSolicitacoes(solicitacaoServicos);
    }

    @GetMapping("/{id}")
    public Solicitacao getSolicitacaoById(@PathVariable Long id) {
        return solicitacaoService.getSolicitacaoById(id);
    }

    @GetMapping("/remove/{id}")
    public String  removeSolicitacao(@PathVariable Long id) {
        return solicitacaoService.deleteSolicitacaoById(id);
    }

    @PutMapping("/update/{id}")
    public Solicitacao updateSolicitacao(Solicitacao solicitacaoServico) {
        return  solicitacaoService.updateSolicitacao(solicitacaoServico);
    }
}
