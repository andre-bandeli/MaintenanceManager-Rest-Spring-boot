package com.br.Estoque.estoque.controller;


import com.br.Estoque.estoque.model.Funcionario;
import com.br.Estoque.estoque.service.FuncionarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    @GetMapping("/funcionarios")
    public String index() {
        return "Funcionarios";
    }

    @GetMapping("/funcionarios/add")
    public Funcionario save(Funcionario funcionario) {
        return funcionarioService.saveFuncionario(funcionario);
    }


}
