package com.jbsoft.supplier.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbsoft.supplier.dto.OrderItemDTO;
import com.jbsoft.supplier.model.Orders;
import com.jbsoft.supplier.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {

	private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;

	@RequestMapping(method = RequestMethod.POST)
	public Orders makeOrder(@RequestBody List<OrderItemDTO> products) {
		LOG.info("Request received to make order");
		return orderService.makeOrder(products);
	}

	@RequestMapping("/{id}")
	public Orders getOrderById(@PathVariable Long id) {
		LOG.info("Request received to get order by id");
		return orderService.getOrderById(id);
	}

}
