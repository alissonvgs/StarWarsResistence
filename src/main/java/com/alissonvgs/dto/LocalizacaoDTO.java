package com.alissonvgs.dto;

import java.io.Serializable;

public class LocalizacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer latitude;
	private Integer longitude;
	private String nome;

	public LocalizacaoDTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLatitude() {
		return latitude;
	}

	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}

	public Integer getLongitude() {
		return longitude;
	}

	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
