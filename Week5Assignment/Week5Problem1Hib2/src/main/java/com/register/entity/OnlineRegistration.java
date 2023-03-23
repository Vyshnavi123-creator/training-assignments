package com.register.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="onlineRegistration")
public class OnlineRegistration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int id;
     private String firstName;
     private String lastName;
     
     private String contactNumber;
     private String address;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public OnlineRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OnlineRegistration(String firstName, String lastName, String contactNumber, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.address = address;
	}
	@Override
	public String toString() {
		return "OnlineRegistration [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", contactNumber=" + contactNumber +  ", address=" + address + "]";
	}
	
     
}
