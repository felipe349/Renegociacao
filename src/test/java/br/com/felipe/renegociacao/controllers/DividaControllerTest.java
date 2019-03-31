package br.com.felipe.renegociacao.controllers;

import br.com.felipe.renegociacao.models.Divida;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DividaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void dado_listaDivida_quando_endpointAgruparChamado_entao_retornarValorAgrupadoDasDividas() throws Exception {
        List<Divida> listaDivida = new ArrayList<>();
        listaDivida.add(new Divida(new BigDecimal(3000), 10));
        listaDivida.add(new Divida(new BigDecimal(2000), 5));
        ObjectMapper om = new ObjectMapper();
        String jsonObject = om.writeValueAsString(listaDivida);
        this.mockMvc.perform(post("/api/v1/divida/agrupar").contentType("application/json").content(jsonObject))
                .andDo(print()).andExpect(content().string(equalTo("5000")));
    }
}