package br.com.felipe.renegociacao.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Divida {
    private BigDecimal valor;
    private int prestacoes;
    private BigDecimal valorQuitado;
    private int prestacoesQuitadas;

    // Usado para conversão JSON
    public Divida() {}

    public Divida(BigDecimal valor, int prestacoes) {
        this.valor = valor;
        this.prestacoes = prestacoes;
        valorQuitado = new BigDecimal(0);
        prestacoesQuitadas = 0;
    }

    public Divida(BigDecimal valor, int prestacoes, BigDecimal valorQuitado, int prestacoesQuitadas) {
        this.valor = valor;
        this.prestacoes = prestacoes;
        this.valorQuitado = valorQuitado;
        this.prestacoesQuitadas = prestacoesQuitadas;
    }

    /**
     * Subtrai o valor quitado com o valor original da divida
     * @return o valor restante a ser pago da divida
     */
    public BigDecimal getValorRestante() {
        return this.getValor().subtract(this.getValorQuitado());
    }

    public BigDecimal getValorPorPrestacao() {
        int prestacoesRestantes = this.prestacoes - this.prestacoesQuitadas;
        return this.getValorRestante().divide(BigDecimal.valueOf(prestacoesRestantes));
    }
}
