package com.br.Estoque.estoque;


import com.br.Estoque.estoque.solicitacao.model.Solicitacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.configuration.IMockitoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class SolicitacaoTest {

    @Test
    void criarSolicitacaoTest() {

        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setId(55l);
        solicitacao.setCodigo(55);
        solicitacao.setMaquina("Corte");
        solicitacao.setSetor("Tecelaria");
        solicitacao.setNomeSolicitante("José");
        solicitacao.setActive(true);

        Assertions.assertEquals(55, solicitacao.getId());
        Assertions.assertEquals(55, solicitacao.getCodigo());
        Assertions.assertEquals("Corte", solicitacao.getMaquina());
        Assertions.assertEquals("Tecelaria", solicitacao.getSetor());
        Assertions.assertEquals("José", solicitacao.getNomeSolicitante());
        Assertions.assertTrue(true, String.valueOf(true));

        //Usando Mockito

        Solicitacao mock = mock(Solicitacao.class);
        when(mock.getId()).thenReturn(55l);


    }

    void testaMetodosRepositorio() {



    }
}
