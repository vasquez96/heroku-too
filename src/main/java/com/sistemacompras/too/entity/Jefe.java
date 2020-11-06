package com.sistemacompras.too.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Jefe {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idJefe;
	
	 @Column
	    private String nombreProveedor;
	    @Column
	    private String apellidoProveedor;
	    @Column
	    private String generoProveedor;
	    
	    @JoinColumn(name="idUser",unique = true)
	    @OneToOne(cascade = CascadeType.ALL)
	    private User idUser;

		public Jefe(Long idJefe, String nombreProveedor, String apellidoProveedor, String generoProveedor,
				User idUser) {
			this.idJefe = idJefe;
			this.nombreProveedor = nombreProveedor;
			this.apellidoProveedor = apellidoProveedor;
			this.generoProveedor = generoProveedor;
			this.idUser = idUser;
		}

		public Jefe() {
		}

		public Long getIdJefe() {
			return idJefe;
		}

		public void setIdJefe(Long idJefe) {
			this.idJefe = idJefe;
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
			result = prime * result + ((idJefe == null) ? 0 : idJefe.hashCode());
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
			Jefe other = (Jefe) obj;
			if (idJefe == null) {
				if (other.idJefe != null)
					return false;
			} else if (!idJefe.equals(other.idJefe))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Jefe [idJefe=" + idJefe + ", nombreProveedor=" + nombreProveedor + ", apellidoProveedor="
					+ apellidoProveedor + ", generoProveedor=" + generoProveedor + ", idUser=" + idUser + "]";
		}
	    
	
}
