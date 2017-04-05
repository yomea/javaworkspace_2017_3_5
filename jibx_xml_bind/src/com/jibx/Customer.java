package com.jibx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Serializable {

	private static final long serialVersionUID = 8036075340250957186L;
	
	private String firstName;
	private String lastName;
	private int age;
	private String phone;
	private Address address;
	private ArrayList companyList;
	
	

	public Customer() {
		super();
	}

	public Customer(String firstName, String lastName, int age, String phone, Address address, List<?> companyList) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.companyList =  (ArrayList) companyList;
	}

	public Address getAddress() {
		return address;
	}

	public int getAge() {
		return age;
	}

	public ArrayList getCompanyList() {
		return companyList;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}
	
	
	
}
