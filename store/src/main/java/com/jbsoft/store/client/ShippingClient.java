package com.jbsoft.store.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jbsoft.store.dto.InfoDeliveryDTO;
import com.jbsoft.store.dto.VoucherDTO;

@FeignClient("shipping")
public interface ShippingClient {

	@RequestMapping(path = "/shipping", method = RequestMethod.POST)
	public VoucherDTO reserveShipping(InfoDeliveryDTO deliveryDTO);

}
