package com.sistemacompras.too.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.sistemacompras.too.entity.Municipio;
import com.sistemacompras.too.repository.MunicipioRepository;


@Service
public class MunicipioService {	
	 //Inyeccion de dependencias
    @Autowired
    private MunicipioRepository repository;

    //Muestra todos los municipios
    public List<Municipio> listAll() {
        return repository.findAll();
    }
    
    //Guarda un municipio
    public void save(Municipio municipio){
        repository.save(municipio);
    }
    
    //Obtiene un municipio por su id
    public Municipio get(Long id){
        return repository.findById(id).get();
    }
    
    //Elimina un municipio por su id
    public void delete(Long id){
        repository.deleteById(id);
    }
}
