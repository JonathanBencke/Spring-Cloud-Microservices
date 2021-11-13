package com.jbsoft.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jbsoft.store.client.SupplierClient;
import com.jbsoft.store.controller.dto.InfoSupplierDTO;
import com.jbsoft.store.controller.dto.PurchaseDTO;

@Service
public class PurchaseService {

	@Autowired
	private SupplierClient supplierClient;

	public void makePurchase(PurchaseDTO purchase) {
		InfoSupplierDTO info = supplierClient.getInfoByDistrict(purchase.getAddress().getDistrict());
		System.out.println(info.getAddress());
	}

}
