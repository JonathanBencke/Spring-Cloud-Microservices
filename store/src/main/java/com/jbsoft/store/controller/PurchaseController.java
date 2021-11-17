package com.jbsoft.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbsoft.store.dto.PurchaseDTO;
import com.jbsoft.store.model.Purchase;
import com.jbsoft.store.service.PurchaseService;

@RestController
@RequestMapping("/buy")
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;

	@RequestMapping(method = RequestMethod.POST)
	public Purchase purchase(@RequestBody PurchaseDTO purchase) {
		return purchaseService.makePurchase(purchase);
	}

	@GetMapping("/{id}")
	public Purchase getById(@PathVariable("id") Long id) {
		return purchaseService.getById(id);
	}

}
