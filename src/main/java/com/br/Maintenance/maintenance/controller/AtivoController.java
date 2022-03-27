package com.br.Maintenance.maintenance.controller;


import com.br.Maintenance.maintenance.model.Ativos;
import com.br.Maintenance.maintenance.service.AtivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/ativo")
public class AtivoController {

    @Autowired
    private AtivoService ativoService;


    // Pagina Inicial
    @GetMapping
    public String ativosHome(Model model) {

        List<Ativos> list = ativoService.ativosHome();
        model.addAttribute("ativos", list);

        return "template/pages/ativos/ativo";
    }

    // Adicionar Novo Ativo
    @GetMapping("/addAtivo")
    public String addativos(Model model) {

        Ativos ativos = ativoService.salvarAtivos();
        model.addAttribute("ativos", ativos);

        return "template/pages/ativos/ativosAddForm";
    }

    // Método Salvar Novo Ativo
    @PostMapping("/saveAtivo")
    public String saveAtivos(@ModelAttribute Ativos ativos, Model model) {

        ativoService.saveAtivo(ativos);
        model.addAttribute("ativos", ativos);
        return "redirect:/ativo";
    }

    // Visualizar Ativos por Id
    @GetMapping("/view/{id}")
    public String getAtivosById(@PathVariable("id") Long id, Model model) {

        Ativos ativos = ativoService.getAtivoById(id);
        model.addAttribute("ativos", ativos);
        return "template/pages/ativos/ativosDescricao";
    }

    // Atualizar um Ativo
    @GetMapping("/update/{id}")
    public String updateAtivos(@PathVariable("id") Long id, Model model) {

        Ativos ativos = ativoService.getAtivoById(id);
        model.addAttribute("ativos", ativos);

        return "template/pages/ativos/ativosUpdateForm";
    }

    // Salvar a Atualização
    @PostMapping("/saveUpdate")
    public String saveUpdate(Model model) {

        Ativos ativos=  ativoService.salvarAtivos();
        model.addAttribute("ativos", ativos);

        return "redirect:/ativo";
    }

    // Remover Ativo por Id
    @GetMapping("/remove/{id}")
    public String  removeAtivos(@PathVariable Long id) {

        ativoService.deleteAtivoById(id);
        return "/template/index";
    }
}
