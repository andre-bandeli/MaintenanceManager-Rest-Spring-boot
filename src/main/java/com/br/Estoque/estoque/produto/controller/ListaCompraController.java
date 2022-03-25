package com.br.Estoque.estoque.produto.controller;

import com.br.Estoque.estoque.produto.model.ListaCompras;
import com.br.Estoque.estoque.produto.model.Produto;
import com.br.Estoque.estoque.produto.servico.ListaCompraService;
import com.br.Estoque.estoque.produto.servico.ProdutoService;
import com.br.Estoque.estoque.solicitacao.model.Solicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("listaCompra")
@Controller
public class ListaCompraController {

    @Autowired
    private ListaCompraService service;


    @GetMapping("/add")
    public String addListaCompras(Model model) {
        // create model attribute to bind form data
        ListaCompras listaCompras = new ListaCompras();
        model.addAttribute("listaCompras", listaCompras);

        return "template/pages/estoque/listaCompraAddForm";
    }


    @PostMapping("/saveListaCompras")
    public String saveListaCompras(@ModelAttribute ListaCompras listaCompras, Model model) {
        service.saveListaCompras(listaCompras);
        model.addAttribute("listaCompras", listaCompras);
        return "/template/index";
    }

    @GetMapping("/remove/{id}")
    public String  removeProduto(@PathVariable Long id) {

        service.remove(id);
        return "/template/index";
    }

    @GetMapping("/view/{id}")
    public String getListaComprasById(@PathVariable("id") Long id, Model model) {

        ListaCompras listaCompras = service.listaComprasPorId(id);
        model.addAttribute("listaCompras", listaCompras);
        return "template/pages/estoque/listaCompraDescricao";
    }

    @GetMapping("/update/{id}")
    public String updateListaCompras(@PathVariable("id") Long id, Model model) {

        ListaCompras listaCompras = service.listaComprasPorId(id);
        model.addAttribute("listaCompras", listaCompras);

        return "template/pages/estoque/listaCompraUpdateForm";
    }
    @PostMapping("/saveUpdate")
    public String saveUpdate(@ModelAttribute ListaCompras listaCompras, Model model) {
        listaCompras.setId(listaCompras.getId());
        listaCompras.setCodigo(listaCompras.getCodigo());
        listaCompras.setNome(listaCompras.getNome());
        listaCompras.setDeadline(listaCompras.getDeadline());

        service.saveListaCompras(listaCompras);
        model.addAttribute("listaCompras", listaCompras);
        return "redirect:/produto";
    }

}
