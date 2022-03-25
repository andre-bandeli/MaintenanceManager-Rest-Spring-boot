package com.br.Estoque.estoque.ativos.service;


import com.br.Estoque.estoque.ativos.model.Ativos;
import com.br.Estoque.estoque.ativos.repository.AtivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtivoService {


    @Autowired
    private AtivosRepository ativosRepository;


    public Ativos saveAtivo(Ativos ativos) {
        return ativosRepository.save(ativos);
    }

    public Ativos salvarAtivos(Ativos  ativos) {
        return ativosRepository.save(ativos);
    }

    public List<Ativos> listAtivo(Ativos ativos) {
        return ativosRepository.findAll();
    }

    public Ativos getAtivoById(Long id) {
        return ativosRepository.findById(id).orElse(null);
    }

    public String deleteAtivoById(Long id) {
        ativosRepository.deleteById(id);
        return "Solicitação removida!!" + id;
    }

    public Ativos updateAtivo(Ativos ativos) {
        Ativos ativos1 = ativosRepository.findById(ativos.getId()).orElse(null);
        return ativosRepository.save(ativos1);
    }
}
