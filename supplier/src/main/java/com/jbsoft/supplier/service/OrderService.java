package com.jbsoft.supplier.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbsoft.supplier.dto.OrderItemDTO;
import com.jbsoft.supplier.model.Orders;
import com.jbsoft.supplier.model.OrderItem;
import com.jbsoft.supplier.model.Product;
import com.jbsoft.supplier.repository.OrderRepository;
import com.jbsoft.supplier.repository.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository OrderRepository;

	@Autowired
	private ProductRepository productRepository;

	public Orders makeOrder(List<OrderItemDTO> itens) {

		if (itens == null) {
			return null;
		}

		List<OrderItem> OrderItens = toOrderItem(itens);
		Orders Order = new Orders(OrderItens);
		Order.setPrepareTime(itens.size());
		return OrderRepository.save(Order);
	}

	public Orders getOrderById(Long id) {
		return this.OrderRepository.findById(id).orElse(new Orders());
	}

	private List<OrderItem> toOrderItem(List<OrderItemDTO> itens) {

		List<Long> idsProducts = itens.stream().map(item -> item.getId()).collect(Collectors.toList());

		List<Product> ProductsDoOrder = productRepository.findByIdIn(idsProducts);

		List<OrderItem> OrderItens = itens.stream().map(item -> {
			Product Product = ProductsDoOrder.stream().filter(p -> p.getId() == item.getId()).findFirst().get();

			OrderItem OrderItem = new OrderItem();
			OrderItem.setProduct(Product);
			OrderItem.setAmount(item.getAmount());
			return OrderItem;
		}).collect(Collectors.toList());
		return OrderItens;
	}
}
