package com.alissonvgs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.alissonvgs.domain.Localizacao;
import com.alissonvgs.domain.Rebelde;
import com.alissonvgs.dto.RebeldeDTO;
import com.alissonvgs.repositories.RebeldeRepository;

@Service
public class RebeldeService {

	@Autowired
	private RebeldeRepository repository;

	@Autowired
	private LocalizacaoService localizacaoService;

	@Autowired
	private InventarioService inventarioService;

	public List<Rebelde> findAll() {
		return repository.findAll();

	}

	public Rebelde findById(Integer id) {
		return this.repository.findById(id).get();
	}

	public Rebelde insert(Rebelde obj) {
		obj.setLocalizacao(localizacaoService.findById(obj.getLocalizacao().getId()));
		obj.setInventario(inventarioService.findById(obj.getInventario().getId()));
		obj = repository.save(obj);
		return obj;

	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel apagar o objetos. Possiveis objetos relacionados");
		}
	}
	
	public Rebelde update(Rebelde obj) {
		Rebelde newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Rebelde newObj, Rebelde obj) {
		newObj.setNome(obj.getNome());
		newObj.setIdade(obj.getIdade());
		newObj.setGenero(obj.getGenero());
		newObj.setInventario(obj.getInventario());
		newObj.setLocalizacao(obj.getLocalizacao());
		
	}
	
	public Rebelde fromDTO(RebeldeDTO objDto) {
		Localizacao loc = new Localizacao(null, objDto.getLocalizacao().getLatitude(), objDto.getLocalizacao().getLongitude(), objDto.getLocalizacao().getNome());
		Rebelde reb = new Rebelde(null, objDto.getNome(), objDto.getIdade(), objDto.getGenero(), loc);
		return reb;
	}

}
