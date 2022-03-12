package com.br.Estoque.estoque.controller;


import com.br.Estoque.estoque.model.Funcionario;
import com.br.Estoque.estoque.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/funcionarios")
    public String index() {
        return "Funcionarios";
    }

    @GetMapping("/funcionarios/add")
    public Funcionario save(Funcionario funcionario) {
        return funcionarioService.saveFuncionario(funcionario);
    }

    @GetMapping("/funcionarios/addList")
    public List<Funcionario> addListFuncionarios(List<Funcionario> funcionarios) {
        return funcionarioService.salvarFuncionarios(funcionarios);
    }

    @GetMapping("/funcionarios/{id}")
    public Funcionario getFuncionarioById(@PathVariable Long id) {
        return funcionarioService.getFuncionarioById(id);
    }

    @GetMapping("/funcionarios/remove/{id}")
    public String  removeFuncionario(@PathVariable Long id) {
        return funcionarioService.deleteFuncionarioById(id);
    }

    @PutMapping("/funcionarios/update/{id}")
    public Funcionario updateFuncionario(Funcionario funcionario) {
        return  funcionarioService.updateFuncionario(funcionario);
    }


}
