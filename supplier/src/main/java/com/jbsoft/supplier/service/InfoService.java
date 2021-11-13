package com.jbsoft.supplier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbsoft.supplier.model.InfoSupplier;
import com.jbsoft.supplier.repository.InfoRepository;

@Service
public class InfoService {

	@Autowired
	private InfoRepository infoRepository;

	public InfoSupplier getInfoByDistrict(String district) {
		return infoRepository.findByDistrict(district);
	}

}
