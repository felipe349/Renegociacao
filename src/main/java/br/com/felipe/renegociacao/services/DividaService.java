package br.com.felipe.renegociacao.services;

import br.com.felipe.renegociacao.models.Divida;

import java.math.BigDecimal;
import java.util.List;

public class DividaService {
    public BigDecimal agruparValorRestanteDasDividas(List<Divida> dividas) {
        return dividas.stream().map(Divida::getValorRestante).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
