package com.br.Estoque.estoque.produto.repositorio;

import com.br.Estoque.estoque.produto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository  extends JpaRepository<Produto, Long> {
}
