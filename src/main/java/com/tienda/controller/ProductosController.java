package com.tienda.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tienda.modelo.ProductosModelo;
import com.tienda.service.ProductosService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProductosController {
	
	@Autowired
	private ProductosService productosService;
		
	@GetMapping("/productos")
    public String mostrarCatalogo(Model model) {
        model.addAttribute("productos", productosService.obtenerTodos());
    	model.addAttribute("mensaje","Hola mundo");
        return "listaproductos";
    }

	
}
