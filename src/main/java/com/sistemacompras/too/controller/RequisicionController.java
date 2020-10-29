package com.sistemacompras.too.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jefe")
public class RequisicionController {

    @GetMapping("/requisicion/crear")
    public String menuAdmin() {
        return "RequisicionJefeDepartamento/crearRequisicion";
    }
}
