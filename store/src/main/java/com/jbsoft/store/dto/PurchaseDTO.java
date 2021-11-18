package com.jbsoft.store.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PurchaseDTO {

	@JsonIgnore
	private Long purchaseId;
	private List<PurchaseItemDTO> itens;
	private AddressDTO address;

	public List<PurchaseItemDTO> getItens() {
		return itens;
	}

	public void setItens(List<PurchaseItemDTO> itens) {
		this.itens = itens;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

}
