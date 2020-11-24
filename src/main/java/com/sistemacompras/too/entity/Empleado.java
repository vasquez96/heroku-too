package com.sistemacompras.too.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEmpleado;
	
	@Column
	private String nombreEmpleado;
	@Column
	private String apellidoEmpleado;
	@Column
	private String genero;
	@Column
	private Boolean estadoCivil;
	@Column
	private String direccionEmpleado;
	@Column
	private int telefonoEmpleado;
	@Column
	private float salario;
	
	@ManyToOne
	@JoinColumn(name = "idDepartamento")
	private Departamento idDepartamento;
	
	@ManyToOne
	@JoinColumn(name = "idMunicipio")
	private Municipio idMunicipio;
	
	 @JoinColumn(name="idUser",unique = true)
	 @OneToOne(cascade = CascadeType.ALL)
     private User idUser;

	public Empleado(Long idEmpleado, String nombreEmpleado, String apellidoEmpleado, String genero, Boolean estadoCivil,
			String direccionEmpleado, int telefonoEmpleado, float salario, Departamento idDepartamento,
			Municipio idMunicipio, User idUser) {
		this.idEmpleado = idEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.apellidoEmpleado = apellidoEmpleado;
		this.genero = genero;
		this.estadoCivil = estadoCivil;
		this.direccionEmpleado = direccionEmpleado;
		this.telefonoEmpleado = telefonoEmpleado;
		this.salario = salario;
		this.idDepartamento = idDepartamento;
		this.idMunicipio = idMunicipio;
		this.idUser = idUser;
	}

	public Empleado() {
	}

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getApellidoEmpleado() {
		return apellidoEmpleado;
	}

	public void setApellidoEmpleado(String apellidoEmpleado) {
		this.apellidoEmpleado = apellidoEmpleado;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Boolean getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(Boolean estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getDireccionEmpleado() {
		return direccionEmpleado;
	}

	public void setDireccionEmpleado(String direccionEmpleado) {
		this.direccionEmpleado = direccionEmpleado;
	}

	public int getTelefonoEmpleado() {
		return telefonoEmpleado;
	}

	public void setTelefonoEmpleado(int telefonoEmpleado) {
		this.telefonoEmpleado = telefonoEmpleado;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Departamento getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Departamento idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Municipio getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(Municipio idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEmpleado == null) ? 0 : idEmpleado.hashCode());
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
		Empleado other = (Empleado) obj;
		if (idEmpleado == null) {
			if (other.idEmpleado != null)
				return false;
		} else if (!idEmpleado.equals(other.idEmpleado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", apellidoEmpleado="
				+ apellidoEmpleado + ", genero=" + genero + ", estadoCivil=" + estadoCivil + ", direccionEmpleado="
				+ direccionEmpleado + ", telefonoEmpleado=" + telefonoEmpleado + ", salario=" + salario
				+ ", idDepartamento=" + idDepartamento + ", idMunicipio=" + idMunicipio + ", idUser=" + idUser + "]";
	}

 
}
