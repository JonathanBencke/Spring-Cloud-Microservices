package com.jbsoft.supplier.repository;

import org.springframework.data.repository.CrudRepository;

import com.jbsoft.supplier.model.Orders;

public interface OrderRepository extends CrudRepository<Orders, Long> {

}
