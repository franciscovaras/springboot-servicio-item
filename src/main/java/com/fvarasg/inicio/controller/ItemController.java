package com.fvarasg.inicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fvarasg.inicio.models.Item;
import com.fvarasg.inicio.models.service.ItemService;

@RestController
public class ItemController {
	@Autowired
	@Qualifier("serviceFeing")
	private ItemService itemService;

	@GetMapping("/listar")
	public List<Item> listar() {
		return itemService.findAll();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad ) {
		return itemService.findById(id, cantidad);
	}
}
