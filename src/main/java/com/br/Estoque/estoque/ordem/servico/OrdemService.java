package com.br.Estoque.estoque.ordem.servico;

import com.br.Estoque.estoque.ordem.model.Ordem;
import com.br.Estoque.estoque.ordem.repositorio.OrdemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemService {

    @Autowired
    private OrdemRepository ordemRepository;

    public Ordem saveOrdem(Ordem ordemServico) {
         return ordemRepository.save(ordemServico);
    }

    public List<Ordem> salvarOrdem(List <Ordem>  ordemServico) {
        return ordemRepository.saveAll(ordemServico);
    }

    public List<Ordem> listOrdem(Ordem ordemServico) {
        return ordemRepository.findAll();
    }

    public Ordem getOrdemById(Long id) {
        return ordemRepository.findById(id).orElse(null);
    }

    public String deleteOrdemById(Long id) {
        ordemRepository.deleteById(id);
        return "Ordem removida!!" + id;
    }

    public Ordem updateOrdem(Ordem ordemServico) {
        Ordem ordemServico1 = ordemRepository.findById(ordemServico.getId()).orElse(null);
        return ordemRepository.save(ordemServico);
    }
}
