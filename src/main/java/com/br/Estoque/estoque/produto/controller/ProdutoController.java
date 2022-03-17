package com.br.Estoque.estoque.produto.controller;


import com.br.Estoque.estoque.produto.model.Produto;
import com.br.Estoque.estoque.produto.servico.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/")
    public String index() {
        return "ok";
    }

    @PostMapping("/produtos/add")
    public Produto addProduto(@RequestBody Produto produto) {
        return service.saveProduto(produto);
    }

    @GetMapping("/produtos")
    public List<Produto> ProdutoAdd() {
        return service.listAll();
    }

    @GetMapping("/produtos/{id}")
    public Produto produtoPorId(@PathVariable Long id) {
        return service.produtoPorId(id);
    }

    @PutMapping("/produtos/entrada/{id}/{valor}")
    public Produto entrada(@PathVariable Long id, @PathVariable int valor) {
        return service.entrada(id, valor);
    }

    @PutMapping("/produtos/saida/{id}/{valor}")
    public Produto saida(@PathVariable Long id, @PathVariable int valor) {
        return service.saida(id, valor);
    }

}
