package com.alissonvgs.dto;

import java.io.Serializable;

public class InventarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String item;
	private Integer pontos;

	public InventarioDTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

}
