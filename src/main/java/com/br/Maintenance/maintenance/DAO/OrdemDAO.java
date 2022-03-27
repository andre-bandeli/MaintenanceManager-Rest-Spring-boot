package com.br.Maintenance.maintenance.DAO;

import com.br.Maintenance.maintenance.factory.Factory;
import com.br.Maintenance.maintenance.model.Ordem;

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
            pst.setDate(3, ordem.getDataAbertura());
            pst.setDate(4, ordem.getDataFechamento());
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
