package com.sistemacompras.too.entity;

import javax.persistence.*;
import java.util.Date;

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

    public RequisicionDeArticulo(Long idRequisicionDeArticulo, String elaboradoPor, String autorizadoPor, String recibidoPor, Date fechaPedido, Date fechaEntrega) {
        this.idRequisicionDeArticulo = idRequisicionDeArticulo;
        this.elaboradoPor = elaboradoPor;
        this.autorizadoPor = autorizadoPor;
        this.recibidoPor = recibidoPor;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idRequisicionDeArticulo == null) ? 0 : idRequisicionDeArticulo.hashCode());
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
        RequisicionDeArticulo other = (RequisicionDeArticulo) obj;
        if (idRequisicionDeArticulo == null) {
            if (other.idRequisicionDeArticulo != null)
                return false;
        } else if (!idRequisicionDeArticulo.equals(other.idRequisicionDeArticulo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RequisicionDeArticulo [idRequisicionDeArticulo=" + idRequisicionDeArticulo + ", elaboradoPor="
                + elaboradoPor + ", autorizadoPor=" + autorizadoPor + ", recibidoPor=" + recibidoPor + ", fechaPedido="
                + fechaPedido + ", fechaEntrega=" + fechaEntrega + "]";
    }

}