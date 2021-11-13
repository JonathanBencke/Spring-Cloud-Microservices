package com.jbsoft.supplier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbsoft.supplier.model.Product;
import com.jbsoft.supplier.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getProductsByDistrict(String district) {
		return productRepository.findByDistrict(district);
	}

}
