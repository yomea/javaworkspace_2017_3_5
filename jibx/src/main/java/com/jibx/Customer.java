package com.jibx;

import java.util.ArrayList;

public class Customer {

	private String firstName;
	private String lastName;
	private int age;
	private String phone;
	private Address address;
	private ArrayList companyList;

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
