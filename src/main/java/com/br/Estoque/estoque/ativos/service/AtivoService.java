package com.br.Estoque.estoque.ativos.service;

import com.br.Estoque.estoque.ativos.model.Ativos;
import com.br.Estoque.estoque.ativos.repository.AtivosRepository;
import com.br.Estoque.estoque.ordem.model.Ordem;
import com.br.Estoque.estoque.ordem.repositorio.OrdemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtivoService {

    @Autowired
    private AtivosRepository ativosRepository;

    public Ativos save(Ativos ativos) {
        return ativosRepository.save(ativos);
    }

    public List<Ativos> salvarAtivo(List <Ativos>  ativos) {
        return ativosRepository.saveAll(ativos);
    }

    public List<Ativos> listAtivos(Ativos ativos) {
        return ativosRepository.findAll();
    }

    public Ativos getAtivoById(Long id) {
        return ativosRepository.findById(id).orElse(null);
    }

    public String deleteAtivoById(Long id) {
        ativosRepository.deleteById(id);
        return "Ativo removido!!" + id;
    }

    public Ativos updateAtivo(Ativos ordemServico) {
        Ativos ativos2 = ativosRepository.findById(ordemServico.getId()).orElse(null);
        return ativosRepository.save(ativos2);
    }
}
