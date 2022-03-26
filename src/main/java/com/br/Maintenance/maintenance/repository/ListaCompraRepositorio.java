package com.br.Maintenance.maintenance.repository;

import com.br.Maintenance.maintenance.model.ListaCompras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaCompraRepositorio extends JpaRepository<ListaCompras, Long> {
}
