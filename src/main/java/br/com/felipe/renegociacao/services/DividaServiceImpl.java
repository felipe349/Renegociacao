package br.com.felipe.renegociacao.services;

import br.com.felipe.renegociacao.models.Divida;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
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

    /**
     * Simula o pagamento da divida atraves de um calculo de juros em cima do valor total da divida, de acordo com
     * o numero de prestacoes o juros aumenta
     * @param valorAcumulado da divida
     * @param entrada de pagamento para a renegociacao
     * @param prestacoes em que se deseja pagar a divida
     * @return nova divida contendo valor atualizado com juros e prestacoes
     */
    @Override
    public Divida simularPagamento(BigDecimal valorAcumulado, BigDecimal entrada, int prestacoes) {
        double juros = 1 + (5 + (prestacoes * 0.5)) / 100;
        BigDecimal valorComJuros = valorAcumulado.multiply(BigDecimal.valueOf(juros));
        BigDecimal valorRestanteComJuros = valorComJuros.subtract(entrada);
        return new Divida(valorRestanteComJuros, prestacoes);
    }

}
