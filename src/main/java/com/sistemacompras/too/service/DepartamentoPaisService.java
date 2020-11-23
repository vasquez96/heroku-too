package com.sistemacompras.too.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.sistemacompras.too.entity.DepartamentoPais;
import com.sistemacompras.too.repository.DepartamentoPaisRepository;

@Service
public class DepartamentoPaisService {
	
    //Inyeccion de dependencias
    @Autowired
    private DepartamentoPaisRepository repository;

    //Muestra todos los departamentos pais de productos.
    public List<DepartamentoPais> listAll() {
        return repository.findAll();
    }
    //Guarda un departamento de pais
    public void save(DepartamentoPais departamentoPais){
        repository.save(departamentoPais);
    }
    //Obtiene un departamento de pais por su id
    public DepartamentoPais get(Long id){
        return repository.findById(id).get();
    }
    //Elimina un departamento de pais por su id
    public void delete(Long id){
        repository.deleteById(id);
    }
}
