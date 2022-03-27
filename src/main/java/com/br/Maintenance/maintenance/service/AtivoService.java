package com.br.Maintenance.maintenance.service;


import com.br.Maintenance.maintenance.model.Ativos;
import com.br.Maintenance.maintenance.repository.AtivosRepository;
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

    public Ativos salvarAtivos() {

        Ativos ativos = new Ativos();
        ativos.setId(ativos.getId());
        ativos.setCodigo(ativos.getCodigo());
        ativos.setSetor(ativos.getSetor());
        ativos.setDataInicioOperacao(ativos.getDataInicioOperacao());
        ativos.setTipo(ativos.getTipo());
        ativos.setNivelPrioridade(ativos.getNivelPrioridade());

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

    public List<Ativos> ativosHome() {

        Ativos ativos = new Ativos();
        List<Ativos> list = ativosRepository.findAll();

        return list;
    }
}
