package com.br.Estoque.estoque;

import com.br.Estoque.estoque.DAO.*;
import com.br.Estoque.estoque.funcionario.model.Funcionario;
import com.br.Estoque.estoque.ordem.model.Ordem;
import com.br.Estoque.estoque.ordem.servico.OrdemService;
import com.br.Estoque.estoque.produto.model.ListaCompras;
import com.br.Estoque.estoque.produto.model.Produto;
import com.br.Estoque.estoque.solicitacao.model.Solicitacao;
import com.br.Estoque.estoque.home.HomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.sql.Date.*;

@SpringBootApplication
public class EstoqueApplication {

	private OrdemService ordemService;

	public static void main(String[] args) {

		SpringApplication.run(EstoqueApplication.class, args);

		SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
		Solicitacao solicitacao = new Solicitacao();

		solicitacao.setId(10L);
		solicitacao.setCodigo(1515);
		solicitacao.setMaquina("Corte");
		solicitacao.setSetor("Manutenção");
		solicitacao.setNomeSolicitante("Ana Pereira");
		solicitacao.setActive(true);
		solicitacao.setDescricao("maquina apresentou ruído forte");
		solicitacaoDAO.criarSolicitacao(solicitacao);

		Solicitacao solicitacao2 = new Solicitacao();


		solicitacao2.setId(20L);
		solicitacao2.setCodigo(1514);
		solicitacao2.setMaquina("Costura");
		solicitacao2.setSetor("TC 01");
		solicitacao2.setNomeSolicitante("Joana");
		solicitacao2.setActive(true);
		solicitacao2.setDescricao("maquina desligou");
		solicitacaoDAO.criarSolicitacao(solicitacao2);

		solicitacao2.setId(30L);
		solicitacao2.setCodigo(1516);
		solicitacao2.setMaquina("Costura");
		solicitacao2.setSetor("TC 01");
		solicitacao2.setNomeSolicitante("José Roberto");
		solicitacao2.setActive(true);
		solicitacao2.setDescricao("maquina desligou");
		solicitacaoDAO.criarSolicitacao(solicitacao2);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = new Funcionario();
		funcionario.setId(15l);
		funcionario.setNome("André Luiz");

		funcionarioDAO.criarFuncionario(funcionario);


		OrdemDAO ordemDAO = new OrdemDAO();
		Ordem ordem = new Ordem();
		ordem.setId(20L);
		ordem.setCodigo(1678L);
		ordem.setDataAbertura("21-10-2022");
		ordem.setDataFechamento("22-10-2022");
		ordem.setSolicitacaoServico(solicitacao);
		ordemDAO.criarOrdem(ordem);

		OrdemDAO ordemDAO2 = new OrdemDAO();
		Ordem ordem2 = new Ordem();
		ordem2.setId(30L);
		ordem2.setCodigo(1619L);
		ordem2.setDataAbertura("21-10-2022");
		ordem2.setDataFechamento("22-10-2022");
		ordem2.setSolicitacaoServico(solicitacao2);
		ordemDAO2.criarOrdem(ordem2);



//		Ordem ordem = new Ordem();
//		OrdemService ordemService = new OrdemService();
//		ordem.setId(1515l);
//		ordem.setCodigo(4455l);
//		ordem.setSolicitacaoServico(solicitacao);
//		try {
//
//			ordemService.saveOrdem(ordem);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}

		Produto produto = new Produto();

		produto.setId(25l);
		produto.setCodigo(455l);
		produto.setSaldo(150);
		produto.setNome("Caneta Azul");
		produto.setSaldoMin(10);

		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.criarProduto(produto);


		ListaCompras listaCompras = new ListaCompras();
		listaCompras.setId(55l);
		listaCompras.setCodigo(54l);
		listaCompras.setNome("Caneta preta");
		listaCompras.setDeadline("25-04-2022");

		ListaCompraDAO listaCompraDAO = new ListaCompraDAO();
		listaCompraDAO.criarListaCompra(listaCompras);







	}

}
