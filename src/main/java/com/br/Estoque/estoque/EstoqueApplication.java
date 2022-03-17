package com.br.Estoque.estoque;

import com.br.Estoque.estoque.funcionario.DAO.FuncionarioDAO;
import com.br.Estoque.estoque.funcionario.model.Funcionario;
import com.br.Estoque.estoque.funcionario.servico.FuncionarioService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoqueApplication.class, args);


		Funcionario funcionario = new Funcionario();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		funcionario.setId(1L);
		funcionario.setNome("TESTE");
		funcionarioDAO.criarFuncionario(funcionario);

	}





}
