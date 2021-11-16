package com.jbsoft.store.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jbsoft.store.client.SupplierClient;
import com.jbsoft.store.dto.InfoOrderDTO;
import com.jbsoft.store.dto.InfoSupplierDTO;
import com.jbsoft.store.dto.PurchaseDTO;
import com.jbsoft.store.model.Purchase;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class PurchaseService {

	private static final Logger LOG = LoggerFactory.getLogger(PurchaseService.class);

	@Autowired
	private SupplierClient supplierClient;

	@HystrixCommand(fallbackMethod = "makePurchaseFallback")
	public Purchase makePurchase(PurchaseDTO purchase) {
		String district = purchase.getAddress().getDistrict();

		LOG.info("Get supplier info by district {}", district);
		InfoSupplierDTO info = supplierClient.getInfoByDistrict(district);

		LOG.info("Making order.");
		InfoOrderDTO order = supplierClient.makeOrder(purchase.getItens());
		System.out.println(info.getAddress());

		Purchase purchaseDb = new Purchase();
		purchaseDb.setPurchaseId(order.getId());
		purchaseDb.setPrepareTime(order.getPrepareTime());
		purchaseDb.setDestinationAddress(purchase.getAddress().toString());
		return purchaseDb;
	}

	public Purchase makePurchaseFallback(PurchaseDTO purchase) {
		Purchase purchaseFallback = new Purchase();
		return purchaseFallback;
	}

}
