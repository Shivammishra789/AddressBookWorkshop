package com.workshop;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MultiAddressBook {

	HashMap<String, AddressBookService> multiAddressBookDetails = new HashMap<String, AddressBookService>();
	AddressBookService addressBookService = new AddressBookService();
	ContactDetails contactDetails = new ContactDetails();
	Scanner scanner = new Scanner(System.in);
	
	public void addAddressBook() {
		System.out.println("Enter Name of new Address Book: ");
		String bookName = scanner.next();
		if (multiAddressBookDetails.containsKey(bookName)) {
			System.out.println("Address book with this name exists, Enter new name.");
			addAddressBook();
		} else {
			AddressBookService createNewContact = new AddressBookService();
			multiAddressBookDetails.put(bookName, createNewContact);
			System.out.println("press 1 if you want to add another book.");
			int newBook = scanner.nextInt();
			if (newBook == 1) {
				scanner.nextLine();
				addAddressBook();
			}
		}
	}
	
	public void addContact() {
		scanner.nextLine();
		System.out.println("Enter the name of Address book to add the contact.");
		String addressBookname = scanner.nextLine();
		if(multiAddressBookDetails.containsKey(addressBookname)) {
			multiAddressBookDetails.get(addressBookname).createContact();
		}
		else {
				System.out.println("No address book with this name");
		}
		
	}
	
	public void editContactInBook() {
		System.out.println("Enter Name to Edit Address Book: ");
		String editBookName = scanner.next();
		if (multiAddressBookDetails.containsKey(editBookName)) {
			multiAddressBookDetails.get(editBookName).editContact();
		} else {
			System.out.println("AddressBook doesn't exist!!");
			editContactInBook();
		}
	}

	public void deleteAddressBook() {
		System.out.println("Enter Name to Delete Address Book: ");
		String bookName = scanner.next();
		if (multiAddressBookDetails.containsKey(bookName)) {
			multiAddressBookDetails.remove(bookName);
		} else {
			System.out.println("AddressBook doesn't exist!!");
			deleteAddressBook();
		}
	}

	public void deleteContactInBook() {
		System.out.println("Enter Name to delete the contacts from Address Book : ");
		String bookName = scanner.next();
		if (multiAddressBookDetails.containsKey(bookName)) {
			multiAddressBookDetails.get(bookName).deleteContact();
		} else {
			System.out.println("AddressBook doesn't exist!!");
			deleteContactInBook();
		}
	}
	
	//search contacts using city or state name
	public void searchContacts() {
		while (true) {
			System.out.println("Enter\n 1. By city\n 2. By state\n 0. for previous menu");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter city: ");
				String city = scanner.nextLine();
				addressBookService.searchByCity(city);
				break;
			case 2:
				System.out.println("Enter state: ");
				String state = scanner.nextLine();
				addressBookService.searchByState(state);
				break;
			case 0:
				return;
			default:
				System.out.println("Entered choice is incorrect!.. please enter correct choice");
			}
		}
	}
	
	//count number of contacts in all address books using city or state name
		public void countContacts() {
			while (true) {
				System.out.println("Enter\n 1. By city\n 2. By state\n 0. for previous menu");
				int choice = scanner.nextInt();
				scanner.nextLine();
				switch (choice) {
				case 1:
					System.out.println("Enter city: ");
					String city = scanner.nextLine();
					addressBookService.countByCity(city);
					break;
				case 2:
					System.out.println("Enter state: ");
					String state = scanner.nextLine();
					addressBookService.countByState(state);
					break;
				case 0:
					return;
				default:
					System.out.println("Entered choice is incorrect!.. please enter correct choice");
				}
			}
		}

	public void printBook() {
		System.out.println("Address Book Present are: ");
		for (Map.Entry<String, AddressBookService> entry : multiAddressBookDetails.entrySet()) {
			System.out.println(entry.getKey());
		}
	}

	public void printContactsInBook() {
		int countContact = 1;
		for (Map.Entry<String, AddressBookService> entry : multiAddressBookDetails.entrySet()) {
			System.out.println("The contacts in the Book of < " + entry.getKey() + " > are!...");
			System.out.println(countContact + " " + entry.getValue().addressBookList);
			countContact++;
		}
		System.out.println(" ");
	}
}
