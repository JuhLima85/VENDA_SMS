package com.JuhAmil.Lista.de.Vendas.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="tb_vendas")
public class Venda implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String vendedor;
	private Integer visitas;
	private double venda;
	private Integer total;
	private LocalDate data;

	public Venda() {

	}
		
	public Venda(long id, String vendedor, Integer visitas, double venda, Integer total, LocalDate data) {
		super();
		this.id = id;
		this.vendedor = vendedor;
		this.visitas = visitas;
		this.venda = venda;
		this.total = total;
		this.data = data;
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

	public Integer getVisitas() {
		return visitas;
	}

	public void setVisitas(Integer visitas) {
		this.visitas = visitas;
	}

	public double getVenda() {
		return venda;
	}

	public void setVenda(double venda) {
		this.venda = venda;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
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
		return "Venda [id=" + id + ", vendedor=" + vendedor + ", visitas=" + visitas + ", venda=" + venda + ", total="
				+ total + ", data=" + data + "]";
	}
	
	
	
	

	
	
	

}
