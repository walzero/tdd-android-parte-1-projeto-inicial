package br.com.alura.leilao.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeilaoTest {

    @Test
    public void getDescricao() {
        ///criar cenario de teste
        Leilao console = new Leilao(("Console"));
        //executar acao esperada
        String descricaoDevolvida = console.getDescricao();
        //testar resultado esperado
        assertEquals("Console", descricaoDevolvida);

    }

    @Test
    public void getMaiorLance() {
        Leilao console = new Leilao("Console");
        console.propoe(new Lance(new Usuario("Alex"), 200.0));

        double maiorLanceDevolvido = console.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvido, 0.0001);
    }
}