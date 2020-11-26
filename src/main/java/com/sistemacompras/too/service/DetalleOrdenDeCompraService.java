package com.sistemacompras.too.service;

import com.sistemacompras.too.entity.DetalleOrdenDeCompra;
import com.sistemacompras.too.entity.ProductoRequisicion;
import com.sistemacompras.too.repository.DetalleOrdenDeCompraRepository;
import com.sistemacompras.too.repository.ProductoRequisicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetalleOrdenDeCompraService {
    //Inyeccion de dependencias
    @Autowired
    private DetalleOrdenDeCompraRepository detalleOrdenDeCompraRepository;
	@Autowired
    private DetalleOrdenDeCompraService detalleOrdenDeCompraService;

    //Muestra todos los detalles de la orden de compra
    public List<DetalleOrdenDeCompra> listAll() {
        return detalleOrdenDeCompraRepository.findAll();
    }
    //Guarda los detalles de la orden de compra
    public void save(DetalleOrdenDeCompra detalleOrdenDeCompra){
        detalleOrdenDeCompraRepository.save(detalleOrdenDeCompra);
    }
    //Obtiene un detalle de la orden de compra por su id
    public DetalleOrdenDeCompra get(Long id){
        return detalleOrdenDeCompraRepository.findById(id).get();
    }
    //Elimina un detalle de la orden de compra por su id
    public void delete(Long id){
        detalleOrdenDeCompraRepository.deleteById(id);
    }
    //Buscar listado detalle de la orden de compra por su id
    public List<DetalleOrdenDeCompra> listByIdDetalleOrdenCompra(Long id) {
        return detalleOrdenDeCompraRepository.findAllByIdDetalleOrdenDeCompra(id);
    }
}
