package com.JuhAmil.Lista.de.Vendas.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_vendas")
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	private long id;
	private String vendedor;
	private Integer qtdVenda;
	private double precoUnitario;
	@ApiModelProperty(hidden = true)
	private double total;
	private LocalDate data;

	public Venda() {

	}

	public Venda(long id, String vendedor, Integer qtdVenda, double precoUnitario, double total, LocalDate data) {
		super();
		this.id = id;
		this.vendedor = vendedor;
		this.qtdVenda = qtdVenda;
		this.precoUnitario = precoUnitario;
		this.total = total;
		this.data = data;
	}

	public Venda(String vendedor, Integer qtdVenda, double precoUnitario, String data) {
		super();
		this.id = id;
		this.vendedor = vendedor;
		this.qtdVenda = qtdVenda;
		this.precoUnitario = precoUnitario;
		this.total = total;
		this.data = LocalDate.parse(data);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public Integer getQtdVenda() {
		return qtdVenda;
	}

	public void setQtdVenda(Integer qtdVenda) {
		this.qtdVenda = qtdVenda;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", vendedor=" + vendedor + ", qtdVenda=" + qtdVenda + ", precoUnitario="
				+ precoUnitario + ", total=" + total + ", data=" + data + "]";
	}

}
