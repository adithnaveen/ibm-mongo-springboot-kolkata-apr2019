package com.ibm.mongoworks.springmongoworks.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	@Id
	private Integer id;
	@Size(min = 4, max = 30, message = "Name should be min 4 chars")
	private String name;

	@Past
	private Date birthDate;
	private double income;
	private List<Address> address;

	public User() {
	}

	public User(Integer id, @Size(min = 4, max = 30, message = "Name should be min 4 chars") String name,
			@Past Date birthDate, double income, List<Address> address) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.income = income;
		this.address = address;
	}

/////////////////////////////////////////////
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}


	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", income=" + income + ", address="
				+ address + "]";
	}

}
