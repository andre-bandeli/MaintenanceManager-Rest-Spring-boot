package com.br.Estoque.estoque.DAO;


import com.br.Estoque.estoque.DAO.FuncionarioDAO;
import com.br.Estoque.estoque.factory.Factory;
import com.br.Estoque.estoque.solicitacao.model.Solicitacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SolicitacaoDAO {


    public void criarSolicitacao(Solicitacao solicitacao) {
        Connection connection = Factory.getConnection();
        PreparedStatement pst = null;

        try {
            pst = connection.prepareStatement("INSERT INTO solicitacao (id, nome)VALUES( ?, ?, ?, ?, ?, ?, ? )");
            pst.setLong(1, solicitacao.getId());
            pst.setInt(2, solicitacao.getCodigo());
            pst.setString(3, solicitacao.getMaquina());
            pst.setString(4, solicitacao.getSetor());
            pst.setString(5, solicitacao.getNomeSolicitante());
            pst.setBoolean(6, solicitacao.getActive());
            pst.setString(7, solicitacao.getDescricao());

            pst.executeUpdate();
            System.out.println("objeto salvo com sucesso! ");

        }catch (SQLException exception) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, exception);
            System.out.println("Erro: " + exception);
        }finally {
            Factory.closeConnection(connection, pst);
        }
    }



}
