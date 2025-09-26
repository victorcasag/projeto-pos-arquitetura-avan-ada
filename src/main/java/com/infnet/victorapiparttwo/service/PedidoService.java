package com.infnet.victorapiparttwo.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.infnet.victorapiparttwo.model.domain.ItemPedido;
import com.infnet.victorapiparttwo.model.domain.Pedido;
import com.infnet.victorapiparttwo.model.domain.Produto;

public class PedidoService {

    public BigDecimal calcularTotal(Pedido pedido) {
        if (pedido == null || pedido.getItens() == null) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        }
        return pedido.getItens().stream()
                .map(ItemPedido::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal aplicarDescontoPercentual(Pedido pedido, BigDecimal percentual) {
        BigDecimal total = calcularTotal(pedido);
        if (percentual == null) {
            return total;
        }
        if (percentual.compareTo(BigDecimal.ZERO) <= 0) {
            return total;
        }

        BigDecimal factor = percentual.divide(new BigDecimal("100"), 6, RoundingMode.HALF_UP);
        BigDecimal desconto = total.multiply(factor);
        return total.subtract(desconto).setScale(2, RoundingMode.HALF_UP);
    }

    public boolean validarProduto(Produto produto) {
        if (produto == null) {
            return false;
        }
        if (produto.getNome() == null || produto.getNome().trim().isEmpty()) {
            return false;
        }
        if (produto.getPreco() == null) {
            return false;
        }
        return produto.getPreco().compareTo(BigDecimal.ZERO) > 0;
    }
}
