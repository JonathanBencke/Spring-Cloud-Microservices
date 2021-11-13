package com.jbsoft.store.dto;

public class AddressDTO {

	private String street;
	private int number;
	private String district;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "AddressDTO [street=" + street + ", number=" + number + ", district=" + district + "]";
	}

}
