package com.br.Estoque.estoque.ordem.repositorio;

import com.br.Estoque.estoque.ordem.model.Ordem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemRepository extends JpaRepository<Ordem, Long> {
}
