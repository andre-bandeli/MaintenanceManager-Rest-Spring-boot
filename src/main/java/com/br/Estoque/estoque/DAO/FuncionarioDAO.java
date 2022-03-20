package com.br.Estoque.estoque.DAO;


import com.br.Estoque.estoque.factory.Factory;
import com.br.Estoque.estoque.funcionario.model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDAO {


    public void criarFuncionario(Funcionario funcionario) {
        Connection connection = Factory.getConnection();
        PreparedStatement pst = null;

        try {
            pst = connection.prepareStatement("INSERT INTO funcionario (id, nome)VALUES(?,?)");
            pst.setLong(1, funcionario.getId());
            pst.setString(2, funcionario.getNome());

            pst.executeUpdate();
            System.out.println("objeto salvo com sucesso! ");

        }catch (SQLException exception) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, exception);
            System.out.println("Erro: " + exception);
        }finally {
            Factory.closeConnection(connection, pst);
        }
    }

    public void removerFuncionario(Long id) {
        Connection connection = Factory.getConnection();
        PreparedStatement pst = null;

        try {
            pst = connection.prepareStatement("DELETE  FROM funcionario WHERE (id) VALUES(?)");
            pst.executeUpdate();
            System.out.println("objeto deletado com sucesso! ");

        }catch (SQLException exception) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, exception);
            System.out.println("Erro: " + exception);
        }finally {
            Factory.closeConnection(connection, pst);
        }
    }



}
