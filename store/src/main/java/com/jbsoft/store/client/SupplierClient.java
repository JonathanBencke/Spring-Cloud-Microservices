package com.jbsoft.store.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jbsoft.store.dto.InfoOrderDTO;
import com.jbsoft.store.dto.InfoSupplierDTO;
import com.jbsoft.store.dto.PurchaseItemDTO;

@FeignClient("supplier")
public interface SupplierClient {

	@GetMapping("info/{district}")
	public InfoSupplierDTO getInfoByDistrict(@PathVariable String district);

	@PostMapping("order")
	public InfoOrderDTO makeOrder(List<PurchaseItemDTO> itens);

}
