package com.br.Estoque.estoque.produto.controller;


import com.br.Estoque.estoque.ordem.model.Ordem;
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

@Controller()
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Autowired
    private ListaCompraService listaCompraService;


    @GetMapping
    public String ProdutoHome(Model model) {
        Produto produto = new Produto();
        List<Produto> list = service.listAll(produto);
        model.addAttribute("produto", list);

        ListaCompras listaCompras = new ListaCompras();
        List<ListaCompras> lista = listaCompraService.listAll(listaCompras);
        model.addAttribute("lista", lista);


        return "template/pages/estoque/estoque";
    }


    @GetMapping("/add")
    public String addProduto(Model model) {
        // create model attribute to bind form data
        Produto produto = new Produto();
        model.addAttribute("produto", produto);

        return "template/pages/estoque/produtoAddForm";
    }


    @PostMapping("/saveProduto")
    public String saveProduto(@ModelAttribute Produto produto, Model model) {
        service.saveProduto(produto);
        model.addAttribute("produto", produto);
        return "/template/index";
    }

    @GetMapping("/remove/{id}")
    public String  removeProduto(@PathVariable Long id) {

        service.remove(id);
        return "/template/index";
    }

    @GetMapping("/view/{id}")
    public String getProdutoById(@PathVariable("id") Long id, Model model) {

        Produto produto = service.produtoPorId(id);
        model.addAttribute("produto", produto);
        return "template/pages/estoque/produtoDescricao";
    }

    @GetMapping("/{id}")
    public Produto produtoPorId(@PathVariable Long id) {
        return service.produtoPorId(id);
    }

    @PutMapping("/entrada/{id}/{valor}")
    public Produto entrada(@PathVariable Long id, @PathVariable int valor) {
        return service.entrada(id, valor);
    }

    @PutMapping("/saida/{id}/{valor}")
    public Produto saida(@PathVariable Long id, @PathVariable int valor) {
        return service.saida(id, valor);
    }

}
