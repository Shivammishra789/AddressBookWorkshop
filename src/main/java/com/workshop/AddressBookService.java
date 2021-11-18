package com.workshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookService {

	Scanner sc = new Scanner(System.in);

	ArrayList<ContactDetails> addressBookList = new ArrayList<ContactDetails>(); 

	public void createContact() {
		boolean found = false;
		//taking input from user to create new contact
		System.out.println("enter first name");
		String firstName = sc.nextLine();

		//checking for duplicate name in the address book
		for (int j = 0; j < addressBookList.size(); j++) {

			List<String> names = addressBookList.stream()
												.map(ContactDetails::getFirstName)
												.collect(Collectors.toList());

			for ( int k = 0; k < names.size(); k++)  {
				if(names.get(k).equals(firstName)) {
					found = true;
					break;
				}
			}
		}
		if (found == true) {
			System.out.println("Person Name is already in the address book!");
		}
		else {

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
			// storing contact in addressBookList
			addressBookList.add(createNewContact);
			System.out.println("Contact added successfully");
			System.out.println("To add more contact press 1");
			int addMore = sc.nextInt();
			if(addMore == 1) {
				sc.nextLine();
				createContact();
			}
		}
	}
	
	public void editContact() {

		System.out.println("enter first name to edit that contact");
		String toeditContact = sc.nextLine();
		int flag = 0;

		// searching for firstname to edit that contact
		for(ContactDetails contact:addressBookList) {

			// if first name matches then edit that contact
			if(contact.getFirstName().equalsIgnoreCase(toeditContact)) {
				flag = 1;
				System.out.println("Enter below number to edit that detail \n"
						+"1.firstName \n"
						+"2.lastName \n"
						+"3.address \n"
						+ "4.city \n"
						+ "5.state \n"
						+ "6.zip \n"
						+ "7.phoneNo \n"
						+ "8.emailId");

				int editInput = sc.nextInt();

				switch(editInput) {
				case 1:
					System.out.println("Enter new first name");
					contact.setFirstName(sc.next());
					break;
				case 2:
					System.out.println("Enter new last name");
					contact.setLastName(sc.next());
					break;
				case 3:
					System.out.println("Enter new address");
					contact.setAddress(sc.next());
					break;
				case 4:
					System.out.println("Enter new city");
					contact.setFirstName(sc.next());
					break;
				case 5:
					System.out.println("Enter new state");
					contact.setState(sc.next());
					break;
				case 6:
					System.out.println("Enter new zip");
					contact.setZip(sc.next());
					break;
				case 7:
					System.out.println("Enter new phoneNo");
					contact.setPhoneNo(sc.next());
					break;
				case 8:
					System.out.println("Enter new emailId");
					contact.setAddress(sc.next());
					break;

				default:
					System.out.println("Enter valid input");	   
				}
			}
		}
		if(flag == 0){
			System.out.println("Entered name not found");
		}
	}

	public void deleteContact() {
		System.out.println("enter first name to delete that contact");
		String todeleteContact = sc.nextLine();
		int flag = 0;
		// searching for firstname to delete that contact
		for(ContactDetails contact:addressBookList) {

			// if first name matches then delete that contact
			if(contact.getFirstName().equalsIgnoreCase(todeleteContact)) {
				flag = 1;
				addressBookList.remove(contact);
				System.out.println("contact deleted successfully");
				break;
			}
		}
		if(flag == 0) {
			System.out.println("Entered name not found");
		}
	}
}