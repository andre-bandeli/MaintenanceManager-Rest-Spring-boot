package com.br.Maintenance.maintenance.service;


import com.br.Maintenance.maintenance.DAO.SolicitacaoDAO;
import com.br.Maintenance.maintenance.model.Solicitacao;
import com.br.Maintenance.maintenance.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class serviceSolicitacao {

    private SolicitacaoDAO solicitacaoDAO;

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;


    public Solicitacao saveSolicitacao(Solicitacao solicitacaoServico) {
        return solicitacaoRepository.save(solicitacaoServico);
    }

    public List<Solicitacao> salvarSolicitacoes(List <Solicitacao>  solicitacaoServicos) {
        return solicitacaoRepository.saveAll(solicitacaoServicos);
    }

    public List<Solicitacao> listSolicitacoes(Solicitacao solicitacaoServico) {
        return solicitacaoRepository.findAll();
    }

    public Solicitacao getSolicitacaoById(Long id) {
        return solicitacaoRepository.findById(id).orElse(null);
    }

    public String deleteSolicitacaoById(Long id) {
        solicitacaoRepository.deleteById(id);
        return "Solicitação removida!!" + id;
    }

    public Solicitacao updateSolicitacao(Long id) {

        Solicitacao solicitacao = solicitacaoRepository.getById(id);
        solicitacao.setCodigo(solicitacao.getCodigo());
        solicitacao.setMaquina(solicitacao.getMaquina());
        solicitacao.setSetor(solicitacao.getSetor());
        solicitacao.setNomeSolicitante(solicitacao.getNomeSolicitante());
        solicitacao.setDataSolicitacao(solicitacao.getDataSolicitacao());
        solicitacao.setDescricao(solicitacao.getDescricao());
        solicitacao.setActive(solicitacao.getActive());

        return solicitacaoRepository.save(solicitacao);
    }
}
