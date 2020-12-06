package com.sistemacompras.too.service;

import com.sistemacompras.too.entity.NotasDeRemision;
import com.sistemacompras.too.entity.OrdenDeCompra;
import com.sistemacompras.too.repository.NotaRemisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaDeRemisionService {
    //Inyeccion de dependencias
    @Autowired
    private NotaRemisionRepository notaDeRemisionRepository;

    //Muestra todas las ordenes de compra
    public List<NotasDeRemision> listAll() {
        return notaDeRemisionRepository.findAll();
    }

    //Guarda una orden de compra
    public void save(NotasDeRemision notasDeRemision){
        notaDeRemisionRepository.save(notasDeRemision);
    }

    //Obtiene una orden de compra por su id
    public NotasDeRemision get(Long id){
        return notaDeRemisionRepository.findById(id).get();
    }
    //Elimina una orden de compra por su id
    public void delete(Long id){
        notaDeRemisionRepository.deleteById(id);
    }
}
