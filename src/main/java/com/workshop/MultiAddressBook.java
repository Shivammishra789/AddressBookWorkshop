package com.workshop;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MultiAddressBook {

	Map<String, AddressBookService> multiAddressBookDetails = new HashMap<String, AddressBookService>();
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
