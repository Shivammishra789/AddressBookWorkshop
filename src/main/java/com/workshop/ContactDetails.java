package com.workshop;

public class ContactDetails {

	//variables
	private String firstName, lastName, address, city, state, zip, phoneNo, emailId;

	public ContactDetails(String firstName, String lastName, String address, String city, String state, String zip,
			String phoneNo, String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Contacts ["+firstName + ", " + lastName + ", " + phoneNo +", " + address + ", "
				+ city + ", " + state + ", " + zip + ", " + emailId + "]\n";
	}
}
