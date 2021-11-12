package com.jbsoft.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jbsoft.store.controller.dto.InfoSupplierDTO;
import com.jbsoft.store.controller.dto.PurchaseDTO;

@Service
public class PurchaseService {

	@Autowired
	private RestTemplate client;
	
	public void makePurchase(PurchaseDTO purchase) {
		ResponseEntity<InfoSupplierDTO> exchange = client.exchange(
				"http://supplier/info/" + purchase.getAddress().getDistrict(), HttpMethod.GET, null,
				InfoSupplierDTO.class);
		System.out.println(exchange.getBody().getAddress());
	}

}
