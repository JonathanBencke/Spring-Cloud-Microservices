package com.jbsoft.shipping.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long orderId;

	private LocalDate retriveDate;

	private LocalDate deliveryDate;

	private String origemAddress;

	private String destinyAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDate getRetriveDate() {
		return retriveDate;
	}

	public void setRetriveDate(LocalDate retriveDate) {
		this.retriveDate = retriveDate;
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
