package br.com.felipe.renegociacao.services;

import br.com.felipe.renegociacao.models.Divida;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class DividaServiceImplTest {

    private DividaService dividaService = new DividaServiceImpl();

    @Test
    public void dado_duasDividas_quando_agruparDividasChamado_entao_retornarUmaDividaAcumulada() {
        List<Divida> listaDivida = new ArrayList<>();
        listaDivida.add(new Divida(new BigDecimal(5000), 12));
        listaDivida.add(new Divida(new BigDecimal(3200), 6));
        BigDecimal valorAgrupado = dividaService.agruparValorRestanteDasDividas(listaDivida);
        assertEquals(BigDecimal.valueOf(8200), valorAgrupado);
    }

    @Test
    public void dado_duasDividasComValoresParciaisQuitados_quando_agruparDividasChamado_entao_retornarUmaDividaAcumulada() {
        List<Divida> listaDivida = new ArrayList<>();
        listaDivida.add(new Divida(new BigDecimal(7800), 4, new BigDecimal(3000), 2));
        listaDivida.add(new Divida(new BigDecimal(2000), 6, new BigDecimal(100), 6));
        BigDecimal valorAgrupado = dividaService.agruparValorRestanteDasDividas(listaDivida);
        assertEquals(BigDecimal.valueOf(6700), valorAgrupado);
    }

    @Test
    public void dado_umaDivida_quandoSimularPagamentoChamado_entao_retornarValorDasPrestacoes() {
        BigDecimal valorTotal = new BigDecimal(10000);
        BigDecimal entrada = new BigDecimal(2000);
        int prestacoes = 10;
        Divida novaDivida = dividaService.simularPagamento(valorTotal, entrada, prestacoes);
        assertEquals(BigDecimal.valueOf(9000.0), novaDivida.getValor());
        assertEquals(BigDecimal.valueOf(900.0), novaDivida.getValorPorPrestacao());
    }
}
