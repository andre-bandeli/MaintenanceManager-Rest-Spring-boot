package com.br.Estoque.estoque;

import com.br.Estoque.estoque.DAO.FuncionarioDAO;
import com.br.Estoque.estoque.funcionario.model.Funcionario;
import com.br.Estoque.estoque.DAO.SolicitacaoDAO;
import com.br.Estoque.estoque.solicitacao.model.Solicitacao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoqueApplication.class, args);


		Funcionario funcionario = new Funcionario();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		funcionario.setId(2L);
		funcionario.setNome("TESTE");
		funcionarioDAO.criarFuncionario(funcionario);

		funcionarioDAO.removerFuncionario(2L);

		Solicitacao solicitacao = new Solicitacao();
		SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();

		solicitacao.setId(1L);
		solicitacao.setCodigo(2550);
		solicitacao.setMaquina("C0 011");
		solicitacao.setSetor("C0");
		solicitacao.setNomeSolicitante("TESTE");
		solicitacao.setActive(false);
		solicitacao.setDescricao("máquina parou");

		solicitacaoDAO.criarSolicitacao(solicitacao);

	}





}
