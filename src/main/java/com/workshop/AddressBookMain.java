package com.workshop;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {

	Scanner sc = new Scanner(System.in);

	static ArrayList<ContactDetails> addressBookList = new ArrayList<ContactDetails>();

	public void addContact() {
		
		//taking input from user to create new contact
		System.out.println("enter first name");
		String firstName = sc.nextLine();

		System.out.println("enter last name");
		String lastName = sc.nextLine();

		System.out.println("enter address");
		String address = sc.nextLine();

		System.out.println("enter city");
		String city = sc.nextLine();

		System.out.println("enter state");
		String state = sc.nextLine();

		System.out.println("enter zip code");
		String zip = sc.nextLine();

		System.out.println("enter phone number");
		String phoneNo = sc.nextLine();

		System.out.println("enter email Id");
		String emailId = sc.nextLine();

		ContactDetails createNewContact = new ContactDetails(firstName, lastName, address, city, state, zip, phoneNo, emailId);
		addressBookList.add(createNewContact);
	}

	public static void main(String[] args) {

		AddressBookMain addressBookmain = new AddressBookMain();

		ContactDetails createNewContact = new ContactDetails("Shivam","Mishra","Pimpri","Pune","Mah","411039","8830466378","Shivam@gmail.com");
		addressBookList.add(createNewContact);
		addressBookmain.addContact();
		System.out.println(addressBookList);

	}

}
