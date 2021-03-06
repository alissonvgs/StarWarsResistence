package com.alissonvgs.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alissonvgs.domain.Rebelde;
import com.alissonvgs.dto.RebeldeDTO;
import com.alissonvgs.services.RebeldeService;

@RestController
@RequestMapping(value = "rebeldes")
public class RebeldeResource {

	@Autowired
	private RebeldeService service;

	@GetMapping
	public ResponseEntity<List<Rebelde>> listaRebelde() {
		return ResponseEntity.ok().body(this.service.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Rebelde> findById(@PathVariable Integer id) {
		Rebelde obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody Rebelde objDto) {
		//Rebelde obj = service.fromDTO(objDto);
		Rebelde obj = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<RebeldeDTO> update(@Valid @RequestBody RebeldeDTO objDto, @PathVariable Integer id) {
		Rebelde obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
