package com.sistemacompras.too.entity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class ProductoEmpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProductoEmpresa;

    @Column
    private int min;
    @Column
    private int max;
    @Column
    private int cantidad;
    @Column
    private String nombre;

    public ProductoEmpresa() {
    }

    public ProductoEmpresa(Long idProductoEmpresa, int min, int max, int cantidad, String nombre) {
        this.idProductoEmpresa = idProductoEmpresa;
        this.min = min;
        this.max = max;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdProductoEmpresa() {
        return idProductoEmpresa;
    }

    public void setIdProductoEmpresa(Long idProductoEmpresa) {
        this.idProductoEmpresa = idProductoEmpresa;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoEmpresa that = (ProductoEmpresa) o;
        return Objects.equals(idProductoEmpresa, that.idProductoEmpresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProductoEmpresa);
    }

    @Override
    public String toString() {
        return "ProductoEmpresa{" +
                "idProductoEmpresa=" + idProductoEmpresa +
                ", min=" + min +
                ", max=" + max +
                ", cantidad=" + cantidad +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
