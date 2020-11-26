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
    @Autowired
    private UserService userService;
    @Autowired
    private EmpleadoService empleadoService;

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

    public Empleado getEmpleadoByUsername(String username){
        //Se le asigna a userId el id de usuario que tiene la cuenta activa.
        Long userId = userService.getIdByUsername(username);
        //Se obtiene el idEmpleado por el idUser
        Long idEmpleado = empleadoService.getidByUserId(userId);
        //Se obtiene el objeto empleado mediante el get del empleadoService
        Empleado empleado = empleadoService.get(idEmpleado);
        return empleado;
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
