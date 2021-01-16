package com.fvarasg.inicio.models.service;

import java.util.List;

import com.fvarasg.inicio.models.Item;

public interface ItemService {
	List<Item> findAll();
	public Item findById(Long id, Integer cantidad);
}
