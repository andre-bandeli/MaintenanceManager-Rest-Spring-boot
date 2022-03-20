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

		SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
		Solicitacao solicitacao = new Solicitacao();

		solicitacao.setId(10L);
		solicitacao.setCodigo(15520);
		solicitacao.setMaquina("Corte");
		solicitacao.setSetor("Manutenção");
		solicitacao.setNomeSolicitante("André");
		solicitacao.setActive(true);
		solicitacao.setDescricao("maquina deu uma parada");
		solicitacaoDAO.criarSolicitacao(solicitacao);

		Solicitacao solicitacao2 = new Solicitacao();


		solicitacao2.setId(20L);
		solicitacao2.setCodigo(1550);
		solicitacao2.setMaquina("Costura");
		solicitacao2.setSetor("TC 01");
		solicitacao2.setNomeSolicitante("José");
		solicitacao2.setActive(true);
		solicitacao2.setDescricao("maquina desligou");
		solicitacaoDAO.criarSolicitacao(solicitacao2);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = new Funcionario();
		funcionario.setId(15l);
		funcionario.setNome("André");

		funcionarioDAO.criarFuncionario(funcionario);




	}

}
