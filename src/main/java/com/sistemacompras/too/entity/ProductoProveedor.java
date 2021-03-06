package com.sistemacompras.too.entity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class ProductoProveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProductoProveedor;

	@Column
	private String nombreProductoProveedor;
	@Column
	private int periodoDeGracia;
	@Column
	private float descuento;
	@Column
	private int numExistencia;
	@Column
	private double precio;
	@Column
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaVigenciaInicio;
	@Column
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaVigenciaFinal;
	@Column
	private String unidad;

	@ManyToOne
	@JoinColumn(name = "idProveedor")
	private Proveedor idProveedor;

	public ProductoProveedor(Long idProductoProveedor, String nombreProductoProveedor, int periodoDeGracia,
			float descuento, int numExistencia, double precio, Date fechaVigenciaInicio, Date fechaVigenciaFinal,
			String unidad, Proveedor idProveedor) {
		this.idProductoProveedor = idProductoProveedor;
		this.nombreProductoProveedor = nombreProductoProveedor;
		this.periodoDeGracia = periodoDeGracia;
		this.descuento = descuento;
		this.numExistencia = numExistencia;
		this.precio = precio;
		this.fechaVigenciaInicio = fechaVigenciaInicio;
		this.fechaVigenciaFinal = fechaVigenciaFinal;
		this.unidad = unidad;
		this.idProveedor = idProveedor;
	}

	public ProductoProveedor() {
	}

	public Long getIdProductoProveedor() {
		return idProductoProveedor;
	}

	public void setIdProductoProveedor(Long idProductoProveedor) {
		this.idProductoProveedor = idProductoProveedor;
	}

	public String getNombreProductoProveedor() {
		return nombreProductoProveedor;
	}

	public void setNombreProductoProveedor(String nombreProductoProveedor) {
		this.nombreProductoProveedor = nombreProductoProveedor;
	}

	public int getPeriodoDeGracia() {
		return periodoDeGracia;
	}

	public void setPeriodoDeGracia(int periodoDeGracia) {
		this.periodoDeGracia = periodoDeGracia;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public int getNumExistencia() {
		return numExistencia;
	}

	public void setNumExistencia(int numExistencia) {
		this.numExistencia = numExistencia;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFechaVigenciaInicio() {
		return fechaVigenciaInicio;
	}

	public void setFechaVigenciaInicio(Date fechaVigenciaInicio) {
		this.fechaVigenciaInicio = fechaVigenciaInicio;
	}

	public Date getFechaVigenciaFinal() {
		return fechaVigenciaFinal;
	}

	public void setFechaVigenciaFinal(Date fechaVigenciaFinal) {
		this.fechaVigenciaFinal = fechaVigenciaFinal;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public Proveedor getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Proveedor idProveedor) {
		this.idProveedor = idProveedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProductoProveedor == null) ? 0 : idProductoProveedor.hashCode());
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
		ProductoProveedor other = (ProductoProveedor) obj;
		if (idProductoProveedor == null) {
			if (other.idProductoProveedor != null)
				return false;
		} else if (!idProductoProveedor.equals(other.idProductoProveedor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductoProveedor [idProductoProveedor=" + idProductoProveedor + ", nombreProductoProveedor="
				+ nombreProductoProveedor + ", periodoDeGracia=" + periodoDeGracia + ", descuento=" + descuento
				+ ", numExistencia=" + numExistencia + ", precio=" + precio + ", fechaVigenciaInicio="
				+ fechaVigenciaInicio + ", fechaVigenciaFinal=" + fechaVigenciaFinal + ", unidad=" + unidad
				+ ", idProveedor=" + idProveedor + "]";
	}

	
	
}