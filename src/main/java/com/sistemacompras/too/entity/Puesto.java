package com.sistemacompras.too.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Puesto {
	
	public Puesto() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPuesto;

	@Column
	private String nombrePuesto;

	public Long getIdPuesto() {
		return idPuesto;
	}

	public void setIdPuesto(Long idPuesto) {
		this.idPuesto = idPuesto;
	}

	public String getNombrePuesto() {
		return nombrePuesto;
	}

	public void setNombrePuesto(String nombrePuesto) {
		this.nombrePuesto = nombrePuesto;
	}

	public Puesto(Long idPuesto, String nombrePuesto) {
		this.idPuesto = idPuesto;
		this.nombrePuesto = nombrePuesto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPuesto == null) ? 0 : idPuesto.hashCode());
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
		Puesto other = (Puesto) obj;
		if (idPuesto == null) {
			if (other.idPuesto != null)
				return false;
		} else if (!idPuesto.equals(other.idPuesto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Puesto [idPuesto=" + idPuesto + ", nombrePuesto=" + nombrePuesto + "]";
	}
	
}
