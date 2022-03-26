package com.br.Maintenance.maintenance.repository;

import com.br.Maintenance.maintenance.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long > {
}
