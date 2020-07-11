package com.alissonvgs.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alissonvgs.domain.Localizacao;
import com.alissonvgs.dto.LocalizacaoDTO;
import com.alissonvgs.services.LocalizacaoService;

@RestController
public class LocalizacaoResource {

	@Autowired
	private LocalizacaoService service;

	//Optional
	@GetMapping("/rebeldes/localizacao")
	public ResponseEntity<List<Localizacao>> findAll() {
		return ResponseEntity.ok().body(this.service.findAll());
	}

	@PutMapping("/rebeldes/localizacao/{id}")
	public ResponseEntity<LocalizacaoDTO> update(@RequestBody LocalizacaoDTO objDto, @PathVariable Integer id) {
		Localizacao obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();

	}
}
