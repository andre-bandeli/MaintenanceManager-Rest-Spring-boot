package com.br.Maintenance.maintenance.service;

import com.br.Maintenance.maintenance.model.ListaCompras;
import com.br.Maintenance.maintenance.repository.ListaCompraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaCompraService {

    @Autowired
    private ListaCompraRepositorio repository;

    public ListaCompras saveListaCompras(ListaCompras listaCompras) {
        return repository.save(listaCompras);
    }

    public List<ListaCompras> listAll(ListaCompras listaCompras) {
        return repository.findAll();
    }

    public ListaCompras listaComprasPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public String remove(Long id) {
        repository.deleteById(id);
        return "Produto removido da lista de compras!!" + id;
    }

}
