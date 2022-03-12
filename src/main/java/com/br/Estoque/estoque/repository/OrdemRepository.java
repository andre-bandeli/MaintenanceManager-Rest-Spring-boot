package com.br.Estoque.estoque.repository;

import com.br.Estoque.estoque.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemRepository extends JpaRepository<OrdemServico, Long> {
}
