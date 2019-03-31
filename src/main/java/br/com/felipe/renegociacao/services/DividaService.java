package br.com.felipe.renegociacao.services;

import br.com.felipe.renegociacao.models.Divida;

import java.math.BigDecimal;
import java.util.List;

public interface DividaService {
    BigDecimal agruparValorRestanteDasDividas(List<Divida> dividas);
}
