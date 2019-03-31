package br.com.felipe.renegociacao.services;

import br.com.felipe.renegociacao.models.Divida;

import java.math.BigDecimal;
import java.util.List;

public class DividaService {

    /**
     * Junta o valor restante das dividas recebidas agrupando-as em uma só
     * @param dividas para serem agrupadas
     * @return valor agrupado restante das dividas
     */
    public BigDecimal agruparValorRestanteDasDividas(List<Divida> dividas) {
        return dividas.stream().map(Divida::getValorRestante).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
