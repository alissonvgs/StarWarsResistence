package com.alissonvgs.dto;

import java.io.Serializable;

import com.alissonvgs.domain.Rebelde;

public class TraidorReportDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Rebelde traidor;

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

}