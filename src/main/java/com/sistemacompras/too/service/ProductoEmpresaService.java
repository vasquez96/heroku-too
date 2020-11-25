package com.sistemacompras.too.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.sistemacompras.too.entity.ProductoEmpresa;
import com.sistemacompras.too.repository.ProductoEmpresaRepository;

@Service
public class ProductoEmpresaService {

    //Inyeccion de dependencias
    @Autowired
    private ProductoEmpresaRepository repository;

    //Muestra todos los productos
    public List<ProductoEmpresa> listAll() {
        return repository.findAll();
    }
    //Guarda un producto
    public void save(ProductoEmpresa productoEmpresa){
        repository.save(productoEmpresa);
    }
    //Obtiene un producto por su id
    public ProductoEmpresa get(Long id){
        return repository.findById(id).get();
    }
    //Elimina un producto por su id
    public void delete(Long id){
        repository.deleteById(id);
    }
}
