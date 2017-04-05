package com.jibx;

public class Company {

	private String comName;
	private String address;
	
	public Company() {
		super();
	}

	public Company(String comName, String address) {
		super();
		this.comName = comName;
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public String getComName() {
		return comName;
	}
}