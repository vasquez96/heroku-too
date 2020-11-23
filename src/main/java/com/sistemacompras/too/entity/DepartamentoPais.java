package com.sistemacompras.too.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DepartamentoPais {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idDepartamentoPais;
	
	@Column
	private String nombreDepartamento;
	

	public DepartamentoPais() {
		
	}

	public DepartamentoPais(Long idDepartamentoPais, String nombreDepartamento) 
	{
		this.idDepartamentoPais = idDepartamentoPais;
		this.nombreDepartamento = nombreDepartamento;
	}

	public Long getIdDepartamentoPais() {
		return idDepartamentoPais;
	}

	public void setIdDepartamentoPais(Long idDepartamentoPais) {
		this.idDepartamentoPais = idDepartamentoPais;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDepartamentoPais == null) ? 0 : idDepartamentoPais.hashCode());
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
		DepartamentoPais other = (DepartamentoPais) obj;
		if (idDepartamentoPais == null) {
			if (other.idDepartamentoPais != null)
				return false;
		} else if (!idDepartamentoPais.equals(other.idDepartamentoPais))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DepartamentoPais [idDepartamentoPais=" + idDepartamentoPais + ", nombreDepartamento="
				+ nombreDepartamento + "]";
	}
	
	
	

}
