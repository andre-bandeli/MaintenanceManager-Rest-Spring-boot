package com.br.Estoque.estoque.solicitacao.servico;


import com.br.Estoque.estoque.DAO.SolicitacaoDAO;
import com.br.Estoque.estoque.solicitacao.model.Solicitacao;
import com.br.Estoque.estoque.solicitacao.repositorio.SolicitacaoRepository;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Solicitacao updateSolicitacao(Solicitacao solicitacaoServico) {
        Solicitacao solicitacaoServico1 = solicitacaoRepository.findById(solicitacaoServico.getId()).orElse(null);
        return solicitacaoRepository.save(solicitacaoServico);
    }


    public int queryMaquinas(int codigo) {

        return solicitacaoDAO.queryMaquinas(1515);
    }
}
