package com.tienda.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.tienda.modelo.ProductosModelo;

@Service
public interface ProductosService {
	
	 List<ProductosModelo> obtenerTodos();
	 
	 ProductosModelo obtenerPorId(Integer id);
	 
	 void guardarProducto(ProductosModelo productosModelo);

}
