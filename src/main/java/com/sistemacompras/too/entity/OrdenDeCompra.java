package com.sistemacompras.too.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class OrdenDeCompra {
	//Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOrdenDeCompra;

    private Float totalCompra;
    private Date fechaPedido;
    private Date fechaPago;
	private String teminoEntrega;

	@ManyToOne
	@JoinColumn(name = "idProveedor")
	private Proveedor idProveedor;

	//Constructor sin parametros

	public OrdenDeCompra() {
	}

	//Constructor con parametros

	public OrdenDeCompra(Long idOrdenDeCompra, Float totalCompra, Date fechaPedido, Date fechaPago, String teminoEntrega, Proveedor idProveedor) {
		this.idOrdenDeCompra = idOrdenDeCompra;
		this.totalCompra = totalCompra;
		this.fechaPedido = fechaPedido;
		this.fechaPago = fechaPago;
		this.teminoEntrega = teminoEntrega;
		this.idProveedor = idProveedor;
	}

	//Getter y setter


	public Long getIdOrdenDeCompra() {
		return idOrdenDeCompra;
	}

	public void setIdOrdenDeCompra(Long idOrdenDeCompra) {
		this.idOrdenDeCompra = idOrdenDeCompra;
	}

	public Float getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(Float totalCompra) {
		this.totalCompra = totalCompra;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getTeminoEntrega() {
		return teminoEntrega;
	}

	public void setTeminoEntrega(String teminoEntrega) {
		this.teminoEntrega = teminoEntrega;
	}

	public Proveedor getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Proveedor idProveedor) {
		this.idProveedor = idProveedor;
	}

	//ToString

	@Override
	public String toString() {
		return "OrdenDeCompra{" +
				"idOrdenDeCompra=" + idOrdenDeCompra +
				", totalCompra=" + totalCompra +
				", fechaPedido=" + fechaPedido +
				", fechaPago=" + fechaPago +
				", teminoEntrega='" + teminoEntrega + '\'' +
				", idProveedor=" + idProveedor +
				'}';
	}
}