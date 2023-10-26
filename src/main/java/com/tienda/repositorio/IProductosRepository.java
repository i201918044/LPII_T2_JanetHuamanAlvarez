package com.tienda.repositorio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.tienda.modelo.ProductosModelo;
import com.tienda.service.ProductosService;

@Service
public interface IProductosRepository extends JpaRepository<ProductosModelo, Integer> {

	/*public static final ProductosService ProductosService = new ProductosService();
	
    @Autowired
	@Override
	@Transactional(readOnly = true)
	public List<ProductosModelo> listarProductos() {		
		return (List<ProductosModelo>)ProductosService.findAll();
	}*/

}
 
