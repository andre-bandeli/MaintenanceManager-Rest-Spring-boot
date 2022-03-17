package com.br.Estoque.estoque;

import com.br.Estoque.estoque.funcionario.model.Funcionario;
import com.br.Estoque.estoque.funcionario.servico.FuncionarioService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoqueApplication.class, args);

		Funcionario funcionario = new Funcionario();
		FuncionarioService service = null;
		try {
			funcionario.setNome("Teste");
			service.saveFuncionario(funcionario);
		}catch (Exception e) {
			e.fillInStackTrace();
		}


	}





}
