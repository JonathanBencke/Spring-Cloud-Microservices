package com.jbsoft.store.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Purchase {

	@Id
	private Long purchaseId;
	private Integer prepareTime;
	private String destinationAddress;

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

}
