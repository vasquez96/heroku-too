package com.sistemacompras.too.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

import com.sistemacompras.too.entity.Proveedor;
import com.sistemacompras.too.entity.User;
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
    //Obtiene proveedor por id de usuario
    public Long getidByUserId(Long idUser){
    	//Se crea una lista de tipo proveedor para que almacene TODOS los proveedores
    	List<Proveedor> listProveedores = new ArrayList();
    	listProveedores = listAll();
    	//Se va a iterar toda la lista de proveedores hasta encontrar el que buscamos
    	Long variable = (long) 0;
        for (Proveedor proveedor : listProveedores) {
        	//Si el username es igual al username que recibe el metodo como parametro entra      	
        	if(proveedor.getIdUser().getId().toString().equals(idUser.toString()))
        	{
        		variable = proveedor.getIdProveedor();
        	}
        }
    	 	
        return variable;
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
