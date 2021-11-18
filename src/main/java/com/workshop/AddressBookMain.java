package com.workshop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		AddressBookService addressBookService = new AddressBookService();

		ContactDetails createNewContact1 = new ContactDetails("Shivam","Mishra","Pimpri","Pune","Mah","411039","8830466378","Shivam@gmail.com");
		ContactDetails createNewContact2 = new ContactDetails("Shiv","Kaka","Pimpri","Pune","Mah","411039","8830466378","Shivam@gmail.com");

		// storing contact in addressBookList
		addressBookService.addressBookList.add(createNewContact1);
		addressBookService.addressBookList.add(createNewContact2);

		System.out.println("Enter following number to perform that task \n"+
						   "1. add new contact \n"+
						   "2. edit existing contact \n"+
						   "3. delete contact \n"+
				           "0. exit");
		try {
			int operation = sc.nextInt();
			switch(operation) {
			case 1:
				addressBookService.addContact();
				break;
			case 2:
				addressBookService.editContact();
				break;
			case 3:
				addressBookService.deleteContact();
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