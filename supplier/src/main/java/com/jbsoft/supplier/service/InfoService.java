package com.jbsoft.supplier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbsoft.supplier.service.model.InfoSupplider;
import com.jbsoft.supplier.service.repository.InfoRepository;

@Service
public class InfoService {

	@Autowired
	private InfoRepository infoRepository;

	public InfoSupplider getInfoByDistrict(String district) {
		return infoRepository.findByDistrict(district);
	}

}
