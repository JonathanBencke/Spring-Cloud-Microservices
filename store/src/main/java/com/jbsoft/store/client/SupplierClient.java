package com.jbsoft.store.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jbsoft.store.controller.dto.InfoSupplierDTO;

@FeignClient("supplier")
public interface SupplierClient {

	@GetMapping("info/{district}")
	public InfoSupplierDTO getInfoByDistrict(@PathVariable String district);
	
}
