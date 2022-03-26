package com.br.Maintenance.maintenance.service;

import com.br.Maintenance.maintenance.model.ListaCompras;
import com.br.Maintenance.maintenance.model.Produto;
import com.br.Maintenance.maintenance.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto saveProduto(Produto produto) {
        return repository.save(produto);
    }

    public List<Produto> listAll(Produto produto) {
        return repository.findAll();
    }

    public Produto produtoPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public String remove(Long id) {
        repository.deleteById(id);
        return "Produto removido!!" + id;
    }

    public Produto entrada(Long id, int valor) {
        Produto produto = repository.findById(id).orElse(null);
        try {
            produto.setSaldo((int) produto.getSaldo() + valor);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return repository.save(produto);
    }

    public Produto saida(Long id, int valor) {
        Produto produto = repository.findById(id).orElse(null);
        try {
            produto.setSaldo((int) produto.getSaldo() - valor);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return repository.save(produto);
    }

    public List<Produto> produtoHome() {
        Produto produto = new Produto();
        List<Produto> list = repository.findAll();

        return list;
    }

}
