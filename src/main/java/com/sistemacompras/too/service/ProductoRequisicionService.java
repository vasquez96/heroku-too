package com.sistemacompras.too.service;

import com.sistemacompras.too.entity.ProductoRequisicion;
import com.sistemacompras.too.repository.ProductoRequisicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoRequisicionService {
    //Inyeccion de dependencias
    @Autowired
    private ProductoRequisicionRepository productoRequisicionRepository;

    //Muestra todos los productos
    public List<ProductoRequisicion> listAll() {
        return productoRequisicionRepository.findAll();
    }
    //Guarda un producto
    public void save(ProductoRequisicion productoRequisicion){
        productoRequisicionRepository.save(productoRequisicion);
    }
    //Obtiene un producto por su id
    public ProductoRequisicion get(Long id){
        return productoRequisicionRepository.findById(id).get();
    }
    //Elimina un producto por su id
    public void delete(Long id){
        productoRequisicionRepository.deleteById(id);
    }
}
