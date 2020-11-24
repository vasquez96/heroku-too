package com.sistemacompras.too.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.sistemacompras.too.entity.ProductoProveedor;
import com.sistemacompras.too.entity.User;
import com.sistemacompras.too.repository.UserRepository;

@Service
public class UserService {
	
    //Inyeccion de dependencias
    @Autowired
    private UserRepository repository;
    
    
    //Retorna el id dado un username|
    public Long getIdByUsername(String username) {
    	//Se crea una lista de tipo usauario para que almacene TODOS los users
    	List<User> listUsers = new ArrayList();
    	//Se guarda en una lista todos los user
    	listUsers = listAll();

    	Long variable = (long) 0;
    	//Se va a iterar toda la lista de users hasta encontrar el que buscamos
        for (User usuario : listUsers) {
        	//Si el username es igual al username que recibe el metodo como parametro entra
        	if(usuario.getUsername().equals(username))
        	{
        		variable = usuario.getId();
        	}
  
        }
        return (long) variable;
        
    }
    
    
    //Muestra todos los productos
    public List<User> listAll() {
        return (List<User>) repository.findAll();
    }
    //Guarda un producto
    public void save(User Proveedor){
        repository.save(Proveedor);
    }
    //Obtiene un proveedor por su id
    public User get(Long id){
        return repository.findById(id).get();
    }
    //Elimina un producto por su id
    public void delete(Long id){
        repository.deleteById(id);
    }

}
