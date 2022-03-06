package com.mycompany.app;

import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
	static ArrayList<String> list = new ArrayList<String>();
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		mainMenu();
	}
	
	public static void mainMenu() {
		System.out.println("Main Menu:\n----------");
		System.out.println("1. Add Item \n2. Remove Item \n3. View To-Do List\n4. Exit");
		// error handling
		boolean isInt = input.hasNextInt();
		while(isInt == false) {
			input.nextLine();
			System.out.println("Error: Invalid input. Please enter an integer.");
			isInt = input.hasNextInt();
		}
		// calls method that user chose
		int answer = input.nextInt();
		switch (answer) {
			case 1: addItem();
			break;
			case 2: deleteItem();
			break;
			case 3: viewList();
			break;
			case 4: System.out.println("\nProgram Exited, thank you for using To-Do!\n");
			break;
			default: System.out.println("Error: " + answer + " is not a valid input.\nPlease enter one of the choices listed.");
			System.out.println();
			mainMenu();
			break;
		}
	}
	
	public static void addItem() { // addItem method takes a String input and adds it to users To-Do list
		System.out.println("\nEnter a To-do item to add: ");
		input.nextLine();
		String item = input.nextLine();
		list.add(item);
		System.out.println("\n" + item + " has been successfully added.\n");
		
		System.out.println("Would you like to:\n1. Add another item\n2. Return to main menu");
		//error handling
		boolean isInt = input.hasNextInt();
		while(isInt == false) {
			input.nextLine();
			System.out.println("Error: Invalid input. Please enter an integer.");
			isInt = input.hasNextInt();
		}
		int answer = input.nextInt();
		// gives user option to add another item or return to main menu
		switch (answer) {
		case 1: addItem();
		break;
		case 2: mainMenu();
		break;
		default: System.out.println("Error: " + answer + " is not a valid input.\nPlease enter one of the choices listed above.");
		break;
		}
		
	}
	
	public static void deleteItem() { // deleteItem method takes integer input corresponding with item on list and removes it
		// checks that list isn't empty
		if(list.size() == 0) {
			System.out.println("\nThere is currently nothing on your To-Do list to remove.\n");
			mainMenu();
		} else {
			System.out.println("\nYour To-Do List:");
			System.out.println("----------------");
			for(int i = 0; i < list.size(); i++) //iterates through list and prints each item
				System.out.println(i+1 + ". " + list.get(i));
			System.out.println("\nSelect the number item you would like to remove from your list.");
			// error handling
			boolean isInt = input.hasNextInt();
			while(isInt == false) {
				input.nextLine();
				System.out.println("Error: Invalid input. Please enter an integer.");
				isInt = input.hasNextInt();
			}
			
			int item = input.nextInt();
			if(item > list.size()) { //is item in bounds of list
				System.out.println("That item does not exist.\n");
			} else { // if yes, then remove
				list.remove(item - 1);
				System.out.println("Item has been successfully removed.\n");
			}
			
			System.out.println("Would you like to:\n1. Remove another item\n2. Return to main menu");
			int answer = input.nextInt();
			// gives user option to remove another item or return to main menu
			switch (answer) {
			case 1: deleteItem();
			break;
			case 2: mainMenu();
			break;
			default: System.out.println("Error: " + answer + " is not a valid input.\nPlease enter one of the choices listed above.");
			break;
			}
		}
	}
	
	public static void viewList() {	
		if(list.size() == 0) { // is list empty
			System.out.println("\nThere is currently nothing on your To-Do list.\n");
			mainMenu();
		} else { // if no, print list
			System.out.println("\nYour To-Do List:");
			System.out.println("----------------");
			for(int i = 0; i < list.size(); i++) { //iterates through list and prints each item
				System.out.println(i+1 + ". " + list.get(i));
			}
		}
		//return to main menu
		System.out.println("\nEnter anything to return to Main Menu.");
		String temp = input.next();
		if(temp != null)
			mainMenu();
	}
}
