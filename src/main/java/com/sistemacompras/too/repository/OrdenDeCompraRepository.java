package com.sistemacompras.too.repository;

import com.sistemacompras.too.entity.OrdenDeCompra;
import com.sistemacompras.too.entity.RequisicionDeArticulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenDeCompraRepository extends JpaRepository<OrdenDeCompra, Long> {
}
