package com.br.Estoque.estoque.ordem.model;

import com.br.Estoque.estoque.solicitacao.model.Solicitacao;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "ordem_servico")
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Column(name = "codigo")
    private Long codigo;
    @NotNull
    @Column(name = "dataAbertura")
    private String dataAbertura;
    @NotNull
    @Column(name = "dataFechamento")
    private String dataFechamento;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="solicitacaoServico", referencedColumnName = "id")
    private Solicitacao solicitacaoServico;

    public Ordem() {
    }

    @PrePersist
    public void onPrepersist() {
        solicitacaoServico.setActive(true);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getSolicitacaoServico() {
        return solicitacaoServico.getId().toString();
    }

    public void setSolicitacaoServico(Solicitacao solicitacaoServico) {
        this.solicitacaoServico = solicitacaoServico;
    }

}
