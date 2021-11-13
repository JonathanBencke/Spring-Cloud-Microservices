package com.jbsoft.supplier.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jbsoft.supplier.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByDistrict(String district);

	List<Product> findByIdIn(List<Long> ids);
}
