package com.infnet.victorapiparttwo.model.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DomainCoverageTest {

    @Test
    @DisplayName("Domain helpers: exercise setters and getters for coverage")
    void exerciseUnusedSettersAndGetters() {
        Produto p = new Produto(1L, "Nome", "Desc", new BigDecimal("12.34"), TipoProduto.ALIMENTO);
        p.setId(99L);
        assertEquals(99L, p.getId());

        ItemPedido item = new ItemPedido();
        item.setQuantidade(5);
        item.setPrecoUnitario(new BigDecimal("2.00"));
        assertEquals(5, item.getQuantidade());
        assertEquals(new BigDecimal("2.00"), item.getPrecoUnitario());

        Pedido pedido = new Pedido();
        pedido.setId(123L);
        LocalDateTime now = LocalDateTime.now();
        pedido.setData(now);
        List<ItemPedido> itens = new ArrayList<>();
        itens.add(item);
        pedido.setItens(itens);

        assertEquals(123L, pedido.getId());
        assertEquals(now, pedido.getData());
        assertEquals(itens, pedido.getItens());
    }
}
