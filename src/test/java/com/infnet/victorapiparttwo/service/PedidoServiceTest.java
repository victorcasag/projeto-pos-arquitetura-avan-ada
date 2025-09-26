package com.infnet.victorapiparttwo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import com.infnet.victorapiparttwo.model.domain.ItemPedido;
import com.infnet.victorapiparttwo.model.domain.Pedido;
import com.infnet.victorapiparttwo.model.domain.Produto;
import com.infnet.victorapiparttwo.model.domain.TipoProduto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PedidoServiceTest {

    private PedidoService service;

    @BeforeEach
    void setup() {
        service = new PedidoService();
    }

    @Test
    @DisplayName("calcularTotal returns 0.00 for null or empty pedido")
    void calcularTotal_emptyPedido_zero() {
        assertEquals(new BigDecimal("0.00"), service.calcularTotal(null));

        Pedido p = new Pedido();
        p.setItens(null);
        assertEquals(new BigDecimal("0.00"), service.calcularTotal(p));
    }

    @Test
    @DisplayName("calcularTotal sums item subtotals correctly")
    void calcularTotal_withItems_sumSubtotal() {
        Pedido p = new Pedido();
        ItemPedido i1 = new ItemPedido();
        Produto prod1 = new Produto(null, "A", "", new BigDecimal("10.00"), TipoProduto.ELETRONICO);
        i1.setProduto(prod1);
        i1.setQuantidade(2);
        i1.setPrecoUnitario(new BigDecimal("10.00"));

        ItemPedido i2 = new ItemPedido();
        Produto prod2 = new Produto(null, "B", "", new BigDecimal("5.50"), TipoProduto.VESTUARIO);
        i2.setProduto(prod2);
        i2.setQuantidade(1);
        i2.setPrecoUnitario(new BigDecimal("5.50"));

        p.addItem(i1);
        p.addItem(i2);

        assertEquals(new BigDecimal("25.50"), service.calcularTotal(p));
    }

    @Test
    @DisplayName("aplicarDescontoPercentual handles percentages, null and negative values")
    void aplicarDescontoPercentual_various() {
        Pedido p = new Pedido();
        ItemPedido i = new ItemPedido();
        Produto prod = new Produto(null, "X", "", new BigDecimal("100.00"), TipoProduto.ALIMENTO);
        i.setProduto(prod);
        i.setQuantidade(1);
        i.setPrecoUnitario(new BigDecimal("100.00"));
        p.addItem(i);

        // 10% off -> 90.00
        assertEquals(new BigDecimal("90.00"), service.aplicarDescontoPercentual(p, new BigDecimal("10")));

        // null percentual -> unchanged
        assertEquals(new BigDecimal("100.00"), service.aplicarDescontoPercentual(p, null));

        // 0 or negative percentual -> unchanged
        assertEquals(new BigDecimal("100.00"), service.aplicarDescontoPercentual(p, BigDecimal.ZERO));
        assertEquals(new BigDecimal("100.00"), service.aplicarDescontoPercentual(p, new BigDecimal("-5")));
    }

    @Test
    @DisplayName("validarProduto returns false for invalid products and true for valid ones")
    void validarProduto_cases() {
        Produto ok = new Produto(null, "Nome", "", new BigDecimal("1.00"), TipoProduto.SERVICO);
        assertTrue(service.validarProduto(ok));

        Produto noName = new Produto(null, "", "", new BigDecimal("1.00"), TipoProduto.SERVICO);
        assertFalse(service.validarProduto(noName));

        Produto nullPrice = new Produto(null, "Nome", "", null, TipoProduto.SERVICO);
        assertFalse(service.validarProduto(nullPrice));

        assertFalse(service.validarProduto(null));
        
        // additional branches: name == null, price zero and negative
        Produto nameNull = new Produto(null, null, "", new BigDecimal("1.00"), TipoProduto.SERVICO);
        assertFalse(service.validarProduto(nameNull));

        Produto priceZero = new Produto(null, "Nome", "", new BigDecimal("0.00"), TipoProduto.SERVICO);
        assertFalse(service.validarProduto(priceZero));

        Produto priceNegative = new Produto(null, "Nome", "", new BigDecimal("-1.00"), TipoProduto.SERVICO);
        assertFalse(service.validarProduto(priceNegative));
    }
}
