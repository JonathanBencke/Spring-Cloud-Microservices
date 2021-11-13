package com.jbsoft.supplier.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbsoft.supplier.model.InfoSupplier;
import com.jbsoft.supplier.service.InfoService;

@RestController
@RequestMapping("/info")
public class InfoController {

	private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);
	
	@Autowired
	private InfoService infoService;
	
	@GetMapping("/{district}")
	public InfoSupplier getInfoByDistrict(@PathVariable String district) {
		LOG.info("Received request for supplier info.");
		return infoService.getInfoByDistrict(district);
	}
	
}
