package com.br.Maintenance.maintenance.DAO;


import com.br.Maintenance.maintenance.factory.Factory;
import com.br.Maintenance.maintenance.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {


    public void criarProduto(Produto produto) {
        Connection connection = Factory.getConnection();
        PreparedStatement pst = null;

        try {

            pst = connection.prepareStatement("INSERT INTO produto (id, codigo, nome, saldo, saldoMin)VALUES( ?, ?, ?, ?, ?)");
            pst.setLong(1, produto.getId());
            pst.setLong(2, produto.getCodigo());
            pst.setString(3, produto.getNome());
            pst.setInt(4, produto.getSaldo());
            pst.setInt(5, produto.getSaldoMin());

            pst.executeUpdate();
            System.out.println("objeto salvo com sucesso! ");


        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            Factory.closeConnection(connection, pst);
        }
    }
}
