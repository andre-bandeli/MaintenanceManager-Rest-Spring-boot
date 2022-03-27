package com.br.Maintenance.maintenance.user.repository;

import com.br.Maintenance.maintenance.user.model.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Roles, Long> {
    Roles findByRole(String role);
}