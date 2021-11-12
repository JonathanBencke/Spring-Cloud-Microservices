package com.jbsoft.store.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jbsoft.store.controller.dto.InfoSupplierDTO;
import com.jbsoft.store.controller.dto.PurchaseDTO;

@Service
public class PurchaseService {

	public void makePurchase(PurchaseDTO purchase) {
		RestTemplate client = new RestTemplate();
		ResponseEntity<InfoSupplierDTO> exchange = client.exchange(
				"http://localhost:8081/info/" + purchase.getAddress().getDistrict(), HttpMethod.GET, null,
				InfoSupplierDTO.class);
		System.out.println(exchange.getBody().getAddress());
	}

}
