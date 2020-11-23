package com.sistemacompras.too.entity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Municipio {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMunicipio;
	
    @Column
    private String nombreMunicipio;
    
	@ManyToOne
	@JoinColumn(name = "idDepartamentoPais")
	private DepartamentoPais idDepartamentoPais;

	public Municipio(Long idMunicipio, String nombreMunicipio, DepartamentoPais idDepartamentoPais) {
		this.idMunicipio = idMunicipio;
		this.nombreMunicipio = nombreMunicipio;
		this.idDepartamentoPais = idDepartamentoPais;
	}

	public Municipio() {
	}

	public Long getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(Long idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getNombreMunicipio() {
		return nombreMunicipio;
	}

	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}

	public DepartamentoPais getIdDepartamentoPais() {
		return idDepartamentoPais;
	}

	public void setIdDepartamentoPais(DepartamentoPais idDepartamentoPais) {
		this.idDepartamentoPais = idDepartamentoPais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMunicipio == null) ? 0 : idMunicipio.hashCode());
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
		Municipio other = (Municipio) obj;
		if (idMunicipio == null) {
			if (other.idMunicipio != null)
				return false;
		} else if (!idMunicipio.equals(other.idMunicipio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Municipio [idMunicipio=" + idMunicipio + ", nombreMunicipio=" + nombreMunicipio
				+ ", idDepartamentoPais=" + idDepartamentoPais + "]";
	}
	
	
	
	

}
