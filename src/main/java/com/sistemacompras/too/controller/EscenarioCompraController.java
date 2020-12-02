package com.sistemacompras.too.controller;

import com.sistemacompras.too.entity.*;
import com.sistemacompras.too.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

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
    @Autowired
    private OrdenDeCompraService ordenDeCompraService;
    @Autowired
    private ProveedorService proveedorService;
    @Autowired
    private DetalleOrdenDeCompraService detalleOrdenDeCompraService;

    //Método que muestra la requisicion aprobada para iniciar un escenario de compra
    @RequestMapping("/requisicion/view/{id}")
    public ModelAndView showRequisicionAprobada(@PathVariable(name = "id") Long id) {
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
    public ModelAndView showEscenarioCompra(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("EmpleadoDepartamentoCompras/escenarioDeCompra");
        //Obtiene la requisicion de articulo por medio del id
        RequisicionDeArticulo requisicionDeArticulo = requisicionDeArticuloService.get(id);
        //Obtiene la lista de los productos de la requisicion por medio del id de la requisicion
        List<ProductoRequisicion> productoRequisicion = productoRequisicionService.listadoPorId(id);
        //Obtiene la lista de los productos de los diferentes proveedores
        List<ProductoProveedor> listProductoProveedor = productoProveedorService.listAll();
        //Calculamos el precio con descuento de los productos y se lo mandamos a la vista
        Map<Long, Double> precioConDescuento = calcularPrecioConDescuento(listProductoProveedor);
        //Manda los objetos a la vista
        mav.addObject("productoRequisicion", productoRequisicion);
        mav.addObject("requisicionArticulo", requisicionDeArticulo);
        mav.addObject("listProductoProveedor", listProductoProveedor);
        mav.addObject("precioConDescuento", precioConDescuento);
        return mav;
    }//Fin del metodo showEscenarioCompra

    //Método que genera la orden de compra
    @RequestMapping(value = "/ordenCompra/save", method = RequestMethod.POST)
    public String guardarRequisicion(@RequestParam(name = "idProductoProveedor") ArrayList<Long> idProductoProveedor) {
        System.out.println("\n**************CANTIDAD DE DATOS: " + idProductoProveedor.size());
        //Lista que almacena los id de los proveedores
        ArrayList<Long> idProveedores = new ArrayList<>();
        //Lista que almacena los productos de los proveedores
        ArrayList<ProductoProveedor> productosProveedores = new ArrayList<>();
        //Creando una instancia de tipo ProductoProveedor
        ProductoProveedor productoProveedor;
        for (int i = 0; i < idProductoProveedor.size(); i++) {
            System.out.println("*****Producto " + i + ": ");
            //System.out.println(productoProveedorService.get(idProductoProveedor.get(i)));
            //Agregando los productos a la lista productosProveedores por medio del id
            productosProveedores.add(productoProveedorService.get(idProductoProveedor.get(i)));
            System.out.println("***Producto: " + productosProveedores.get(i));
            //Agrengando el id del proveedor al ArrayList de idProveedores
            idProveedores.add(Long.parseLong(productosProveedores.get(i).getIdProveedor().getIdProveedor().toString()));
            System.out.println("***Id proveedor :" + idProveedores.get(i));
        }

        //Pasamos la lista a un stream ya que nos ofrece el metodo distinct el cual elimina los duplicados y retorna un stream
        //Luego agrupamos el stream y lo volcamos en una lista nuevamente.
        idProveedores = (ArrayList<Long>) idProveedores.stream().distinct().collect(Collectors.toList());
        //Imprimimos la lista utilizando la referencia al metodo println
        idProveedores.forEach(System.out::println);
        
        //Lista que almacena los productos de los proveedores y que servirá para representar el valor en el map
        ArrayList<ProductoProveedor> productosPorPreveedor;
        //Estructura de datos que almacena el id del proveedor junto con sus productos (clave/valor)
        Map<Long, ArrayList<ProductoProveedor>> ordenDeCompra = new HashMap<>();

        //Vamos a separar todos los productos y los vamos a asignar junto al proveedor que corresponde cada producto
        for (Long idProveedor: idProveedores) { //Inicio del foreach
            productosPorPreveedor = new ArrayList<>(); //Limpia la lista de productosPorProveedor
            for (int j = 0; j < productosProveedores.size(); j++) {
                //Verifica si el id del proveedor corresponde al id del proveedor que se encuentra dentro del producto
                if (idProveedor == Long.parseLong(productosProveedores.get(j).getIdProveedor().getIdProveedor().toString())){
                    productosPorPreveedor.add(productosProveedores.get(j)); //Agrega el producto a la listaproductosPorProveedor
                    //System.out.println("***Hello!");
                }
            }
            ordenDeCompra.put(idProveedor, productosPorPreveedor); //Agregando el proveedor y sus productos (clave/valor)
            //for(Map.Entry<Long, ArrayList<ProductoProveedor> >ordenCompra : ordenDeCompra.entrySet()){
                //System.out.println(ordenCompra.getKey() + " : " + ordenCompra.getValue());
            //}
        } //Fin del ciclor foreach

        //Imprimiendo ordenDeCompra
        for(Map.Entry<Long, ArrayList<ProductoProveedor> >ordenCompra : ordenDeCompra.entrySet()){
            System.out.println(ordenCompra.getKey() + " : " + ordenCompra.getValue());
        }

        /*
        * Proceso de creación de una orden de compra
        * */
        for(Map.Entry<Long, ArrayList<ProductoProveedor> >ordenCompra : ordenDeCompra.entrySet()){
            System.out.println(ordenCompra.getKey() + " : " + ordenCompra.getValue());
            //Variable que nos permitirá crear una nueva orden de compra de acuerdo a la cantidad de proveedores
            OrdenDeCompra ordenDe_Compra = new OrdenDeCompra();
            //Creando un objeto de tipo Date para almacenar la fecha en que se realizó la orden de compra
            Date fechaPedido = new Date();
            //Agregando la fecha a la orden de compra
            ordenDe_Compra.setFechaPedido(fechaPedido);
            //Obtenemos el proveedor por medio de su id y lo asignamos a la orden de compra
            ordenDe_Compra.setIdProveedor(proveedorService.get(ordenCompra.getKey()));
            //Caluclar el total de la compra
            Map<Long, Double> precioFinalDeLosArticulos = calcularPrecioConDescuento(ordenCompra.getValue());
            double totalCompra = 0;
            for (Map.Entry<Long, Double> precio: precioFinalDeLosArticulos.entrySet()) {
                totalCompra = totalCompra + precio.getValue();
            }
            //Poniendo el total de la compra en la orden de compra
            ordenDe_Compra.setTotalCompra((float) totalCompra);
            //Guardamos la orden de compra
            ordenDeCompraService.save(ordenDe_Compra);
            /*
            *Una vez guardada la orden de compra procedemos a crear el detalle de la orden de compra
            */

            //Ciclo que recorre la cantidad productos que tendrá cada proveedor en su orden de compra
            for (int i = 0; i < ordenCompra.getValue().size(); i++) {
                //Creamos un objeto de tipo DetalleOrdenDeCompra
                DetalleOrdenDeCompra detalleOrdenDeCompra = new DetalleOrdenDeCompra();
                //Asignamos la orden de compra que acabamos de crear a detalle orden de compra
                detalleOrdenDeCompra.setIdOrdenDeCompra(ordenDe_Compra);
                //Asignado el producto del proveedor a detalle orden de compra
                detalleOrdenDeCompra.setIdProductoProveedor(ordenCompra.getValue().get(i));
                //Guardando el detalle de la orden de compra
                detalleOrdenDeCompraService.save(detalleOrdenDeCompra);
            }//Fin del ciclo for
            //System.out.println("****ID ORDEN COMPRA: " + ordenDe_Compra.getIdOrdenDeCompra().toString());
        }//Fin de la creacion de una orden de compra

        return "redirect:/empleado";
    }

    /* Método que calcula el precio con descuento de los productos */
    //(Clave/valor) = (idProductoProveedor, precioArticulo)
    public Map<Long, Double> calcularPrecioConDescuento(List<ProductoProveedor> productoProveedor){
        //Se declara un ArrayList que almacena los precios cuando se ha aplicado el descuento
        Map<Long,Double> precioConDescuento = new HashMap<>();
        //Creando una variable que almacena la fecha actual
        Date fechaHoy = new Date();
        //Ciclo for que reccorre todos los productos del proveedor
        for (int i = 0; i < productoProveedor.size(); i++) {
            //Verifica si la fecha de hoy es mayor que la fecha de inicio de la promoción y si la fecha de hoy es menor a la fecha final de la promoción, en caso de ser verdadero aplica el descuento
            if (fechaHoy.after(productoProveedor.get(i).getFechaVigenciaInicio()) && fechaHoy.before(productoProveedor.get(i).getFechaVigenciaFinal())) {
                DecimalFormat dosDecimales = new DecimalFormat("#.##"); //Variable que redondea a dos decimales
                double precioArticulo = productoProveedor.get(i).getPrecio(); //Obteniendo el precio
                double descuento = Double.valueOf(dosDecimales.format(productoProveedor.get(i).getDescuento() / 100)); //Obteniendo el descuento
                precioArticulo = Double.valueOf(dosDecimales.format(precioArticulo - precioArticulo * descuento)); //Realizando el cálculo del precio con descuento
                precioConDescuento.put(productoProveedor.get(i).getIdProductoProveedor(), precioArticulo); //Agregando al ArrayList el precio con el descuento aplicado
            } else { //Ya pasó la promoción
                double precioArticulo = productoProveedor.get(i).getPrecio(); //Obteniendo el precio
                precioConDescuento.put(productoProveedor.get(i).getIdProductoProveedor(), precioArticulo);
            }
        }//Fin del ciclo for
        return precioConDescuento; //Retornando el ArrayList
    } /* Fin del método que calcula el precio con descuento de los productos */
}
