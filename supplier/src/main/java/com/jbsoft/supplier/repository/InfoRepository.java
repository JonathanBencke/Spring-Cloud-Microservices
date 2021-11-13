package com.jbsoft.supplier.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jbsoft.supplier.model.InfoSupplier;

@Repository
public interface InfoRepository extends CrudRepository<InfoSupplier, Long> {

	InfoSupplier findByDistrict(String district);
}
