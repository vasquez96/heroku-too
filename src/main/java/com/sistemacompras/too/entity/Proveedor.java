package com.sistemacompras.too.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Proveedor {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProveedor;
	
    @Column
    private Long idUser; //Este es el id del usuario
    @Column
    private String nombreProveedor;
    @Column
    private String apellidoProveedor;
    @Column
    private String generoProveedor;
    @Column
    private String direccionProveedor;
    @Column
    private int telefonoProveedor;
	public Proveedor(Long idProveedor, Long idUser, String nombreProveedor, String apellidoProveedor,
			String generoProveedor, String direccionProveedor, int telefonoProveedor) {
		this.idProveedor = idProveedor;
		this.idUser = idUser;
		this.nombreProveedor = nombreProveedor;
		this.apellidoProveedor = apellidoProveedor;
		this.generoProveedor = generoProveedor;
		this.direccionProveedor = direccionProveedor;
		this.telefonoProveedor = telefonoProveedor;
	}
	public Long getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public String getApellidoProveedor() {
		return apellidoProveedor;
	}
	public void setApellidoProveedor(String apellidoProveedor) {
		this.apellidoProveedor = apellidoProveedor;
	}
	public String getGeneroProveedor() {
		return generoProveedor;
	}
	public void setGeneroProveedor(String generoProveedor) {
		this.generoProveedor = generoProveedor;
	}
	public String getDireccionProveedor() {
		return direccionProveedor;
	}
	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}
	public int getTelefonoProveedor() {
		return telefonoProveedor;
	}
	public void setTelefonoProveedor(int telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}
    

    
    
}
