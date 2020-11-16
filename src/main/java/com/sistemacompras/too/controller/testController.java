package com.sistemacompras.too.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jefe")
public class testController {

    //Index
    @RequestMapping("/requisicionPrueba")
    public String HomePage(Model model){
        return "OrdenesDeCompra/index"; //Nombre del html
    }


}
