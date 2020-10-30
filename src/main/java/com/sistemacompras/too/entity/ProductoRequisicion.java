package com.sistemacompras.too.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ProductoRequisicion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProductoRequisicion;
	
	@Column
	private int cantidad;
	
	
	public ProductoRequisicion() {
		
	}
	
	@JoinColumn(name="idProductoProveedor",unique = true)
    @OneToOne(cascade = CascadeType.ALL)
    private ProductoProveedor idProductoProveedor;
	
	@JoinColumn(name="idRequisicionDeArticulo",unique = true)
    @OneToOne(cascade = CascadeType.ALL)
    private RequisicionDeArticulo idRequisicionDeArticulo;

	public Long getIdProductoRequisicion() {
		return idProductoRequisicion;
	}

	public void setIdProductoRequisicion(Long idProductoRequisicion) {
		this.idProductoRequisicion = idProductoRequisicion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public ProductoProveedor getIdProductoProveedor() {
		return idProductoProveedor;
	}

	public void setIdProductoProveedor(ProductoProveedor idProductoProveedor) {
		this.idProductoProveedor = idProductoProveedor;
	}

	public RequisicionDeArticulo getIdRequisicionDeArticulo() {
		return idRequisicionDeArticulo;
	}

	public void setIdRequisicionDeArticulo(RequisicionDeArticulo idRequisicionDeArticulo) {
		this.idRequisicionDeArticulo = idRequisicionDeArticulo;
	}

	public ProductoRequisicion(Long idProductoRequisicion, int cantidad, ProductoProveedor idProductoProveedor,
			RequisicionDeArticulo idRequisicionDeArticulo) {
		this.idProductoRequisicion = idProductoRequisicion;
		this.cantidad = cantidad;
		this.idProductoProveedor = idProductoProveedor;
		this.idRequisicionDeArticulo = idRequisicionDeArticulo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProductoRequisicion == null) ? 0 : idProductoRequisicion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoRequisicion other = (ProductoRequisicion) obj;
		if (idProductoRequisicion == null) {
			if (other.idProductoRequisicion != null)
				return false;
		} else if (!idProductoRequisicion.equals(other.idProductoRequisicion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductoRequisicion [idProductoRequisicion=" + idProductoRequisicion + ", cantidad=" + cantidad
				+ ", idProductoProveedor=" + idProductoProveedor + ", idRequisicionDeArticulo="
				+ idRequisicionDeArticulo + "]";
	}
	
	
	
}
