package com.sistemacompras.too.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

import com.sistemacompras.too.entity.Empleado;
import com.sistemacompras.too.entity.User;
import com.sistemacompras.too.repository.EmpleadoRepository;

@Service
public class EmpleadoService {
    //Inyeccion de dependencias
    @Autowired
    private EmpleadoRepository repository;

    //Muestra todos los empleados
    public List<Empleado> listAll() {
        return repository.findAll();
    }
    //Obtiene empleado por id de usuario
    public Long getidByUserId(Long idUser){
    	//Se crea una lista de tipo Empleado para que almacene TODOS los empleados
    	List<Empleado> listEmpleados = new ArrayList();
    	listEmpleados = listAll();
    	//Se va a iterar toda la lista de empleados hasta encontrar el que buscamos
    	Long variable = (long) 0;
        for (Empleado empleado : listEmpleados) {
        	//Si el username es igual al username que recibe el metodo como parametro entra      	
        	if(empleado.getIdUser().getId().toString().equals(idUser.toString()))
        	{
        		variable = empleado.getIdEmpleado();
        	}
        }
    	 	
        return variable;
    }
    
    //Guarda un empleado
    public void save(Empleado empleado){
        repository.save(empleado);
    }
    //Obtiene un empleado por su id
    public Empleado get(Long id){
        return repository.findById(id).get();
    }
    //Elimina un producto por su id
    public void delete(Long id){
        repository.deleteById(id);
    }

}
