package com.jbsoft.store.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Purchase {

	@Id
	private Long purchaseId;
	private Integer prepareTime;
	private String destinationAddress;
	private LocalDate deliveryDate;
	private Long voucher;

	public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Integer getPrepareTime() {
		return prepareTime;
	}

	public void setPrepareTime(Integer prepareTime) {
		this.prepareTime = prepareTime;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Long getVoucher() {
		return voucher;
	}

	public void setVoucher(Long voucher) {
		this.voucher = voucher;
	}

}
