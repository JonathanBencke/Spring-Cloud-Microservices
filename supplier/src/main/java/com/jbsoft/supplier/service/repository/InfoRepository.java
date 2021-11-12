package com.jbsoft.supplier.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jbsoft.supplier.service.model.InfoSupplider;

@Repository
public interface InfoRepository extends CrudRepository<InfoSupplider, Long>{

	InfoSupplider findByDistrict(String district);
	
}
