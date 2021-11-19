package com.workshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookService {

	Scanner scanner = new Scanner(System.in);

	static List<ContactDetails> addressBookList = new ArrayList<ContactDetails>(); 
	ContactDetails contactDetails = new ContactDetails();

	public void createContact() {
		boolean found = false;
		//taking input from user to create new contact
		System.out.println("enter first name");
		String firstName = scanner.nextLine();

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
			String lastName = scanner.nextLine();

			System.out.println("enter address");
			String address = scanner.nextLine();

			System.out.println("enter city");
			String city = scanner.nextLine();

			System.out.println("enter state");
			String state = scanner.nextLine();

			System.out.println("enter zip code");
			String zip = scanner.nextLine();

			System.out.println("enter phone number");
			String phoneNo = scanner.nextLine();

			System.out.println("enter email Id");
			String emailId = scanner.nextLine();

			ContactDetails createNewContact = new ContactDetails(firstName, lastName, address, city, state, zip, phoneNo, emailId);
			// storing contact in addressBookList
			addressBookList.add(createNewContact);
			System.out.println("Contact added successfully");
			System.out.println("To add more contact press 1");
			int addMore = scanner.nextInt();
			if(addMore == 1) {
				scanner.nextLine();
				createContact();
			}
		}
	}
	
	public void editContact() {

		System.out.println("enter first name to edit that contact");
		String toeditContact = scanner.nextLine();
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

				int editInput = scanner.nextInt();

				switch(editInput) {
				case 1:
					System.out.println("Enter new first name");
					contact.setFirstName(scanner.next());
					break;
				case 2:
					System.out.println("Enter new last name");
					contact.setLastName(scanner.next());
					break;
				case 3:
					System.out.println("Enter new address");
					contact.setAddress(scanner.next());
					break;
				case 4:
					System.out.println("Enter new city");
					contact.setFirstName(scanner.next());
					break;
				case 5:
					System.out.println("Enter new state");
					contact.setState(scanner.next());
					break;
				case 6:
					System.out.println("Enter new zip");
					contact.setZip(scanner.next());
					break;
				case 7:
					System.out.println("Enter new phoneNo");
					contact.setPhoneNo(scanner.next());
					break;
				case 8:
					System.out.println("Enter new emailId");
					contact.setAddress(scanner.next());
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
		String todeleteContact = scanner.nextLine();
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
	
	//search contact by city name
	public void searchByCity(String city) {
		List<ContactDetails> collect = addressBookList.stream()
													  .filter(p -> p.getCity().equalsIgnoreCase(city))
													  .collect(Collectors.toList());
		for (ContactDetails contact : collect) {
			System.out.println("Search result: " + contact);
		}
	}

	//search contact by state name
	public void searchByState(String state) {
		List<ContactDetails> collect = addressBookList.stream()
				                                      .filter(p -> p.getState().equalsIgnoreCase(state))
				                                      .collect(Collectors.toList());
		for (ContactDetails contact : collect) {
			System.out.println("Search result: " + contact);
		}
	}
	
	//count contact by city name
		public void countByCity(String cityName) {
			long count = addressBookList.stream()
					                    .filter(g -> g.getCity()
					                    .equalsIgnoreCase(cityName))
					                    .count();
			System.out.println("Total Number of Contact from '" + cityName + "' city is " + count);
		}
		
		//count contact by state name
		public void countByState(String stateName) {
			long count1 = addressBookList.stream()
					                     .filter(g -> g.getState()
					                     .equalsIgnoreCase(stateName))
					                     .count();
			System.out.println("Total Number of Contact from '" + stateName + "' state is " + count1);
		}
}