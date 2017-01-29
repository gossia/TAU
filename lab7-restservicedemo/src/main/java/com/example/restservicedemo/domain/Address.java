package com.example.restservicedemo.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Address {
	
	private long id;
	private String city;
	private String postalCode;
	private String street;
	private String houseNumber;
	private long residentId;

	public Address(String city, String postalCode, String street, String houseNumber, long residentId) {
		this.city = city;
		this.postalCode = postalCode;
		this.street = street;
		this.houseNumber = houseNumber;
		this.residentId = residentId;
	}

	public Address(long id, String city, String postalCode, String street, String houseNumber, long residentId) {
		super();
		this.id = id;
		this.city = city;
		this.postalCode = postalCode;
		this.street = street;
		this.houseNumber = houseNumber;
		this.residentId = residentId;
	}
	
	public Address() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public long getResidentId() {
		return residentId;
	}

	public void setResidentId(long residentId) {
		this.residentId = residentId;
	}

}
