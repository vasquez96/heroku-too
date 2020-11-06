package com.sistemacompras.too.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.sistemacompras.too.entity.Jefe;
import com.sistemacompras.too.repository.JefeRepository;

@Service
public class JefeService {

    //Inyeccion de dependencias
    @Autowired
    private JefeRepository repository;

    //Muestra todos los jefes
    public List<Jefe> listAll() {
        return repository.findAll();
    }
    //Guarda un Jefe
    public void save(Jefe jefe){
        repository.save(jefe);
    }
    //Obtiene un proveedor por su id
    public Jefe get(Long id){
        return repository.findById(id).get();
    }
    //Elimina un producto por su id
    public void delete(Long id){
        repository.deleteById(id);
    }
}
