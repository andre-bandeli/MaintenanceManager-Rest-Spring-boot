package com.br.Estoque.estoque.ordem.model;

import com.br.Estoque.estoque.solicitacao.model.Solicitacao;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_abertura")
    private Date dataAbertura;
    @NotNull
    @Column(name = "data_fechamento")
    private Date dataFechamento;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="solicitacao_servico", referencedColumnName = "id")
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

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Solicitacao getSolicitacaoServico() {
        return solicitacaoServico;
    }

    public void setSolicitacaoServico(Solicitacao solicitacaoServico) {
        this.solicitacaoServico = solicitacaoServico;
    }

}
