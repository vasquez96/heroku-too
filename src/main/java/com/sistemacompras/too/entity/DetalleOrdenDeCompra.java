package com.sistemacompras.too.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class DetalleOrdenDeCompra {

	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idDetalleOrdenDeCompra;
	private Integer cantidad;
	private float precio;

	@ManyToOne
	@JoinColumn(name = "idOrdenDeCompra")
	private OrdenDeCompra idOrdenDeCompra;

	@ManyToOne
	@JoinColumn(name = "idProductoProveedor")
	private ProductoProveedor idProductoProveedor;

	//Constructor sin parametros
	public DetalleOrdenDeCompra() {

	}
	//Constructor con parametros

	public DetalleOrdenDeCompra(Long idDetalleOrdenDeCompra, OrdenDeCompra idOrdenDeCompra, ProductoProveedor idProductoProveedor) {
		this.idDetalleOrdenDeCompra = idDetalleOrdenDeCompra;
		this.idOrdenDeCompra = idOrdenDeCompra;
		this.idProductoProveedor = idProductoProveedor;
	}

	//Getter y setter

	public Long getIdDetalleOrdenDeCompra() {
		return idDetalleOrdenDeCompra;
	}

	public void setIdDetalleOrdenDeCompra(Long idDetalleOrdenDeCompra) {
		this.idDetalleOrdenDeCompra = idDetalleOrdenDeCompra;
	}

	public OrdenDeCompra getIdOrdenDeCompra() {
		return idOrdenDeCompra;
	}

	public void setIdOrdenDeCompra(OrdenDeCompra idOrdenDeCompra) {
		this.idOrdenDeCompra = idOrdenDeCompra;
	}

	public ProductoProveedor getIdProductoProveedor() {
		return idProductoProveedor;
	}

	public void setIdProductoProveedor(ProductoProveedor idProductoProveedor) {
		this.idProductoProveedor = idProductoProveedor;
	}

	//ToString


	@Override
	public String toString() {
		return "DetalleOrdenDeCompra{" +
				"idDetalleOrdenDeCompra=" + idDetalleOrdenDeCompra +
				", idOrdenDeCompra=" + idOrdenDeCompra +
				", idProductoProveedor=" + idProductoProveedor +
				'}';
	}
}