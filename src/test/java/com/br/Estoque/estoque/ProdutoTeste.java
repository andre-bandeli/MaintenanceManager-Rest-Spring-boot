package com.br.Estoque.estoque;


import com.br.Estoque.estoque.produto.model.Produto;
import com.br.Estoque.estoque.produto.servico.ProdutoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoTeste {

    @Test
    void testCriarProduto() {

        Produto produto = new Produto();
        produto.setId(55l);
        produto.setCodigo(55l);
        produto.setNome("Caneta preta");
        produto.setSaldo(100);
        produto.setSaldoMin(150);

        Assertions.assertEquals(55, produto.getId());
        Assertions.assertEquals(55, produto.getCodigo());
        Assertions.assertEquals("Caneta preta", produto.getNome());
        Assertions.assertEquals(100, produto.getSaldo());
        Assertions.assertEquals(150, produto.getSaldoMin());

        Assertions.assertNotEquals(10, produto.getId());
        Assertions.assertNotEquals(11, produto.getCodigo());
        Assertions.assertNotEquals(45454, produto.getNome());

    }

    @Test
    void testCriarProdutoNull() {

        Produto produto = new Produto();
        produto.setCodigo(55l);
        produto.setNome("Caneta preta");
        produto.setSaldo(100);
        produto.setSaldoMin(150);

        Assertions.assertEquals(null, produto.getId());
        Assertions.assertEquals(55, produto.getCodigo());
        Assertions.assertEquals("Caneta preta", produto.getNome());
        Assertions.assertEquals(100, produto.getSaldo());
        Assertions.assertEquals(150, produto.getSaldoMin());

    }


}
