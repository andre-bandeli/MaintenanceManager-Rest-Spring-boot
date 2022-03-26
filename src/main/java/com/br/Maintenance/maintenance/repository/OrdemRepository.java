package com.br.Maintenance.maintenance.repository;

import com.br.Maintenance.maintenance.model.Ordem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemRepository extends JpaRepository<Ordem, Long> {
}
