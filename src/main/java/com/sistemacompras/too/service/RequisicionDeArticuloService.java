package com.sistemacompras.too.service;

import com.sistemacompras.too.entity.RequisicionDeArticulo;
import com.sistemacompras.too.repository.RequisicionDeArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequisicionDeArticuloService {
    //Inyeccion de dependencias
    @Autowired
    private RequisicionDeArticuloRepository requisicionDeArticuloRepository;

    //Muestra todos los productos
    public List<RequisicionDeArticulo> listAll() {
        return requisicionDeArticuloRepository.findAll();
    }
    //Guarda un producto
    public void save(RequisicionDeArticulo requisicionDeArticulo){
        requisicionDeArticuloRepository.save(requisicionDeArticulo);
    }
    //Obtiene un producto por su id
    public RequisicionDeArticulo get(Long id){
        return requisicionDeArticuloRepository.findById(id).get();
    }
    //Elimina un producto por su id
    public void delete(Long id){
        requisicionDeArticuloRepository.deleteById(id);
    }
}
