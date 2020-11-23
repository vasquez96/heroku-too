package com.sistemacompras.too.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class testController {

    //Index
    @RequestMapping("/requisicionPrueba")
    public String HomePage(Model model){
        return "OrdenesDeCompra/index"; //Nombre del html
    }


   @GetMapping("/requisicionAdmin")
    public String dashboardAdmin() { return "RequisicionAdminDepartamento/adminRequisicion.html"; }

    @GetMapping("/aceptarDenegarAdmin")//http://127.0.0.1:8080/admin/aceptarDenegarAdmin
    public String dashboardAdminAceptarDenegar() {
        return "RequisicionAdminDepartamento/adminAceptarDenegar.html";
    }

}




