package com.jbsoft.supplier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbsoft.supplier.service.InfoService;
import com.jbsoft.supplier.service.model.InfoSupplider;

@RestController
@RequestMapping("/info")
public class InfoController {

	@Autowired
	private InfoService infoService;
	
	@GetMapping("/{district}")
	public InfoSupplider getInfoByDistrict(@PathVariable String district) {
		return infoService.getInfoByDistrict(district);
	}
	
}
