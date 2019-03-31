package br.com.felipe.renegociacao.models;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Divida {
    private BigDecimal valor;
    private int prestacoes;
    private BigDecimal valorQuitado;
    private int prestacoesQuitadas;

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

    public BigDecimal getValorRestante() {
        return this.getValor().subtract(this.getValorQuitado());
    }
}
