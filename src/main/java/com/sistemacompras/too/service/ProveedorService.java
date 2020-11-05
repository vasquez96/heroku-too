package com.sistemacompras.too.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.sistemacompras.too.entity.Proveedor;
import com.sistemacompras.too.repository.ProveedorRepository;

@Service
public class ProveedorService {

    //Inyeccion de dependencias
    @Autowired
    private ProveedorRepository repository;

    //Muestra todos los productos
    public List<Proveedor> listAll() {
        return repository.findAll();
    }
    //Guarda un producto
    public void save(Proveedor Proveedor){
        repository.save(Proveedor);
    }
    //Obtiene un proveedor por su id
    public Proveedor get(Long id){
        return repository.findById(id).get();
    }
    //Elimina un producto por su id
    public void delete(Long id){
        repository.deleteById(id);
    }
}
