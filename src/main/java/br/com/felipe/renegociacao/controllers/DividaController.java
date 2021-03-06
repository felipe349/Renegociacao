package br.com.felipe.renegociacao.controllers;

import br.com.felipe.renegociacao.models.Divida;
import br.com.felipe.renegociacao.services.DividaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/divida")
@RequiredArgsConstructor
public class DividaController {
    private final DividaService dividaService;

    @GetMapping(value = "/simular")
    public Divida simularDividas(Double valorAcumulado, Double entrada, Integer prestacoes) {
        return dividaService.
                simularPagamento(BigDecimal.valueOf(valorAcumulado), BigDecimal.valueOf(entrada), prestacoes);
    }

    @PostMapping(value = "/agrupar")
    public BigDecimal agruparDividas(@RequestBody List<Divida> listaDividas) {
        return dividaService.agruparValorRestanteDasDividas(listaDividas);
    }
}
