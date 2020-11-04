package com.sistemacompras.too.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import com.sistemacompras.too.entity.ProductoProveedor;
import com.sistemacompras.too.service.ProductoProveedorService;
import com.sistemacompras.too.entity.Proveedor;
import com.sistemacompras.too.service.ProveedorService;


@Controller
@RequestMapping("/proveedor")
public class ProductoProveedorController {

	//Controlador de Producto de proveedor
    @Autowired
    private ProductoProveedorService service;
    @Autowired
    private ProveedorService ProveedorService;

    @RequestMapping("/ProductoProveedor")
    public String viewHomePage(Model model){
        //Obtenemos todos los objetos de tipo Producto proveedor
        List<ProductoProveedor> listProductoProveedor = service.listAll();
        model.addAttribute("listProductoProveedor", listProductoProveedor);
        return "ProductoProveedor/index"; //Nombre del html
    }
    
    //Ruta para un nuevo producto proveedor
    @RequestMapping("/ProductoProveedor/new")
    public String showNewProductForm(Model model){
        //Creando una instancia de Producto proveedor
    	ProductoProveedor productoProveedor = new ProductoProveedor();
        model.addAttribute("productoProveedor", productoProveedor);
        return "ProductoProveedor/new";
    }
    
    //Ruta para crear un nuevo producto
    @RequestMapping(value = "/ProductoProveedor/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("productoProveedor") ProductoProveedor productoProveedor){
        service.save(productoProveedor);
        return "redirect:/ProductoProveedor";
    }
    
    //Editar un producto de proveedor
    @RequestMapping("/ProductoProveedor/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("ProductoProveedor/edit");
        ProductoProveedor productoProveedor = service.get(id);
        mav.addObject("productoProveedor", productoProveedor);
        return mav;
    }
    
    //View un producto de proveedor
    @RequestMapping("/ProductoProveedor/view/{id}")
    public ModelAndView showProductPage(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("ProductoProveedor/view");
        ProductoProveedor productoProveedor = service.get(id);
        mav.addObject("productoProveedor", productoProveedor);
        return mav;
    }
    
    
    //Eliminar un producto de proveedor
    @RequestMapping("/ProductoProveedor/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/ProductoProveedor";
    }
}
