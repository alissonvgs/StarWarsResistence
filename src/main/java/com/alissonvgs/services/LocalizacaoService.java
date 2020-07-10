package com.alissonvgs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alissonvgs.domain.Localizacao;
import com.alissonvgs.repositories.LocalizacaoRepository;

@Service
public class LocalizacaoService {

	@Autowired
	private LocalizacaoRepository repository;

	public List<Localizacao> findAll() {
		return this.repository.findAll();
	}

	public Localizacao findById(Integer id) {
		return this.repository.findById(id).get();
	}

	public Localizacao insert(Localizacao obj) {
		return this.repository.save(obj);
	}
	
	public void delete(Localizacao obj) {
		this.repository.delete(obj);
	}
	
	public Localizacao update(Localizacao obj) {
		Localizacao newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Localizacao newObj, Localizacao obj) {
		newObj.setNome(obj.getNome());
		newObj.setLatitude(obj.getLatitude());
		newObj.setLongitude(obj.getLongitude());
	}
}
