package com.sistemacompras.too.entity;

import javax.validation.constraints.*;

import javax.persistence.*;

@Entity
public class ProductoRequisicion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProductoRequisicion;

	@NotNull(message = "La cantidad debe ser obligatoria")
	@Min(value = 1, message = "La cantidad mínima es 1")
	@Column
	private int cantidad;


	public ProductoRequisicion() {

	}

	@ManyToOne
	@JoinColumn(name = "idRequisicionDeArticulo")
	private RequisicionDeArticulo idRequisicionDeArticulo;

	@ManyToOne
	@JoinColumn(name = "idProductoProveedor")
	private ProductoProveedor idProductoProveedor;

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
	public Long getIdRequisicionDeArticuloEnLong() {
		return idRequisicionDeArticulo.getIdRequisicionDeArticulo();
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
		return  "IdProductoRequisicion:" + idProductoRequisicion 
				+ "\n cantidad:" + cantidad
				+ "\n idProductoProveedor:"  + idProductoProveedor 
				+ "\n idRequisicionDeArticulo:" + idRequisicionDeArticulo 
				+ "------------------------------------------------------\n\n";
	}

}