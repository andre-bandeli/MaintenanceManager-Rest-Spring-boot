package com.br.Estoque.estoque.produto.servico;

import com.br.Estoque.estoque.produto.model.ListaCompras;
import com.br.Estoque.estoque.produto.model.Produto;
import com.br.Estoque.estoque.produto.repositorio.ListaCompraRepositorio;
import com.br.Estoque.estoque.produto.repositorio.ProdutoRepository;
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
