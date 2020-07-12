package com.alissonvgs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alissonvgs.domain.TraidorReport;
import com.alissonvgs.repositories.TraidorReportRepository;

@Service
public class TraidorReportService {

	@Autowired
	private TraidorReportRepository repository;

	public List<TraidorReport> findAll() {
		return repository.findAll();
	}

	public TraidorReport findById(Integer id) {
		return this.repository.findById(id).get();
	}

	public TraidorReport insert(TraidorReport obj) {
		return this.repository.save(obj);

	}

	public void delete(TraidorReport obj) {
		this.repository.delete(obj);
	}

	public TraidorReport update(TraidorReport obj) {
		TraidorReport newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(TraidorReport newObj, TraidorReport obj) {
		newObj.setTraidor(obj.getTraidor());
	}

	public Boolean countTraidor(TraidorReport obj) {
		Integer count = 0;
		for (TraidorReport i : findAll()) {
			if (i.getTraidor() == obj.getTraidor()) {
				count++;
			}
		}
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

}
