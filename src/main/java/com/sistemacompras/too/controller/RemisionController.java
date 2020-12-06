package com.sistemacompras.too.controller;

import com.sistemacompras.too.entity.*;
import com.sistemacompras.too.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/bodega")
public class RemisionController {
    @Autowired
    private DetalleOrdenDeCompraService detalleOrdenDeCompraService;
    @Autowired
    private OrdenDeCompraService ordenDeCompraService;
    @Autowired
    private ProductoEmpresaService service;
    @Autowired
    private NotaDeRemisionService notaDeRemisionService;

    //Metodo que lista las notas de remision
    @RequestMapping("/remisiones")
    public ModelAndView listarNotasRemision(){
        //Obteniendo todas las notas de remision
        List<NotasDeRemision> notasDeRemisions = notaDeRemisionService.listAll();
        ModelAndView mav = new ModelAndView("InventarioArticulos/listarNotasRemision");
        //Manda los objetos a la vista
        mav.addObject("notasDeRemisions", notasDeRemisions);
        return mav;
    }

    //Ver la orden de compra
    @RequestMapping("/remisiones/view/{id}")
    public ModelAndView showProductPage(@PathVariable(name = "id") Long id) {
        /**
         Aqui tengo que recibir el id de la orden de remision, y atraves del id de la orden
         de remision encontrar el id de la orden de compra y enviar a la vista la orden de
         compra :v
         */
        ModelAndView mav = new ModelAndView("InventarioArticulos/recibirArticulo.html");
        List<DetalleOrdenDeCompra> detalleOrdenDeCompra = detalleOrdenDeCompraService.listAllbyIdOrderCompra(id);
        for (DetalleOrdenDeCompra detalleOrdenDeCompra1 : detalleOrdenDeCompra)
        {
            System.out.println(detalleOrdenDeCompra1.toString());
        }
        mav.addObject("detalleOrdenDeCompra", detalleOrdenDeCompra);
        return mav;
    }

    //Cuando se acepta la orden de remision recibiendo el ide de la orden de compra
    @RequestMapping("/recib/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id){
        //Tenemos los detalleordenDeCompra que coincidan con el ir de la orden de empresa que recibimos
        List<DetalleOrdenDeCompra> detalleOrdenDeCompra = detalleOrdenDeCompraService.listAllbyIdOrderCompra(id);
       //Se listan TODOS los productos de la empresa.
        List<ProductoEmpresa> listProductoEmpresaAll = service.listAll();
        //Se crea una lista de productos de la empresa que luego seran guardados.
        ProductoEmpresa productosAGuardar = new ProductoEmpresa();


        String nombreProductoEntrante;
        String nombreProductoDeLaEmpresa;
        int i;

        for (DetalleOrdenDeCompra productoEntrante : detalleOrdenDeCompra) {
            //Aqui se le asigna a la variable nombreProductoEntrante el valor actual del objeto que se reccorre
            nombreProductoEntrante = productoEntrante.getIdProductoProveedor().getNombreProductoProveedor().toLowerCase();
            i = 0;

            for (ProductoEmpresa productoBD : listProductoEmpresaAll) {
                //Aqui se le asigna a la variable nombreProductoDeLaEmpresa el valor actual del objeto que se reccorre
                nombreProductoDeLaEmpresa = productoBD.getNombre().toLowerCase();
                /**
                 Aqui comparamos el producto que intenta ingresar a la empresa con todos los que ya
                 existen y estan en bd, si coincide con alguno es porquqe ya existe, e i suma una unidad
                 en tal caso ese producto ya existe y no se debe guardar en bd
                 */
                    if(nombreProductoEntrante.equals(nombreProductoDeLaEmpresa))
                    {
                        i++;
                    }
            }
            //Si i vale 0 es porque ningun otro producto tiene ese nombre entonces se guarda
            if (i == 0)
            {
                //Esta cantidad se debe cambiar por la nueva
                productosAGuardar.setCantidad(productoEntrante.getCantidad());
                productosAGuardar.setMax(200);
                productosAGuardar.setMin(150);
                productosAGuardar.setNombre(productoEntrante.getIdProductoProveedor().getNombreProductoProveedor());
                service.save(productosAGuardar);
                System.out.println("Guardo un producto de la empresa nuevo:");
            }
        }
            System.out.println("el id es: " + id);
        return "redirect:/bodega/remisiones";
    }
}
