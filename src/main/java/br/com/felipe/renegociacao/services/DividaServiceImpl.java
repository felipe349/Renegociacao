package br.com.felipe.renegociacao.services;

import br.com.felipe.renegociacao.models.Divida;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DividaServiceImpl implements DividaService {

    /**
     * Junta o valor restante das dividas recebidas agrupando-as em uma só
     * @param dividas para serem agrupadas
     * @return valor agrupado restante das dividas
     */
    @Override
    public BigDecimal agruparValorRestanteDasDividas(List<Divida> dividas) {
        return dividas.stream().map(Divida::getValorRestante).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public Divida simularPagamento(BigDecimal valorAcumulado, BigDecimal entrada, int prestacoes) {
        double juros = 5 + (prestacoes * 0.5);
        BigDecimal valorRestante = valorAcumulado.subtract(entrada);
        BigDecimal acrescimoDeJuros = valorAcumulado.divide(BigDecimal.valueOf(juros));
        valorRestante = valorRestante.add(acrescimoDeJuros);
        return new Divida(valorRestante, prestacoes);
    }

}
