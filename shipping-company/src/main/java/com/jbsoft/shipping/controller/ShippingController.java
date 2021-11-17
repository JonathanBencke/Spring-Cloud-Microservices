package com.jbsoft.shipping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbsoft.shipping.dto.ShippingDTO;
import com.jbsoft.shipping.dto.VoucherDTO;
import com.jbsoft.shipping.service.ShippingService;

@RestController
@RequestMapping("/shipping")
public class ShippingController {
	
	@Autowired
	private ShippingService shippingService;

	@RequestMapping(method = RequestMethod.POST)
	public VoucherDTO reserveShipping(@RequestBody ShippingDTO pedidoDTO) {
		return shippingService.reserveDelivery(pedidoDTO);
	}
}
