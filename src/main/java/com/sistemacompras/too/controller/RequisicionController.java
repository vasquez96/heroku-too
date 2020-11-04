package com.sistemacompras.too.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.sistemacompras.too.entity.ProductoRequisicion;
import com.sistemacompras.too.entity.RequisicionDeArticulo;
import com.sistemacompras.too.service.ProductoRequisicionService;
import com.sistemacompras.too.service.RequisicionDeArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sistemacompras.too.entity.ProductoProveedor;
import com.sistemacompras.too.service.ProductoProveedorService;


@Controller
@RequestMapping("/jefe")
public class RequisicionController {
	
	@Autowired
    private ProductoProveedorService productoService;
    @Autowired
    private RequisicionDeArticuloService requisicionDeArticuloService;
	@Autowired
    private ProductoRequisicionService productoRequisicionService;

	//Metodo que lleva a la vista de crear requisicion
    @GetMapping("/requisicion/crear")
    public String menuAdmin(Model model) {
    	List<ProductoProveedor> listProductos = productoService.listAll();
    	ProductoRequisicion productoRequisicion = new ProductoRequisicion();
    	model.addAttribute("listProductos", listProductos);
    	model.addAttribute("productoRequisicion", productoRequisicion);
        return "RequisicionJefeDepartamento/crearRequisicion";
    }

    //Metodo que guarda una requisicion
    @RequestMapping(value = "/requisicion/save", method = RequestMethod.POST)
    public String guardarRequisicion(
            @RequestParam(name = "cantidad") ArrayList<Integer> cantidad,
            @RequestParam(name = "articulo") ArrayList<Long> articulo) {
        //Creando una requisicion de articulo
        RequisicionDeArticulo requisicionDeArticulo = new RequisicionDeArticulo();
        requisicionDeArticuloService.save(requisicionDeArticulo);
        System.out.println("Datos de cantidad: " + cantidad.size());
        System.out.println("Datos de articulo: " + articulo.size());
        //Ciclo que recorre la cantidad de datos solicitdados para la requisicion
        for(int i = 0; i <= cantidad.size(); i++){ //Inicio ciclo for
            System.out.println("Valor de la cantidad del articulo: " + cantidad.get(i));
            //System.out.println("Nombre de articulo: " + productoService.get(articulo.get(i)));
            //Creando una instancia de producto requisicion
            ProductoRequisicion productoRequisicion = new ProductoRequisicion();
            ProductoProveedor productoProveedor = productoService.get(articulo.get(i));
            System.out.println("Nombre de articulo: " + productoProveedor.getNombreProductoProveedor());
            //Agrengando la cantidad pedida del articulo
            productoRequisicion.setCantidad(cantidad.get(i));
            //Agregando el producto solicitado
            productoRequisicion.setIdProductoProveedor(productoProveedor);
            //Agregando la requisicion
            productoRequisicion.setIdRequisicionDeArticulo(requisicionDeArticulo);
            System.out.println("DATOS DE PRODUCTO REQUISICION: " + productoRequisicion.toString());
            //Guardando los productos de la requisicion
            productoRequisicionService.save(productoRequisicion);
        } //Fin ciclo for
        return "redirect:/jefe";
    }

    //Listar las requisiciones.
    @GetMapping("/requisicion")
    public String viewHomePage(Model model){
        List<RequisicionDeArticulo> listRequisicionDeArticulo = requisicionDeArticuloService.listAll();
        model.addAttribute("listRequisicionDeArticulo", listRequisicionDeArticulo);
        return "RequisicionJefeDepartamento/index"; //Nombre del html
    }

    //Ver las requisiciones.
    @RequestMapping("/requisicion/view/{id}")
    public ModelAndView showProductPage(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("requisicion/view");
        RequisicionDeArticulo requisicionDeArticulo = requisicionDeArticuloService.get(id);
        mav.addObject("requisicionDeArticulo", requisicionDeArticulo);
        return mav;
    }
}
