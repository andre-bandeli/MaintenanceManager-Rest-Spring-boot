package com.br.Maintenance.maintenance.DAO;


import com.br.Maintenance.maintenance.factory.Factory;
import com.br.Maintenance.maintenance.model.ListaCompras;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ListaCompraDAO {


    public void criarListaCompra(ListaCompras listaCompras) {
        Connection connection = Factory.getConnection();
        PreparedStatement pst = null;

        try {

            pst = connection.prepareStatement("INSERT INTO lista_compras (id, codigo, nome, deadline)VALUES( ?, ?, ?, ?)");
            pst.setLong(1, listaCompras.getId());
            pst.setLong(2, listaCompras.getCodigo());
            pst.setString(3, listaCompras.getNome());
            pst.setString(4, listaCompras.getDeadline());

            pst.executeUpdate();
            System.out.println("objeto salvo com sucesso! ");


        }catch (SQLException exception) {
            exception.printStackTrace();
        }finally {
            Factory.closeConnection(connection, pst);
        }
    }
}
