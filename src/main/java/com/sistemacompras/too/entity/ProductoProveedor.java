package com.sistemacompras.too.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private Long idProveedor;
    @Column
    private String nombreProductoProveedor;
    @Column
    private int periodoDeGracia;
    @Column
    private float descuento;
    @Column
    private int numExistencia;
    @Column
    private int cantidadExistencia;
    @Column
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date fechaVigenciaInicio;
    @Column
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date fechaVigenciaFinal; 
    @Column
    private String unidad;
    @Column
    private String direccion;
    
	public ProductoProveedor(Long idProductoProveedor, Long idProveedor, String nombreProductoProveedor,
			int periodoDeGracia, float descuento, int numExistencia, int cantidadExistencia, Date fechaVigenciaInicio,
			Date fechaVigenciaFinal, String unidad, String direccion) {
		this.idProductoProveedor = idProductoProveedor;
		this.idProveedor = idProveedor;
		this.nombreProductoProveedor = nombreProductoProveedor;
		this.periodoDeGracia = periodoDeGracia;
		this.descuento = descuento;
		this.numExistencia = numExistencia;
		this.cantidadExistencia = cantidadExistencia;
		this.fechaVigenciaInicio = fechaVigenciaInicio;
		this.fechaVigenciaFinal = fechaVigenciaFinal;
		this.unidad = unidad;
		this.direccion = direccion;
	}
	
	
	
	
	
	

	public ProductoProveedor() {
		
	}







	public Long getIdProductoProveedor() {
		return idProductoProveedor;
	}

	public void setIdProductoProveedor(Long idProductoProveedor) {
		this.idProductoProveedor = idProductoProveedor;
	}

	public Long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
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

	public int getCantidadExistencia() {
		return cantidadExistencia;
	}

	public void setCantidadExistencia(int cantidadExistencia) {
		this.cantidadExistencia = cantidadExistencia;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
    


}
