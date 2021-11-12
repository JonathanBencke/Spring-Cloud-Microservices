package com.jbsoft.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbsoft.store.controller.dto.PurchaseDTO;
import com.jbsoft.store.service.PurchaseService;

@RestController
@RequestMapping("/buy")
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void purchase(@RequestBody PurchaseDTO purchase) {
		purchaseService.makePurchase(purchase);
	}
	
}
