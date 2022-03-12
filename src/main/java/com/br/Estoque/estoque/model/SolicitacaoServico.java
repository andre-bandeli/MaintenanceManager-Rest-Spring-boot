package com.br.Estoque.estoque.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "solicitacao")
public class SolicitacaoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "codigo")
    private Long codigo;
    @NotNull
    @Column(name = "maquina")
    private String maquina;
    @NotNull
    @Column(name = "setor")
    private String setor;
    @NotNull
    @Column(name = "nome_solicitante")
    private String nomeSolicitante;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_solicitacao")
    private Date dataSolicitacao;
    @NotNull
    @Column(name = "is_ordem")
    private Boolean isOrdemServico = true;
    @NotNull
    @Column(name = "descricao")
    private String descricao;

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

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getNomeSolicitante() {
        return nomeSolicitante;
    }

    public void setNomeSolicitante(String nomeSolicitante) {
        this.nomeSolicitante = nomeSolicitante;
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Boolean getActive() {
        return isOrdemServico;
    }

    public void setActive(Boolean active) {
        isOrdemServico = active;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
