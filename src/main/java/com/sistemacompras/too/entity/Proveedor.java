package com.sistemacompras.too.entity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Proveedor {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProveedor;
	
   // @Column
  ///  private Long idUser; //Este es el id del usuario
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
	@Column
	private String email ;
    
   @JoinColumn(name="idUser",unique = true)
   @OneToOne(cascade = CascadeType.ALL)
   private User idUser;
   
	@ManyToOne
	@JoinColumn(name = "idMunicipio")
	private Municipio idMunicipio;

	public Proveedor() {
	}

	public Proveedor(Long idProveedor, String nombreProveedor, String apellidoProveedor, String generoProveedor, String direccionProveedor, int telefonoProveedor, String email, User idUser, Municipio idMunicipio) {
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.apellidoProveedor = apellidoProveedor;
		this.generoProveedor = generoProveedor;
		this.direccionProveedor = direccionProveedor;
		this.telefonoProveedor = telefonoProveedor;
		this.email = email;
		this.idUser = idUser;
		this.idMunicipio = idMunicipio;
	}

	@Override
	public String toString() {
		return "Proveedor{" +
				"idProveedor=" + idProveedor +
				", nombreProveedor='" + nombreProveedor + '\'' +
				", apellidoProveedor='" + apellidoProveedor + '\'' +
				", generoProveedor='" + generoProveedor + '\'' +
				", direccionProveedor='" + direccionProveedor + '\'' +
				", telefonoProveedor=" + telefonoProveedor +
				", email='" + email + '\'' +
				", idUser=" + idUser +
				", idMunicipio=" + idMunicipio +
				'}';
	}

	public Long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	public Municipio getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(Municipio idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProveedor == null) ? 0 : idProveedor.hashCode());
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
		Proveedor other = (Proveedor) obj;
		if (idProveedor == null) {
			if (other.idProveedor != null)
				return false;
		} else if (!idProveedor.equals(other.idProveedor))
			return false;
		return true;
	}
		
}
