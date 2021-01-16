package com.fvarasg.inicio.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fvarasg.inicio.models.Item;
import com.fvarasg.inicio.models.Producto;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	RestTemplate clienteRest;
	
	@Override
	public List<Item> findAll() {
		List<Producto> producto = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));
		return producto.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathVariable = new HashMap<String, String>();
		pathVariable.put("id", id.toString());
		Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariable);
		return new Item(producto, cantidad);
	}

}
