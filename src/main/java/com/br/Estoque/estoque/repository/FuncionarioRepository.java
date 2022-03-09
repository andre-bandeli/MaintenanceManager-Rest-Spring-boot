package com.br.Estoque.estoque.repository;

import com.br.Estoque.estoque.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long > {
}
