package com.br.Estoque.estoque.repository;

import com.br.Estoque.estoque.model.SolicitacaoServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoRepository extends JpaRepository<SolicitacaoServico, Long> {
}
