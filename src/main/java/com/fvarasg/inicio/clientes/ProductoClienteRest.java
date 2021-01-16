package com.fvarasg.inicio.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fvarasg.inicio.models.Producto;

@FeignClient(name="servicio-producto")
public interface ProductoClienteRest {
	@GetMapping("/listar")
	public List<Producto> buscarTodosLosProductos();
	
	@GetMapping("/ver/{id}")
	public Producto buscarProducto(@PathVariable Long id);
}
