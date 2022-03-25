package com.br.Estoque.estoque.ativos.controller;


import com.br.Estoque.estoque.ativos.model.Ativos;
import com.br.Estoque.estoque.ativos.service.AtivoService;
import com.br.Estoque.estoque.ordem.model.Ordem;
import com.br.Estoque.estoque.ordem.servico.OrdemService;
import com.br.Estoque.estoque.produto.model.ListaCompras;
import com.br.Estoque.estoque.produto.model.Produto;
import com.br.Estoque.estoque.produto.servico.ListaCompraService;
import com.br.Estoque.estoque.produto.servico.ProdutoService;
import com.br.Estoque.estoque.solicitacao.model.Solicitacao;
import com.br.Estoque.estoque.solicitacao.servico.serviceSolicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ativo")
public class AtivoController {

    @Autowired
    private AtivoService ativoService;


    @GetMapping
    public String ativosHome(Model model) {

        Ativos ativos = new Ativos();
        List<Ativos> list = ativoService.listAtivo(ativos);
        model.addAttribute("ativos", list);


        return "template/pages/ativos/ativo";
    }

//    @GetMapping("/list")
//    public String ativosList(Model model) {
//
//        Ativos ativos = new Ativos();
//        List<Ativos> list = ativoService.listAtivo(ativos);
//        model.addAttribute("solicitacao", list);
//
//        return "template/pages/ativos/";
//    }

    @GetMapping("/addAtivo")
    public String addativos(Model model) {
        // create model attribute to bind form data
        Ativos ativos = new Ativos();
        model.addAttribute("ativos", ativos);

        return "template/pages/ativos/ativosAddForm";
    }
    @PostMapping("/saveAtivo")
    public String saveAtivos(@ModelAttribute Ativos ativos, Model model) {
        ativoService.saveAtivo(ativos);
        model.addAttribute("ativos", ativos);
        return "redirect:/ativo";
    }

    @GetMapping("/view/{id}")
    public String getAtivosById(@PathVariable("id") Long id, Model model) {

        Ativos ativos = ativoService.getAtivoById(id);
        model.addAttribute("ativos", ativos);
        return "template/pages/ativos/ativosDescricao";
    }

    @GetMapping("/update/{id}")
    public String updateAtivos(@PathVariable("id") Long id, Model model) {

        Ativos ativos = ativoService.getAtivoById(id);
        model.addAttribute("ativos", ativos);

        return "template/pages/ativos/ativosUpdateForm";
    }
    @PostMapping("/saveUpdate")
    public String saveUpdate(@ModelAttribute Ativos ativos, Model model) {
        ativos.setId(ativos.getId());
        ativos.setCodigo(ativos.getCodigo());
        ativos.setSetor(ativos.getSetor());
        ativos.setDataInicioOperacao(ativos.getDataInicioOperacao());
        ativos.setTipo(ativos.getTipo());
        ativos.setNivelPrioridade(ativos.getNivelPrioridade());

        ativoService.salvarAtivos(ativos);
        model.addAttribute("ativos", ativos);
        return "redirect:/ativo";
    }

//    @GetMapping("/so")
//    public List<Solicitacao> solicitacaoServicos(Solicitacao solicitacaoServico){
//        return solicitacaoService.listSolicitacoes(solicitacaoServico);
//    }

//    @PostMapping("/addList")
//    public List<Ativos> addListSolicitacoes(Ativos ativos) {
//        return ativoService.salvarAtivos(ativos);
//    }


    @GetMapping("/remove/{id}")
    public String  removeAtivos(@PathVariable Long id) {

        ativoService.deleteAtivoById(id);
        return "/template/index";
    }
}
