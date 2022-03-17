package com.br.Estoque.estoque.solicitacao.repositorio;

import com.br.Estoque.estoque.solicitacao.model.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
}
