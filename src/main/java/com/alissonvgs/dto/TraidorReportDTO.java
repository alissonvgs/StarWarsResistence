package com.alissonvgs.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.alissonvgs.domain.Rebelde;

public class TraidorReportDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "Preenchimento obrigatório")
	private Rebelde traidor;
	@NotEmpty(message = "Preenchimento obrigatório")
	private Rebelde autor;

	public TraidorReportDTO() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Rebelde getTraidor() {
		return traidor;
	}

	public void setTraidor(Rebelde traidor) {
		this.traidor = traidor;
	}

	public Rebelde getAutor() {
		return autor;
	}

	public void setAutor(Rebelde autor) {
		this.autor = autor;
	}

}
