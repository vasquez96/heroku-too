package com.sistemacompras.too.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.sistemacompras.too.entity.Departamento;
import com.sistemacompras.too.repository.DepartamentoRepository;

@Service
public class DepartamentoService {
    //Inyeccion de dependencias
    @Autowired
    private DepartamentoRepository repository;

    //Muestra todos los departamentos
    public List<Departamento> listAll() {
        return repository.findAll();
    }
    //Guarda un departamento
    public void save(Departamento departamento){
        repository.save(departamento);
    }
    //Obtiene un departamento por su id
    public Departamento get(Long id){
        return repository.findById(id).get();
    }
    //Elimina un departamento por su id
    public void delete(Long id){
        repository.deleteById(id);
    }

}
