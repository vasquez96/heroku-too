package com.sistemacompras.too.controller;

import com.sistemacompras.too.entity.ProductoProveedor;
import com.sistemacompras.too.entity.ProductoRequisicion;
import com.sistemacompras.too.entity.RequisicionDeArticulo;
import com.sistemacompras.too.service.ProductoProveedorService;
import com.sistemacompras.too.service.ProductoRequisicionService;
import com.sistemacompras.too.service.RequisicionDeArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/empleado")
public class EscenarioCompraController {

    //Inyección de dependencias
    @Autowired
    private RequisicionDeArticuloService requisicionDeArticuloService;
    @Autowired
    private ProductoRequisicionService productoRequisicionService;
    @Autowired
    private ProductoProveedorService productoProveedorService;

    //Método que muestra la requisicion aprobada para iniciar un escenario de compra
    @RequestMapping("/requisicion/view/{id}")
    public ModelAndView showRequisicionAprobada(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("EmpleadoDepartamentoCompras/view");
        //Obtiene la requisicion de articulo por medio del id
        RequisicionDeArticulo requisicionDeArticulo = requisicionDeArticuloService.get(id);
        //Obtiene la lista de los productos de la requisicion por medio del id de la requisicion
        List<ProductoRequisicion> productoRequisicion = productoRequisicionService.listadoPorId(id);
        //Manda los objetos a la vista
        mav.addObject("productoRequisicion", productoRequisicion);
        mav.addObject("requisicionArticulo", requisicionDeArticulo);
        return mav;
    }//Fin del metodo showRequisicionAprobada

    //Método que muestra el escenario de compra
    @RequestMapping("/escenario/{id}")
    public ModelAndView showEscenarioCompra(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("EmpleadoDepartamentoCompras/escenarioDeCompra");
        //Obtiene la requisicion de articulo por medio del id
        RequisicionDeArticulo requisicionDeArticulo = requisicionDeArticuloService.get(id);
        //Obtiene la lista de los productos de la requisicion por medio del id de la requisicion
        List<ProductoRequisicion> productoRequisicion = productoRequisicionService.listadoPorId(id);
        //Obtiene la lista de los productos de los diferentes proveedores
        List<ProductoProveedor> listProductoProveedor = productoProveedorService.listAll();
        //Manda los objetos a la vista
        mav.addObject("productoRequisicion", productoRequisicion);
        mav.addObject("requisicionArticulo", requisicionDeArticulo);
        mav.addObject("listProductoProveedor", listProductoProveedor);
        return mav;
    }//Fin del metodo showEscenarioCompra

    //Método que genera la orden de compra
    @RequestMapping(value = "/ordenCompra/save", method = RequestMethod.POST)
    public String guardarRequisicion(@RequestParam(name = "idProductoProveedor") ArrayList<Long> idProductoProveedor) {
        System.out.println("\n**************CANTIDAD DE DATOS: " + idProductoProveedor.size());
        ProductoProveedor productoProveedor;
        for(int i = 0; i < idProductoProveedor.size(); i++){
            System.out.println("*****Producto " + i + ": ");
            System.out.println(productoProveedorService.get(idProductoProveedor.get(i)));
        }

//        if (bindingResult.hasErrors()) {
//            return "RequisicionJefeDepartamento/crearRequisicion";
//        } else {
        //Creando una instancia de fecha para capturar la fecha del hoy
        ////Date fecha = new Date();
        //Creando una requisicion de articulo
        ////RequisicionDeArticulo requisicionDeArticulo = new RequisicionDeArticulo();
        //Modificando la fecha de la elaboracion de la requisicion
        ////requisicionDeArticulo.setFechaPedido(fecha);
        ///requisicionDeArticuloService.save(requisicionDeArticulo);
        //System.out.println("Datos de cantidad: " + cantidad.size());
        //System.out.println("Datos de articulo: " + articulo.size());
        //Ciclo que recorre la cantidad de datos solicitdados para la requisicion
        ////for (int i = 0; i < cantidad.size(); i++) { //Inicio ciclo for
            //System.out.println("Valor de la cantidad del articulo: " + cantidad.get(i));
            //System.out.println("Nombre de articulo: " + productoService.get(articulo.get(i)));
            //Creando una instancia de producto requisicion
            ////ProductoRequisicion productoRequisicion = new ProductoRequisicion();
            ////ProductoProveedor productoProveedor = productoService.get(articulo.get(i));
            //System.out.println("Nombre de articulo: " + productoProveedor.getNombreProductoProveedor());
            //Agrengando la cantidad pedida del articulo
            ////productoRequisicion.setCantidad(cantidad.get(i));
            //Agregando el producto solicitado
            ////productoRequisicion.setIdProductoProveedor(productoProveedor);
            //Agregando la requisicion
            ////productoRequisicion.setIdRequisicionDeArticulo(requisicionDeArticulo);
            //System.out.println("DATOS DE PRODUCTO REQUISICION: " + productoRequisicion.toString());
            //Guardando los productos de la requisicion
            ////productoRequisicionService.save(productoRequisicion);
        ////} //Fin ciclo for
        return "redirect:/empleado";
    }
}
