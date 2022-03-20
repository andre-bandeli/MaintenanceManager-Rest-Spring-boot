package com.br.Estoque.estoque.funcionario.controller;


import com.br.Estoque.estoque.funcionario.model.Funcionario;
import com.br.Estoque.estoque.funcionario.servico.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/")
    public String index() {
        return "Funcionarios";
    }

    @GetMapping("/add")
    public Funcionario save(Funcionario funcionario) {
        return funcionarioService.saveFuncionario(funcionario);
    }

    @GetMapping("/addList")
    public List<Funcionario> addListFuncionarios(List<Funcionario> funcionarios) {
        return funcionarioService.salvarFuncionarios(funcionarios);
    }

    @GetMapping("/{id}")
    public Funcionario getFuncionarioById(@PathVariable Long id) {
        return funcionarioService.getFuncionarioById(id);
    }

    @GetMapping("/remove/{id}")
    public String  removeFuncionario(@PathVariable Long id) {
        return funcionarioService.deleteFuncionarioById(id);
    }

    @PutMapping("/update/{id}")
    public Funcionario updateFuncionario(Funcionario funcionario) {
        return  funcionarioService.updateFuncionario(funcionario);
    }


}
