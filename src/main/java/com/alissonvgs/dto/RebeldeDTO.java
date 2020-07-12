package com.alissonvgs.dto;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RebeldeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Size(min = 2, max = 120, message = "O tamanho deve ser entre 2 e 120 caracteres")
	private String nome;
	private Integer idade;
	private String genero;
	@NotEmpty(message = "Preenchimento obrigatório")
	private LocalizacaoDTO localizacao;
	private InventarioDTO inventario;
	
	public RebeldeDTO() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalizacaoDTO getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(LocalizacaoDTO localizacao) {
		this.localizacao = localizacao;
	}

	public InventarioDTO getInventario() {
		return inventario;
	}

	public void setInventario(InventarioDTO inventario) {
		this.inventario = inventario;
	}
	
	

}
