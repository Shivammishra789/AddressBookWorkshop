package com.workshop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		MultiAddressBook multiAddressBook = new MultiAddressBook();

		while(true) {
			System.out.println("Enter following number to perform that task \n"+
					"1. Add new AddressBook \n"+
					"2. Add contact in existing AddressBook \n"+
					"3. Edit the contact in existing AddressBook \n"+
					"4. Delete the contact in AddressBook \n"+
					"5. Delete the AddressBook\n" +
					"6. Search Contact By City or State in AddressBook\n"+
					"7. Print the AddressBook \n"+
					"8. Print the contacts in AddressBook \n"+
					"0. Exit Applcation");
			try {
				int operation = sc.nextInt();
				switch(operation) {
				case 1:
					multiAddressBook.addAddressBook();
					break;
				case 2:
					multiAddressBook.addContact();
					break;
				case 3:
					multiAddressBook.editContactInBook();
					break;
				case 4:
					multiAddressBook.deleteContactInBook();
					break;
				case 5:
					multiAddressBook.deleteAddressBook();
					break;
				case 6:
					multiAddressBook.searchContacts();
					break;
				case 7:
					multiAddressBook.printBook();
					break;
				case 8:
					multiAddressBook.printContactsInBook();
					break;
				case 0:
					break;
				default:
					System.out.println("Enter valid input");
					continue;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Enter valid input");
			}
		}
	}
}