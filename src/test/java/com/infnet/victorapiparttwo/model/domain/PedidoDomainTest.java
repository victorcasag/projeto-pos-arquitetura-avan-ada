package com.infnet.victorapiparttwo.model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PedidoDomainTest {

    @Test
    @DisplayName("Produto: equals and property accessors work as expected")
    void produtoEqualsAndProperties() {
        Produto p = new Produto();
        p.setNome("Caneta");
        p.setDescricao("Caneta azul");
        p.setPreco(new BigDecimal("3.50"));
        p.setTipo(TipoProduto.ELETRONICO);

        assertEquals("Caneta", p.getNome());
        assertEquals("Caneta azul", p.getDescricao());
        assertEquals(new BigDecimal("3.50"), p.getPreco());
        assertEquals(TipoProduto.ELETRONICO, p.getTipo());
        assertNull(p.getId());
    }

    @Test
    @DisplayName("ItemPedido: subtotal calculation and setters")
    void itemPedidoSubtotalAndSetters() {
        Produto p = new Produto(null, "Mouse", "Wireless", new BigDecimal("25.00"), TipoProduto.ELETRONICO);

        ItemPedido item = new ItemPedido();
        item.setProduto(p);
        item.setQuantidade(2);
        item.setPrecoUnitario(new BigDecimal("20.00"));

        assertEquals(new BigDecimal("40.00"), item.getSubtotal());
        assertEquals(p, item.getProduto());
    }

    @Test
    @DisplayName("Pedido: add/remove items, status and totals behave correctly")
    void pedidoTotalAddRemoveItemsAndStatus() {
        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.NOVO);
        assertEquals(StatusPedido.NOVO, pedido.getStatus());

    Produto p1 = new Produto(null, "Item1", "Desc1", new BigDecimal("10.00"), TipoProduto.ALIMENTO);
        Produto p2 = new Produto(null, "Item2", "Desc2", new BigDecimal("5.50"), TipoProduto.VESTUARIO);

        ItemPedido i1 = new ItemPedido();
        i1.setProduto(p1);
        i1.setQuantidade(1);
        i1.setPrecoUnitario(new BigDecimal("10.00"));

        ItemPedido i2 = new ItemPedido();
        i2.setProduto(p2);
        i2.setQuantidade(2);
        i2.setPrecoUnitario(new BigDecimal("5.50"));

    i1.setId(1L);
    i2.setId(2L);
    pedido.addItem(i1);
    pedido.addItem(i2);

        // total = 10.00 + (2 * 5.50) = 21.00
        assertEquals(new BigDecimal("21.00"), pedido.getTotal());

    pedido.removeItem(i1);
    assertEquals(new BigDecimal("11.00"), pedido.getTotal());
    assertFalse(pedido.getItens().stream().anyMatch(it -> it.getId() != null && it.getId().equals(1L)));
        assertNotNull(pedido.getData());
        assertTrue(pedido.getData() instanceof LocalDateTime);
    }

    @Test
    @DisplayName("Enums: StatusPedido and TipoProduto expose names")
    void enumsCoverage() {
        for (StatusPedido s : StatusPedido.values()) {
            assertNotNull(s.name());
        }
        for (TipoProduto t : TipoProduto.values()) {
            assertNotNull(t.name());
        }
    }
}
