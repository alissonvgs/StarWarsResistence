package com.alissonvgs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alissonvgs.domain.Inventario;
import com.alissonvgs.repositories.InventarioRepository;

@Service
public class InventarioService {

	@Autowired
	private InventarioRepository repository;

	public List<Inventario> findAll() {
		return this.repository.findAll();
	}

	public Inventario findById(Integer id) {
		return this.repository.findById(id).get();
	}

	public Inventario insert(Inventario obj) {
		return this.repository.save(obj);
	}

	public void delete(Inventario obj) {
		this.repository.delete(obj);
	}

	public Inventario update(Inventario obj) {
		Inventario newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Inventario newObj, Inventario obj) {
		newObj.setItem(obj.getItem());
		newObj.setPontos(obj.getPontos());
	}

}
