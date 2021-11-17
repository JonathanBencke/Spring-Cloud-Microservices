package com.jbsoft.shipping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbsoft.shipping.dto.ShippingDTO;
import com.jbsoft.shipping.dto.VoucherDTO;
import com.jbsoft.shipping.model.Delivery;
import com.jbsoft.shipping.repository.DeliveryRepository;

@Service
public class ShippingService {
	
	@Autowired
	private DeliveryRepository repository;

	public VoucherDTO reserveDelivery(ShippingDTO orderDTO) {
		
		Delivery delivery = new Delivery();
		delivery.setRetriveDate(orderDTO.getDeliveryDate());
		delivery.setDeliveryDate(orderDTO.getDeliveryDate().plusDays(1l));
		delivery.setDestinyAddress(orderDTO.getDestinyAddress());
		delivery.setOrigemAddress(orderDTO.getOrigemAddress());
		delivery.setOrderId(orderDTO.getOrderId());
		
		repository.save(delivery);
		
		VoucherDTO voucher = new VoucherDTO();
		voucher.setNumber(delivery.getId());
		voucher.setDeliveryDate(delivery.getDeliveryDate());
		return voucher;
	}

}
