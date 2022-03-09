package com.br.Estoque.estoque.service;


import com.br.Estoque.estoque.model.Funcionario;
import com.br.Estoque.estoque.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario saveFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public List <Funcionario>  salvarFuncionarios(List <Funcionario>  funcionarios) {
        return funcionarioRepository.saveAll(funcionarios);
    }

    public List<Funcionario> listFuncionarios(Funcionario funcionario) {
        return funcionarioRepository.findAll();
    }

    public Funcionario getFuncionarioById(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    public String deleteFuncionarioById(Long id) {
        funcionarioRepository.deleteById(id);
        return "Funcionario removido!!" + id;
    }

    public Funcionario updateFuncionario(Funcionario funcionario) {
        Funcionario func = funcionarioRepository.findById(funcionario.getId()).orElse(null);
        func.setNome(funcionario.getNome());

        return funcionarioRepository.save(func);
    }

}
