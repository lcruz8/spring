package io.github.lcruz8.domain.entity;

import java.math.BigDecimal;

public class ItemPedido {
    private Integer id;
    private Integer pedidoId;
    private Integer produtoId;
    private BigDecimal qtdProduto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public BigDecimal getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(BigDecimal qtdProduto) {
        this.qtdProduto = qtdProduto;
    }
}
