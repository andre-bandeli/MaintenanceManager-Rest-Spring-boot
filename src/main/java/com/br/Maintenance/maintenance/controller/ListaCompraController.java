package com.br.Maintenance.maintenance.controller;

import com.br.Maintenance.maintenance.model.ListaCompras;
import com.br.Maintenance.maintenance.service.ListaCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/listaCompra")
@Controller
public class ListaCompraController {

    @Autowired
    private ListaCompraService service;


    @GetMapping("/add")
    public String addListaCompras(Model model) {

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

        service.saveListaCompras(listaCompras);
        model.addAttribute("listaCompras", listaCompras);
        return "redirect:/produto";
    }

}
