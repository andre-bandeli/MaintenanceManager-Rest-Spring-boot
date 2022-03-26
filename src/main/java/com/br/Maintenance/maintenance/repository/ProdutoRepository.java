package com.br.Maintenance.maintenance.repository;

import com.br.Maintenance.maintenance.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository  extends JpaRepository<Produto, Long> {
}
