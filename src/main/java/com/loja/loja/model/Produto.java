package com.loja.loja.model;
import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import javassist.SerialVersionUID;

public class Produto {
	
		
	@JsonProperty(value = "cdProduto")	
 	private Long cdProduto;
	@JsonProperty(value = "descricao")
    private String descricao;
	@JsonProperty(value = "qtd")
    private int qtd;
	@JsonProperty(value = "vlUnit")
    private BigDecimal vlUnit;
	@JsonProperty(value = "vlCompra")
    private BigDecimal vlcompra;
	@JsonProperty(value = "vlVenda")
    private BigDecimal vlVenda;
    
    public Produto(){}

	public Long getCdProduto() {
		return cdProduto;
	}

	public void setCdProduto(Long cdProduto) {
		this.cdProduto = cdProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public BigDecimal getVlUnit() {
		return vlUnit;
	}

	public void setVlUnit(BigDecimal vlUnit) {
		this.vlUnit = vlUnit;
	}

	public BigDecimal getVlcompra() {
		return vlcompra;
	}

	public void setVlcompra(BigDecimal vlcompra) {
		this.vlcompra = vlcompra;
	}

	public BigDecimal getVlVenda() {
		return vlVenda;
	}

	public void setVlVenda(BigDecimal vlVenda) {
		this.vlVenda = vlVenda;
	}

	@Override
	public String toString() {
		return "Produto [cdProduto=" + cdProduto + ", descricao=" + descricao + ", qtd=" + qtd + ", vlUnit=" + vlUnit
				+ ", vlcompra=" + vlcompra + ", vlVenda=" + vlVenda + "]";
	}

    

    
}