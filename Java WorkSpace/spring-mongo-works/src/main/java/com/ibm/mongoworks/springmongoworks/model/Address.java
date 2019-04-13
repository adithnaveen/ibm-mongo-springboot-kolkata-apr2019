package com.ibm.mongoworks.springmongoworks.model;

public class Address {
	private String addressType; 
	private Integer houseNo; 
	private String streetName; 
	private String city; 
	private String country;
	
	public Address() {}
	
	public Address(String addressType, Integer houseNo, String streetName, String city, String country) {
		this.addressType =addressType; 
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.city = city;
		this.country = country;
	}

	public Integer getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(Integer houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	} 
	
	
	
}
