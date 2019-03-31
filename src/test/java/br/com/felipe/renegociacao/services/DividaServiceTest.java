package br.com.felipe.renegociacao.services;

import br.com.felipe.renegociacao.models.Divida;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class DividaServiceTest {

    @Test
    public void dado_duasDividas_quando_agruparDividasChamado_entao_retornarUmaDividaAcumulada() {
        List<Divida> listaDivida = new ArrayList<>();
        listaDivida.add(new Divida(new BigDecimal(5000), 12));
        listaDivida.add(new Divida(new BigDecimal(3200), 6));
        DividaService dividaService = new DividaService();
        BigDecimal valorAgrupado = dividaService.agruparValorRestanteDasDividas(listaDivida);
        assertEquals(BigDecimal.valueOf(8200), valorAgrupado);
    }

    @Test
    public void dado_duasDividasComValoresParciaisQuitados_quando_agruparDividasChamado_entao_retornarUmaDividaAcumulada() {
        List<Divida> listaDivida = new ArrayList<>();
        listaDivida.add(new Divida(new BigDecimal(7800), 4, new BigDecimal(3000), 2));
        listaDivida.add(new Divida(new BigDecimal(2000), 6, new BigDecimal(100), 6));
        DividaService dividaService = new DividaService();
        BigDecimal valorAgrupado = dividaService.agruparValorRestanteDasDividas(listaDivida);
        assertEquals(BigDecimal.valueOf(6700), valorAgrupado);
    }
}
