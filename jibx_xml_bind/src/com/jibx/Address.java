package com.jibx;

public class Address {

	private String addressName;
	private String city;
	private String nation;

	public Address() {
		super();
	}

	public Address(String addressName, String city, String nation) {
		super();
		this.addressName = addressName;
		this.city = city;
		this.nation = nation;
	}

	public String getAddressName() {
		return addressName;
	}

	public String getCity() {
		return city;
	}

	public String getNation() {
		return nation;
	}
}
