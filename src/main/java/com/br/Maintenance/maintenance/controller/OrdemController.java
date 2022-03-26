package com.br.Maintenance.maintenance.controller;

import com.br.Maintenance.maintenance.model.Ordem;
import com.br.Maintenance.maintenance.service.OrdemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ordem")
public class OrdemController {

    @Autowired
    private OrdemService ordemService;

    @GetMapping
    public String homeOrdem(Model model) {

        Ordem ordem = new Ordem();
        List<Ordem> list = ordemService.listOrdem(ordem);
        model.addAttribute("ordem", list);

        return "template/pages/solicitacao/ordem";
    }

    @GetMapping("/add")
    public String addOrdem(Model model) {
        // create model attribute to bind form data
        Ordem ordem = new Ordem();
        model.addAttribute("ordem", ordem);

        return "template/pages/solicitacao/ordemAddForm";
    }

    @PostMapping("/saveOrdem")
    public String saveOrdem(@ModelAttribute Ordem ordem, Model model) {
        ordemService.saveOrdem(ordem);
        model.addAttribute("ordem", ordem);
        return "/template/index";
    }

    @GetMapping("/view/{id}")
    public String getOrdemById(@PathVariable("id") Long id, Model model) {

        Ordem ordem = ordemService.getOrdemById(id);
        model.addAttribute("ordem", ordem);
        return "template/pages/solicitacao/ordemDescricao";
    }

    @GetMapping("/update/{id}")
    public String updateOrdem(@PathVariable("id") Long id, Model model) {

        Ordem ordem = ordemService.getOrdemById(id);
        model.addAttribute("ordem", ordem);

        return "template/pages/solicitacao/ordemUpdateForm";
    }
    @PostMapping("/saveUpdate")
    public String saveUpdate(@ModelAttribute Ordem ordem, Model model) {

        ordemService.saveOrdem(ordem);
        model.addAttribute("ordem", ordem);
        return "redirect:/ordem";
    }

    @PostMapping("/addList")
    public List<Ordem> addListOrdem(List<Ordem> ordemServico) {
        return ordemService.salvarOrdem(ordemServico);
    }

    @GetMapping("/{id}")
    public Ordem getOrdemById(@PathVariable Long id) {
        return ordemService.getOrdemById(id);
    }

    @GetMapping("/remove/{id}")
    public String  removeOrdem(@PathVariable Long id) {
        ordemService.deleteOrdemById(id);
        return "redirect:/solicitacao";
    }

}
