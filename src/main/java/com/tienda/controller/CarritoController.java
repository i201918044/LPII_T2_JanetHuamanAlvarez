package com.tienda.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.tienda.modelo.ProductosModelo;
import com.tienda.service.ProductosService;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class CarritoController {
	
@Autowired private ProductosService productoService;

private List<ProductosModelo> carrito = new ArrayList<>();


@PostMapping("/agregar")
public String addToChart(@RequestParam("productoId") Integer productoId) {
	ProductosModelo producto = productoService.obtenerPorId(productoId);
	carrito.add(producto);

	return "redirect:/productos";
}

@GetMapping("/carrito")
public String mostrarCarrito(Model model) {

	model.addAttribute("productosEnCarrito", carrito);

	double total = carrito.stream().mapToDouble(ProductosModelo::getPrecio).sum();
	model.addAttribute("total", total);

	return "tiendacarrito";
}


@GetMapping(value = "/comprar")
public String quitarDelCarrito(Model model,  RedirectAttributes redirectAttrs) {
	
	if(carrito==null || carrito.size()==0) {
		redirectAttrs.addFlashAttribute("mensaje", "No hay productos en el carrito");

	    return "redirect:/carrito";
	}
	carrito = new ArrayList<>();
	
	redirectAttrs.addFlashAttribute("mensaje", "Se realizo la Compra Satisfactoriamente");
	
    return "redirect:/carrito";
}


@GetMapping(value = "/cancelar")
public String cancelarVenta(Model model,  RedirectAttributes redirectAttrs)
{
	if(carrito==null || carrito.size()==0) {
		redirectAttrs.addFlashAttribute("mensaje", "No hay productos en el carrito");
		return "redirect:/carrito";
	}
	
	carrito = new ArrayList<>();
	redirectAttrs.addFlashAttribute("mensaje", "Se cancelo la compra");
	return "redirect:/carrito";

}






}
