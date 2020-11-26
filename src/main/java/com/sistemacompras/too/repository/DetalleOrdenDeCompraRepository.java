package com.sistemacompras.too.repository;

import com.sistemacompras.too.entity.DetalleOrdenDeCompra;
import com.sistemacompras.too.entity.ProductoRequisicion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleOrdenDeCompraRepository extends JpaRepository<DetalleOrdenDeCompra, Long> {
	List<DetalleOrdenDeCompra> findAllByIdDetalleOrdenDeCompra(Long id);
}
