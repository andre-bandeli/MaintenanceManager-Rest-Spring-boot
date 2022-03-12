package com.br.Estoque.estoque.service;

import com.br.Estoque.estoque.model.OrdemServico;
import com.br.Estoque.estoque.repository.OrdemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Service
public class OrdemService {

    @Autowired
    private OrdemRepository ordemRepository;

    public OrdemServico saveOrdem(OrdemServico ordemServico) {
        return ordemRepository.save(ordemServico);
    }

    public List<OrdemServico> salvarOrdem(List <OrdemServico>  ordemServico) {
        return ordemRepository.saveAll(ordemServico);
    }

    public List<OrdemServico> listOrdem(OrdemServico ordemServico) {
        return ordemRepository.findAll();
    }

    public OrdemServico getOrdemById(Long id) {
        return ordemRepository.findById(id).orElse(null);
    }

    public String deleteOrdemById(Long id) {
        ordemRepository.deleteById(id);
        return "Ordem removida!!" + id;
    }

    public OrdemServico updateOrdem(OrdemServico ordemServico) {
        OrdemServico ordemServico1 = ordemRepository.findById(ordemServico.getId()).orElse(null);
        return ordemRepository.save(ordemServico);
    }
}
