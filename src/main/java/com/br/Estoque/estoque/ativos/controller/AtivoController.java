package com.br.Estoque.estoque.ativos.controller;


import com.br.Estoque.estoque.ativos.model.Ativos;
import com.br.Estoque.estoque.ativos.service.AtivoService;
import com.br.Estoque.estoque.produto.model.ListaCompras;
import com.br.Estoque.estoque.produto.model.Produto;
import com.br.Estoque.estoque.produto.servico.ListaCompraService;
import com.br.Estoque.estoque.produto.servico.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ativo")
public class AtivoController {

    @Autowired
    private AtivoService service;

    @GetMapping
    public String AtivoHome(Model model) {
        Ativos ativos = new Ativos();
        List<Ativos> list = service.listAtivos(ativos);
        model.addAttribute("ativo", list);

        return "template/pages/ativos/ativo";
    }

    @PostMapping("/add")
    public Ativos addAtivo(@RequestBody Ativos ativos) {
        return service.save(ativos);
    }
}
