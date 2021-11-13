package com.jbsoft.supplier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbsoft.supplier.model.Product;
import com.jbsoft.supplier.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/{district}")
	public List<Product> getProductsByDistrict(@PathVariable("district") String district) {
		return productService.getProductsByDistrict(district);
	}
}
