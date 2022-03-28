package com.br.Maintenance.maintenance.service;

import com.br.Maintenance.maintenance.model.Ordem;
import com.br.Maintenance.maintenance.repository.OrdemRepository;
import com.br.Maintenance.maintenance.model.Solicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemService {

    @Autowired
    private OrdemRepository ordemRepository;

    public Ordem saveOrdem(Ordem ordemServico) {

        ordemServico.setId(ordemServico.getId());
        ordemServico.setCodigo(ordemServico.getCodigo());
        ordemServico.setDataAbertura(ordemServico.getDataAbertura());
        ordemServico.setDataFechamento(ordemServico.getDataFechamento());
//        ordemServico.setSolicitacaoServico(ordemServico.getSolicitacaoServico());
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

    public Ordem updateOrdem(Long id) {

        Ordem ordem = ordemRepository.getById(id);
        ordem.setCodigo(ordem.getCodigo());
        ordem.setDataAbertura(ordem.getDataAbertura());
        ordem.setDataFechamento(ordem.getDataFechamento());
        ordem.setSolicitacaoServico(ordem.getSolicitacaoServico());

        return ordemRepository.save(ordem);
    }

    public void setStatus(Solicitacao solicitacao) {
        solicitacao.setActive(false);
    }
}
