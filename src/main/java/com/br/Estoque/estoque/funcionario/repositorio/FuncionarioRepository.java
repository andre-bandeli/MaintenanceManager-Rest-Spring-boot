package com.br.Estoque.estoque.funcionario.repositorio;

import com.br.Estoque.estoque.funcionario.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long > {
}
