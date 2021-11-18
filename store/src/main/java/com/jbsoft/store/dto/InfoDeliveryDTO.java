package com.jbsoft.store.dto;

import java.time.LocalDate;

public class InfoDeliveryDTO {
	
	private Long orderId;

	private LocalDate deliveryDate;

	private String origemAddress;

	private String destinyAddress;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getOrigemAddress() {
		return origemAddress;
	}

	public void setOrigemAddress(String origemAddress) {
		this.origemAddress = origemAddress;
	}

	public String getDestinyAddress() {
		return destinyAddress;
	}

	public void setDestinyAddress(String destinyAddress) {
		this.destinyAddress = destinyAddress;
	}

}
