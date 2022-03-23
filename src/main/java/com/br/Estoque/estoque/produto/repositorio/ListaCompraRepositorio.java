package com.br.Estoque.estoque.produto.repositorio;

import com.br.Estoque.estoque.produto.model.ListaCompras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaCompraRepositorio extends JpaRepository<ListaCompras, Long> {
}
