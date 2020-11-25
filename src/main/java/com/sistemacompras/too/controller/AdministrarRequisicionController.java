package com.sistemacompras.too.controller;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import com.sistemacompras.too.entity.*;
import com.sistemacompras.too.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/admin")
public class AdministrarRequisicionController {

    @Autowired
    private ProductoProveedorService productoService;
    @Autowired
    private RequisicionDeArticuloService requisicionDeArticuloService;
    @Autowired
    private ProductoRequisicionService productoRequisicionService;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductoEmpresaService productoEmpresaServiceService;

    //Listar las requisiciones.
    @RequestMapping("/requisicionAdmin")
    public String viewHomePage(Model model, HttpServletRequest request){

        List<RequisicionDeArticulo> listRequisicionDeArticulo = requisicionDeArticuloService.listSelected(0);
        model.addAttribute("listRequisicionDeArticulo", listRequisicionDeArticulo);
        return "RequisicionAdminDepartamento/adminRequisicion.html"; //Nombre del html
    }

    //View un producto de proveedor
    @RequestMapping("/requisicionAdmin/aceptarDenegarAdmin/{id}")
    public ModelAndView showProductPage(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("RequisicionAdminDepartamento/adminAceptarDenegar");
        List<ProductoRequisicion> productoRequisicion = productoRequisicionService.listadoPorId(id);
        List<ProductoEmpresa> productoEmpresa = productoEmpresaServiceService.listAll();

        mav.addObject("productoEmpresa", productoEmpresa);
        mav.addObject("productoRequisicion", productoRequisicion);
        return mav;
    }


}
