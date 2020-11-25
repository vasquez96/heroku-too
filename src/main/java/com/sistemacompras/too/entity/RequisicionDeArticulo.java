package com.sistemacompras.too.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class RequisicionDeArticulo {

    public RequisicionDeArticulo(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRequisicionDeArticulo;

    @Column
    private String elaboradoPor;
    @Column
    private String autorizadoPor;
    @Column
    private String recibidoPor;
    @Column
    private Date fechaPedido;
    @Column
    private Date fechaEntrega;

	@ManyToOne
	@JoinColumn(name = "idEmpleado")
	private Empleado idEmpleado;

	@ManyToOne
	@JoinColumn(name = "idDepartamento")
	private Departamento idDepartamento;

	public RequisicionDeArticulo(Long idRequisicionDeArticulo, String elaboradoPor, String autorizadoPor, String recibidoPor, Date fechaPedido, Date fechaEntrega, Empleado idEmpleado, Departamento idDepartamento) {
		this.idRequisicionDeArticulo = idRequisicionDeArticulo;
		this.elaboradoPor = elaboradoPor;
		this.autorizadoPor = autorizadoPor;
		this.recibidoPor = recibidoPor;
		this.fechaPedido = fechaPedido;
		this.fechaEntrega = fechaEntrega;
		this.idEmpleado = idEmpleado;
		this.idDepartamento = idDepartamento;
	}

	public Long getIdRequisicionDeArticulo() {
		return idRequisicionDeArticulo;
	}

	public void setIdRequisicionDeArticulo(Long idRequisicionDeArticulo) {
		this.idRequisicionDeArticulo = idRequisicionDeArticulo;
	}

	public String getElaboradoPor() {
		return elaboradoPor;
	}

	public void setElaboradoPor(String elaboradoPor) {
		this.elaboradoPor = elaboradoPor;
	}

	public String getAutorizadoPor() {
		return autorizadoPor;
	}

	public void setAutorizadoPor(String autorizadoPor) {
		this.autorizadoPor = autorizadoPor;
	}

	public String getRecibidoPor() {
		return recibidoPor;
	}

	public void setRecibidoPor(String recibidoPor) {
		this.recibidoPor = recibidoPor;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Empleado getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Empleado idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Departamento getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Departamento idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RequisicionDeArticulo that = (RequisicionDeArticulo) o;
		return idRequisicionDeArticulo.equals(that.idRequisicionDeArticulo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idRequisicionDeArticulo);
	}

	@Override
	public String toString() {
		return "RequisicionDeArticulo{" +
				"idRequisicionDeArticulo=" + idRequisicionDeArticulo +
				", elaboradoPor='" + elaboradoPor + '\'' +
				", autorizadoPor='" + autorizadoPor + '\'' +
				", recibidoPor='" + recibidoPor + '\'' +
				", fechaPedido=" + fechaPedido +
				", fechaEntrega=" + fechaEntrega +
				", idEmpleado=" + idEmpleado +
				", idDepartamento=" + idDepartamento +
				'}';
	}
}