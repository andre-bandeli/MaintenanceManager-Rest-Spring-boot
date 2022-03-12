package com.br.Estoque.estoque.service;


import com.br.Estoque.estoque.model.Funcionario;
import com.br.Estoque.estoque.model.SolicitacaoServico;
import com.br.Estoque.estoque.repository.FuncionarioRepository;
import com.br.Estoque.estoque.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SolicitacaoService {


    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    public SolicitacaoServico saveSolicitacao(SolicitacaoServico solicitacaoServico) {
        return solicitacaoRepository.save(solicitacaoServico);
    }

    public List<SolicitacaoServico> salvarSolicitacoes(List <SolicitacaoServico>  solicitacaoServicos) {
        return solicitacaoRepository.saveAll(solicitacaoServicos);
    }

    public List<SolicitacaoServico> listSolicitacoes(SolicitacaoServico solicitacaoServico) {
        return solicitacaoRepository.findAll();
    }

    public SolicitacaoServico getSolicitacaoById(Long id) {
        return solicitacaoRepository.findById(id).orElse(null);
    }

    public String deleteSolicitacaoById(Long id) {
        solicitacaoRepository.deleteById(id);
        return "Solicitação removida!!" + id;
    }

    public SolicitacaoServico updateSolicitacao(SolicitacaoServico solicitacaoServico) {
        SolicitacaoServico solicitacaoServico1 = solicitacaoRepository.findById(solicitacaoServico.getId()).orElse(null);
        return solicitacaoRepository.save(solicitacaoServico);
    }
}
