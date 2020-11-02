package com.sistemacompras.too.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistemacompras.too.entity.ProductoProveedor;
import com.sistemacompras.too.service.ProductoProveedorService;


@Controller
@RequestMapping("/jefe")
public class RequisicionController {
	
	@Autowired
    private ProductoProveedorService productoService;

    @GetMapping("/requisicion/crear")
    public String menuAdmin(Model model) {
    	List<ProductoProveedor> listProductos = productoService.listAll();
    	model.addAttribute("listProductos", listProductos);
        return "RequisicionJefeDepartamento/crearRequisicion";
    }
}
