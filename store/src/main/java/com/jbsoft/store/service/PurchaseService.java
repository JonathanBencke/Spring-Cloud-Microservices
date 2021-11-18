package com.jbsoft.store.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbsoft.store.client.ShippingClient;
import com.jbsoft.store.client.SupplierClient;
import com.jbsoft.store.dto.InfoDeliveryDTO;
import com.jbsoft.store.dto.InfoOrderDTO;
import com.jbsoft.store.dto.InfoSupplierDTO;
import com.jbsoft.store.dto.PurchaseDTO;
import com.jbsoft.store.dto.VoucherDTO;
import com.jbsoft.store.model.Purchase;
import com.jbsoft.store.repository.PurchaseRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class PurchaseService {

	private static final Logger LOG = LoggerFactory.getLogger(PurchaseService.class);

	@Autowired
	private SupplierClient supplierClient;

	@Autowired
	private ShippingClient shippingClient;

	@Autowired
	private PurchaseRepository purchaseRepository;

	@HystrixCommand(fallbackMethod = "makePurchaseFallback", threadPoolKey = "makePurchaseThreadPool")
	public Purchase makePurchase(PurchaseDTO purchase) {
		String district = purchase.getAddress().getDistrict();

		LOG.info("Get supplier info by district {}", district);
		InfoSupplierDTO info = supplierClient.getInfoByDistrict(district);

		InfoOrderDTO order = supplierClient.makeOrder(purchase.getItens());
		System.out.println(info.getAddress());

		InfoDeliveryDTO deliveryDto = new InfoDeliveryDTO();
		deliveryDto.setOrderId(order.getId());
		deliveryDto.setDeliveryDate(LocalDate.now().plusDays(order.getPrepareTime()));
		deliveryDto.setOrigemAddress(info.getAddress());
		deliveryDto.setDestinyAddress(purchase.getAddress().toString());
		VoucherDTO voucher = shippingClient.reserveShipping(deliveryDto);

		Purchase purchaseDb = new Purchase();
		purchaseDb.setPurchaseId(order.getId());
		purchaseDb.setPrepareTime(order.getPrepareTime());
		purchaseDb.setDestinationAddress(purchase.getAddress().toString());
		purchaseDb.setDeliveryDate(voucher.getDeliveryDate());
		purchaseDb.setVoucher(voucher.getNumber());
		this.purchaseRepository.save(purchaseDb);
		
		return purchaseDb;
	}

	public Purchase makePurchaseFallback(PurchaseDTO purchase) {
		Purchase purchaseFallback = new Purchase();
		return purchaseFallback;
	}

	@HystrixCommand(fallbackMethod = "getByIdFallback", threadPoolKey = "getByIdThreadPool")
	public Purchase getById(Long id) {
		return this.purchaseRepository.findById(id).orElse(new Purchase());
	}

	public Purchase getByIdFallback(Long id) {
		Purchase purchaseFallback = new Purchase();
		return purchaseFallback;
	}

}
