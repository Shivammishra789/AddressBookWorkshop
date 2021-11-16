package com.workshop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		AddressBookService addressBookService = new AddressBookService();

		ContactDetails createNewContact = new ContactDetails("Shivam","Mishra","Pimpri","Pune","Mah","411039","8830466378","Shivam@gmail.com");

		// storing contact in addressBookList
		addressBookService.addressBookList.add(createNewContact);

		System.out.println("Enter 1 to add new contact \n"+
				"Enter 2 to edit contact \n"+
				"Enter 0 to exit");
		try {
			int operation = sc.nextInt();
			switch(operation) {
			case 1:
				addressBookService.addContact();
				break;
			case 2:
				addressBookService.editContact();
				break;
			case 0:
				break;
			default:
				System.out.println("Enter valid input");
			}

			System.out.println(addressBookService.addressBookList);
		}
		catch(InputMismatchException e) {
			System.out.println("Enter valid input");
		}	
	}
}
