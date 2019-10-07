package br.com.alura.leilao.model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LeilaoTest {
    private static final double DELTA = 0.0001;
    private static final double valor = 0.0001;
    private final Leilao console = new Leilao("Console");
    private final Usuario alex = new Usuario("Alex");

    @Test
    public void getDescricaoQuandoRecebeDescricaoDevolveDescricao() {
        String descricaoDevolvida = console.getDescricao();
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void getMaiorLanceQuandoRecebeApenasUmLanceDevolveMaiorLance() {
        console.propoe(new Lance(alex, 200.0));
        double maiorLanceDevolvido = console.getMaiorLance();
        assertEquals(200.0, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void getMaiorLanceQuandoRecebeMaisDeUmLanceEmOrdemCrescenteDevolveMaiorLance() {
        console.propoe(new Lance(alex, 100.0));
        console.propoe(new Lance(new Usuario("Fran"), 200.0));
        double maiorLanceDevolvido = console.getMaiorLance();
        assertEquals(200.0, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void getMaiorLanceQuandoRecebeMaisDeUmLanceEmOrdemDecrescenteDevolveMaiorLance() {
        console.propoe(new Lance(alex, 10000.0));
        console.propoe(new Lance(new Usuario("Fran"), 9000.0));
        double maiorLanceDevolvido = console.getMaiorLance();
        assertEquals(10000.0, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void getMenorLanceQuandoRecebeApenasUmLanceDevolveMenorrLance() {
        console.propoe(new Lance(alex, 200.0));
        double menorLanceDevolvido= console.getMenorLance();
        assertEquals(200.0, menorLanceDevolvido, DELTA);
    }

    @Test
    public void getMenorLanceQuandoRecebeMaisDeUmLanceEmOrdemCrescenteDevolveMenorLance() {
        console.propoe(new Lance(alex, 100.0));
        console.propoe(new Lance(new Usuario("Fran"), 200.0));
        double menorLanceDevolvido = console.getMenorLance();
        assertEquals(100.0, menorLanceDevolvido, DELTA);
    }

    @Test
    public void getMenorLanceQuandoRecebeMaisDeUmLanceEmOrdemDecrescenteDevolveMenorLance() {
        console.propoe(new Lance(alex, 10000.0));
        console.propoe(new Lance(new Usuario("Fran"), 9000.0));
        double menorLanceDevolvido = console.getMenorLance();
        assertEquals(9000.0, menorLanceDevolvido, DELTA);
    }

    @Test
    public void getTresMaioresLancesQuandoNaoRecebeLances() {
        List<Lance> tresMaioresLancesDevolvidos = console.tresMaioresLances();

        assertEquals(0, tresMaioresLancesDevolvidos.size());
    }

    @Test
    public void getTresMaioresLancesQuandoRecebeApenasUmLance() {
        console.propoe(new Lance(alex, 200.0));
        List<Lance> tresMaioresLancesDevolvidos = console.tresMaioresLances();

        assertEquals(1, tresMaioresLancesDevolvidos.size());
        assertEquals(200.0, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
    }

    @Test
    public void getTresMaioresLancesQuandoRecebeApenasDoisLance() {
        console.propoe(new Lance(alex, 300.0));
        console.propoe(new Lance(new Usuario("Fran"), 400.0));
        List<Lance> tresMaioresLancesDevolvidos = console.tresMaioresLances();

        assertEquals(2, tresMaioresLancesDevolvidos.size());
        assertEquals(400.0, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(300.0, tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);
    }

    @Test
    public void getTresMaioresLancesQuandoRecebeApenasTresLances() {
        console.propoe(new Lance(alex, 200.0));
        console.propoe(new Lance(new Usuario("Fran"), 300.0));
        console.propoe(new Lance(alex, 400.0));

        List<Lance> tresMaioresLancesDevolvidos = console.tresMaioresLances();

        assertEquals(3, tresMaioresLancesDevolvidos.size());
        assertEquals(400.0, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(300.0, tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);
        assertEquals(200.0, tresMaioresLancesDevolvidos.get(2).getValor(), DELTA);
    }

    @Test
    public void getTresMaioresLancesQuandoRecebeApenasQuatroLances() {
        final Usuario fran = new Usuario("Fran");
        console.propoe(new Lance(alex, 300.0));
        console.propoe(new Lance(fran, 400.0));
        console.propoe(new Lance(alex, 500.0));
        console.propoe(new Lance(fran, 600.0));

        List<Lance> tresMaioresLancesDevolvidos = console.tresMaioresLances();

        assertEquals(3, tresMaioresLancesDevolvidos.size());
        assertEquals(600.0, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(500.0, tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);
        assertEquals(400.0, tresMaioresLancesDevolvidos.get(2).getValor(), DELTA);
    }

    @Test
    public void getTresMaioresLancesQuandoRecebeApenasCincoLances() {
        final Usuario fran = new Usuario("Fran");
        console.propoe(new Lance(alex, 300.0));
        console.propoe(new Lance(fran, 400.0));
        console.propoe(new Lance(alex, 500.0));
        console.propoe(new Lance(fran, 600.0));
        console.propoe(new Lance(alex, 700.0));

        List<Lance> tresMaioresLancesDevolvidos = console.tresMaioresLances();

        assertEquals(3, tresMaioresLancesDevolvidos.size());
        assertEquals(700.0, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(600.0, tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);
        assertEquals(500.0, tresMaioresLancesDevolvidos.get(2).getValor(), DELTA);
    }

    @Test
    public void getValorZeroParaMaiorLanceQuandoNaoHouverLances() {
        double maiorLanceDevolvido = console.getMaiorLance();
        assertEquals(0d, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void getValorZeroParaMenorLanceQuandoNaoHouverLances() {
        double menorLanceDevolvido = console.getMenorLance();
        assertEquals(0d, menorLanceDevolvido, DELTA);
    }
}