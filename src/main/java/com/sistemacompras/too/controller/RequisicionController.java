package com.sistemacompras.too.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import org.springframework.web.servlet.ModelAndView;


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
    	
    	String x, y;
    	String b = "soda";
    	String c = "soda";
        for(int j = 0; j < listProductos.size(); j++){ //Inicio ciclo for
            for(int i = 0; i < listProductos.size(); i++){ //Inicio ciclo for
                if(i != j) 
                {
                	x = listProductos.get(i).getNombreProductoProveedor().toLowerCase();
                	y = listProductos.get(j).getNombreProductoProveedor().toLowerCase();
                	//listProductos.get(i).getNombreProductoProveedor().equals(listProductos.get(j).getNombreProductoProveedor())
                	System.out.println(y + " vs " + x + " Posicion: " + j + "\n");                		
                	if (x.equals(y))
            		{
            			listProductos.remove(j);
            			System.out.println("Entro en la posicion " + (j));    
            		}
                }
            }
        }
        
        for(int i = 0; i < listProductos.size(); i++){ //Inicio ciclo for
        	listProductos.get(i).setNombreProductoProveedor(listProductos.get(i).getNombreProductoProveedor().toLowerCase());
        }
        
        
        for (ProductoProveedor producto : listProductos) {
        	System.out.println(producto.getNombreProductoProveedor());        	
        }
    	
        
    	
    	
    	model.addAttribute("listProductos", listProductos);
    	model.addAttribute("productoRequisicion", productoRequisicion);
        return "RequisicionJefeDepartamento/crearRequisicion";
    }

    //Listar las requisiciones.
    @RequestMapping("/requisicion")
    public String viewHomePage(Model model){
        List<RequisicionDeArticulo> listRequisicionDeArticulo = requisicionDeArticuloService.listAll();
        model.addAttribute("listRequisicionDeArticulo", listRequisicionDeArticulo);
        return "RequisicionJefeDepartamento/index"; //Nombre del html
    }

    //Metodo que guarda una requisicion
    @RequestMapping(value = "/requisicion/save", method = RequestMethod.POST)
    public String guardarRequisicion(
            @RequestParam(name = "cantidad") ArrayList<Integer> cantidad,
            @RequestParam(name = "articulo") ArrayList<Long> articulo) {
        //Creando una instancia de fecha para capturar la fecha del hoy
        Date fecha = new Date();
        //Creando una requisicion de articulo
        RequisicionDeArticulo requisicionDeArticulo = new RequisicionDeArticulo();
        //Modificando la fecha de la elaboracion de la requisicion
        requisicionDeArticulo.setFechaPedido(fecha);
        requisicionDeArticuloService.save(requisicionDeArticulo);
        //System.out.println("Datos de cantidad: " + cantidad.size());
        //System.out.println("Datos de articulo: " + articulo.size());
        //Ciclo que recorre la cantidad de datos solicitdados para la requisicion
        for(int i = 0; i < cantidad.size(); i++){ //Inicio ciclo for
            //System.out.println("Valor de la cantidad del articulo: " + cantidad.get(i));
            //System.out.println("Nombre de articulo: " + productoService.get(articulo.get(i)));
            //Creando una instancia de producto requisicion
            ProductoRequisicion productoRequisicion = new ProductoRequisicion();
            ProductoProveedor productoProveedor = productoService.get(articulo.get(i));
            //System.out.println("Nombre de articulo: " + productoProveedor.getNombreProductoProveedor());
            //Agrengando la cantidad pedida del articulo
            productoRequisicion.setCantidad(cantidad.get(i));
            //Agregando el producto solicitado
            productoRequisicion.setIdProductoProveedor(productoProveedor);
            //Agregando la requisicion
            productoRequisicion.setIdRequisicionDeArticulo(requisicionDeArticulo);
            //System.out.println("DATOS DE PRODUCTO REQUISICION: " + productoRequisicion.toString());
            //Guardando los productos de la requisicion
            productoRequisicionService.save(productoRequisicion);
        } //Fin ciclo for
        return "redirect:/jefe/requisicion";
    }

    //Ver las requisiciones.
    @RequestMapping("/requisicion/view/{id}")
    public ModelAndView showProductPage(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("RequisicionJefeDepartamento/view");
        RequisicionDeArticulo requisicionDeArticulo = requisicionDeArticuloService.get(id);
        List<ProductoRequisicion> productoRequisicion = productoRequisicionService.listadoPorId(id);

        for (ProductoRequisicion nombre : productoRequisicion) {
            System.out.println(nombre.toString());    
        	}
         
       // System.out.println(requisicionDeArticulo.toString());
        mav.addObject("productoRequisicion", productoRequisicion);
        mav.addObject("requisicionArticulo", requisicionDeArticulo);
        return mav;
    }

    //Editar las requisiciones.
    @RequestMapping("/requisicion/edit/{id}")
    public ModelAndView editarRequisicion(@PathVariable(name = "id") Long id, Model model){
        ModelAndView mav = new ModelAndView("RequisicionJefeDepartamento/editarRequisicion");
        RequisicionDeArticulo requisicionDeArticulo = requisicionDeArticuloService.get(id);

        //Obteniendo los productos por medio del id de la requisicion
        List<ProductoRequisicion> productoRequisicion = productoRequisicionService.listadoPorId(id);

        for (ProductoRequisicion nombre : productoRequisicion) {
            System.out.println(nombre.toString());
        }
        //Obteniendo todos los productos
        List<ProductoProveedor> listProductos = productoService.listAll();
        //Enviando los productos a la vista
        model.addAttribute("listProductos", listProductos);
        model.addAttribute("idReq", id);
        // System.out.println(requisicionDeArticulo.toString());
        mav.addObject("productoRequisicion", productoRequisicion);
        return mav;
    }
    //Eliminar requisicion
    @RequestMapping("/requisicion/eliminar/{id}")
    public String deleteRequisicion(@PathVariable(name = "id") Long id){

        List<ProductoRequisicion> productoRequisicion = productoRequisicionService.listadoPorId(id);

        for (ProductoRequisicion proreq : productoRequisicion) {
            if (proreq.getIdRequisicionDeArticuloEnLong() == id)
                productoRequisicionService.delete(proreq.getIdProductoRequisicion());
        }

        requisicionDeArticuloService.delete(id);
        return "redirect:/jefe/requisicion";
    }

    //Metodo que guarda la requisicion editada
    @RequestMapping(value = "/requisicion/editar/", method = RequestMethod.POST)
    public String editarRequisicion(
            @RequestParam(name = "cantidad") ArrayList<Integer> cantidad,
            @RequestParam(name = "articulo") ArrayList<Long> articulo,
            @RequestParam(name = "isss") Long id) {
        System.out.println("Id de la requisicio: " + id);
        System.out.println("Buscando por id-------- ");
        //Buscando los productos de la requisicion que corresponden al id de la requisicion
        List<ProductoRequisicion> listaProductoRequisicion = productoRequisicionService.listadoPorId(id);
        List<ProductoRequisicion> auxiliarListaProductoRequisicion = listaProductoRequisicion;
        System.out.println("Eliminando articulo ----------");
        for(int i = 0; i < listaProductoRequisicion.size(); i++){
            System.out.println(listaProductoRequisicion.get(i).toString());
            productoRequisicionService.delete(listaProductoRequisicion.get(i).getIdProductoRequisicion());
        }
        RequisicionDeArticulo requisicionDeArticulo = requisicionDeArticuloService.get(id);
        //Ciclo que recorre la cantidad de datos solicitados para la requisicion
        for(int i = 0; i < cantidad.size(); i++){ //Inicio ciclo for
//            if(listaProductoRequisicion.get(i).getIdProductoProveedor().toString() == productoService.get(articulo.get(i)).getIdProductoProveedor().toString()){
//                listaProductoRequisicion.get(i).setCantidad(cantidad.get(i));
//            }
            //Creando una instancia de producto requisicion
            ProductoRequisicion productoRequisicion = new ProductoRequisicion();
            ProductoProveedor productoProveedor = productoService.get(articulo.get(i));
            //Agrengando la cantidad pedida del articulo
            productoRequisicion.setCantidad(cantidad.get(i));
            //Agregando el producto solicitado
            productoRequisicion.setIdProductoProveedor(productoProveedor);
            //Guardando los productos de la requisicion
            //Agregando la requisicion
            productoRequisicion.setIdRequisicionDeArticulo(requisicionDeArticulo);
            productoRequisicionService.save(productoRequisicion);
        } //Fin ciclo for
        return "redirect:/jefe/requisicion";
    }
}
