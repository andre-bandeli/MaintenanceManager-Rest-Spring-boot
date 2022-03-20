package com.br.Estoque.estoque;

import com.br.Estoque.estoque.DAO.FuncionarioDAO;
import com.br.Estoque.estoque.funcionario.model.Funcionario;
import com.br.Estoque.estoque.DAO.SolicitacaoDAO;
import com.br.Estoque.estoque.solicitacao.model.Solicitacao;
import com.br.Estoque.estoque.home.HomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class EstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoqueApplication.class, args);

	}





}
