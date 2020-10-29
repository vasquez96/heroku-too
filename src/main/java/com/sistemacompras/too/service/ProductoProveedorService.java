package com.sistemacompras.too.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.sistemacompras.too.entity.ProductoProveedor;
import com.sistemacompras.too.repository.ProductoProveedorRepository;

@Service
public class ProductoProveedorService {

    //Inyeccion de dependencias
    @Autowired
    private ProductoProveedorRepository repository;

    //Muestra todos los productos
    public List<ProductoProveedor> listAll() {
        return repository.findAll();
    }
    //Guarda un producto
    public void save(ProductoProveedor productoProveedor){
        repository.save(productoProveedor);
    }
    //Obtiene un producto por su id
    public ProductoProveedor get(Long id){
        return repository.findById(id).get();
    }
    //Elimina un producto por su id
    public void delete(Long id){
        repository.deleteById(id);
    }
}
