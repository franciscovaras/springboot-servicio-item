package com.fvarasg.inicio.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.fvarasg.inicio.clientes.ProductoClienteRest;
import com.fvarasg.inicio.models.Item;

@Service("serviceFeing")
@Primary
public class ItemServiceFeign implements ItemService {
	
	@Autowired
	private ProductoClienteRest productoCliente;
	
	@Override
	public List<Item> findAll() {
		return productoCliente.buscarTodosLosProductos().stream()
														.map(p -> new Item(p, 1))
														.collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(productoCliente.buscarProducto(id),cantidad);
	}

}
