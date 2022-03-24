package com.br.Estoque.estoque.solicitacao.controller;

import com.br.Estoque.estoque.ordem.model.Ordem;
import com.br.Estoque.estoque.ordem.servico.OrdemService;
import com.br.Estoque.estoque.solicitacao.model.Solicitacao;
import com.br.Estoque.estoque.solicitacao.servico.serviceSolicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/solicitacao")
public class SolicitacaoController {

    @Autowired
    private serviceSolicitacao solicitacaoService;

    @Autowired
    private OrdemService ordemService;

    @GetMapping
    public String solicitacoesHome(Model model) {

        Solicitacao solicitacao = new Solicitacao();
        List<Solicitacao> list = solicitacaoService.listSolicitacoes(solicitacao);
        model.addAttribute("solicitacao", list);

        int tamanho = list.size();
        model.addAttribute("tamanho", tamanho);

        Ordem ordem = new Ordem();
        List<Ordem> listOrdem = ordemService.listOrdem(ordem);
        model.addAttribute("ordem", listOrdem);

        int tamanhoOrdem = listOrdem.size();
        model.addAttribute("tamanhoOrdem", tamanhoOrdem);

        return "template/pages/solicitacao/solicitacao";
    }

    @GetMapping("/list")
    public String solicitacoesList(Model model) {

        Solicitacao solicitacao = new Solicitacao();
        List<Solicitacao> list = solicitacaoService.listSolicitacoes(solicitacao);
        model.addAttribute("solicitacao", list);

        return "template/pages/solicitacao/solicitacaoList";
    }

    @GetMapping("/addSolicitacao")
    public String addSolicitacao(Model model) {
        // create model attribute to bind form data
        Solicitacao solicitacao = new Solicitacao();
        model.addAttribute("solicitacao", solicitacao);

        return "template/pages/solicitacao/solicitacaoAddForm";
    }
    @PostMapping("/saveSolicitacao")
    public String saveSolicitacao(@ModelAttribute Solicitacao solicitacao, Model model) {
        solicitacaoService.saveSolicitacao(solicitacao);
        model.addAttribute("solicitacao", solicitacao);
        return "/template/index";
    }

    @GetMapping("/view/{id}")
    public String getSolicitacaoById(@PathVariable("id") Long id, Model model) {

        Solicitacao solicitacao = solicitacaoService.getSolicitacaoById(id);
        model.addAttribute("solicitacao", solicitacao);
        return "template/pages/solicitacao/solicitacaoDescricao";
    }

    @GetMapping("/update/{id}")
    public String updateSolicitacao(@PathVariable("id") Long id, Model model) {

        Solicitacao solicitacao = solicitacaoService.getSolicitacaoById(id);
        model.addAttribute("solicitacao", solicitacao);

        return "template/pages/solicitacao/solicitacaoUpdateForm";
    }
    @PostMapping("/saveUpdate")
    public String saveUpdate(@ModelAttribute Solicitacao solicitacao, Model model) {
        solicitacao.setId(solicitacao.getId());
        solicitacao.setCodigo(solicitacao.getCodigo());
        solicitacao.setMaquina(solicitacao.getMaquina());
        solicitacao.setSetor(solicitacao.getSetor());
        solicitacao.setNomeSolicitante(solicitacao.getNomeSolicitante());
        solicitacao.setDescricao(solicitacao.getDescricao());
        solicitacao.setActive(solicitacao.getActive());

        solicitacaoService.saveSolicitacao(solicitacao);
        model.addAttribute("solicitacao", solicitacao);
        return "redirect:/solicitacao";
    }

    @GetMapping("/so")
    public List<Solicitacao> solicitacaoServicos(Solicitacao solicitacaoServico){
        return solicitacaoService.listSolicitacoes(solicitacaoServico);
    }

    @PostMapping("/addList")
    public List<Solicitacao> addListSolicitacoes(List<Solicitacao> solicitacaoServicos) {
        return solicitacaoService.salvarSolicitacoes(solicitacaoServicos);
    }


    @GetMapping("/remove/{id}")
    public String  removeSolicitacao(@PathVariable Long id) {

        solicitacaoService.deleteSolicitacaoById(id);
        return "/template/index";
    }

}
