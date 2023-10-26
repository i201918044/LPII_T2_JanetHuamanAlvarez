package com.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tienda.modelo.ProductosModelo;
import com.tienda.repositorio.IProductosRepository;

@Service
public class ProductoImp implements ProductosService{

	
	@Autowired IProductosRepository _repositorio;
	
	@Override
	@Transactional(readOnly = true)
	public List<ProductosModelo> obtenerTodos() {
		
		List<ProductosModelo> productos = _repositorio.findAll();
		
		return productos;
	}

	@Override
	@Transactional(readOnly = true)
	public ProductosModelo obtenerPorId(Integer id) {
		
		ProductosModelo productoPorId = _repositorio.findById(id).orElse(null);
		
		return productoPorId;
	}

	@Override
	@Transactional(readOnly = false)
	public void guardarProducto(ProductosModelo productosModelo) {
		_repositorio.save(productosModelo);
		
	}

}
