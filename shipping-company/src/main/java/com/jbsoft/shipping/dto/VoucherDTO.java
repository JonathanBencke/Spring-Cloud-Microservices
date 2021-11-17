package com.jbsoft.shipping.dto;

import java.time.LocalDate;

public class VoucherDTO {

	private Long number;

	private LocalDate deliveryDate;

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

}
