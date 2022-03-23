package com.br.Estoque.estoque.DAO;

import com.br.Estoque.estoque.factory.Factory;
import com.br.Estoque.estoque.ordem.model.Ordem;
import com.br.Estoque.estoque.solicitacao.model.Solicitacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class OrdemDAO {


    public void criarOrdem(Ordem ordem) {
        Connection connection = Factory.getConnection();
        PreparedStatement pst = null;

        try {

            pst = connection.prepareStatement("INSERT INTO ordem_servico (id, codigo, dataAbertura, dataFechamento, solicitacaoServico)VALUES( ?, ?, ?, ?, ?)");
            pst.setLong(1, ordem.getId());
            pst.setLong(2, ordem.getCodigo());
            pst.setString(3, ordem.getDataAbertura());
            pst.setString(4, ordem.getDataFechamento());
            pst.setString(5, ordem.getSolicitacaoServico().toString());

            pst.executeUpdate();
            System.out.println("objeto salvo com sucesso! ");


        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            Factory.closeConnection(connection, pst);
        }
    }

}
