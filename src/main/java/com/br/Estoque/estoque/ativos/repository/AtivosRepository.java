package com.br.Estoque.estoque.ativos.repository;

import com.br.Estoque.estoque.ativos.model.Ativos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtivosRepository extends JpaRepository<Ativos, Long> {
}
