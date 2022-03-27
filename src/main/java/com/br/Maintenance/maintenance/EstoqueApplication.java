package com.br.Maintenance.maintenance;

import com.br.Maintenance.maintenance.service.OrdemService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstoqueApplication {

	private OrdemService ordemService;

	public static void main(String[] args) {

		SpringApplication.run(EstoqueApplication.class, args);


	}

}
