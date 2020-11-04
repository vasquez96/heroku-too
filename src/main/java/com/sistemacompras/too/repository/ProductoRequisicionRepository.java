package com.sistemacompras.too.repository;

import com.sistemacompras.too.entity.ProductoRequisicion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRequisicionRepository extends JpaRepository<ProductoRequisicion, Long> {
	List<ProductoRequisicion> findAllByIdRequisicionDeArticulo(Long id);
}
