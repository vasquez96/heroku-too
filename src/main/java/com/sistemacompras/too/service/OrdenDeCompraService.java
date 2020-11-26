package com.sistemacompras.too.service;

import com.sistemacompras.too.entity.OrdenDeCompra;
import com.sistemacompras.too.repository.OrdenDeCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdenDeCompraService {
    //Inyeccion de dependencias
    @Autowired
    private OrdenDeCompraRepository ordenDeCompraRepository;
    @Autowired
    private OrdenDeCompraService ordenDeCompraService;

    //Muestra todas las ordenes de compra
    public List<OrdenDeCompra> listAll() {
        return ordenDeCompraRepository.findAll();
    }

    //Guarda una orden de compra
    public void save(OrdenDeCompra ordenDeCompra){
        ordenDeCompraRepository.save(ordenDeCompra);
    }

    //Obtiene una orden de compra por su id
    public OrdenDeCompra get(Long id){
        return ordenDeCompraRepository.findById(id).get();
    }
    //Elimina una orden de compra por su id
    public void delete(Long id){
        ordenDeCompraRepository.deleteById(id);
    }
}
