/*Name: phonedir.java
 * Author: Ryan Henao
 * Class: csc 3410 MW 1:30-2:45
 * Date: 10/9/2013
 * 1. The purpose of this program is to create a robust phone directory that is able to accept several commands for adding and deleting
 *    and modifying records.
 * 2. The solution to the program is to create a switch that calls each method and then to use a custom built linked list
 * to execute the appropriate response. The main algorithm used in this program is linear search O(n) in order to increment the 
 * linked list when modifying records or deleting records etc.. 
 * 3. The data structure used in this program is a custom built singly linked list using the Record class to represent each link
 * and RecordList to store the entire list.
 * 4. The input into the program is a simple single character that corresponds to a method call. The program catches
 * incorrect calls and displays an error message. q is the command to quit. The other inputs are used for information on each record such as 
 * first name, last name, and phone number
 * 5.The phonedir class contains the main method and is used as the controller method. It contains the switch which determines
 * which method to call next. phoneDirMethods contains all of the methods that can be performed on the RecordList. 
 * RecordList stores all of the records and holds the implementation logic / detailes of each method performed on its records.
 * The Record class stores an individual record and all of its relevant information.
 */

import java.util.Scanner;


public class phonedir {
	public static void main(String args[]){
		mainInterface(); //calls the main interface which controls the entire program
	}
	
	//method that contains the menu. Menu was put into here so that it could be reused over and over
	public static String getMenu(){
		String menuString = "A Program to keep a Phone Directory:"+ 
		"\n      a   Show all records"+
		"\n      d   Delete the current record"+ 
		"\n      f   Change the first name in the current record"+ 
		"\n      l   Change the last name in the current record"+
		"\n      n   Add a new record"+
		"\n      p   Change the phone number in the current record"+
		"\n      q   Quit"+
		"\n      s   Select a record from the record list to become the current record"+
		"\nEnter a command from the list above (q to quit):";
		return menuString;
	}
	
	//mainInterface contains a switch which calls every corresponding method
	public static void mainInterface(){
		Scanner input = new Scanner(System.in);
		phoneDirMethods p = new phoneDirMethods();
		String response;
		//menu is called at least once 
		do{
			System.out.println(getMenu());
			response = input.nextLine();
			
			switch (response){
			case "a": p.showRecords();
				break;
			case "d": p.deleteCurrentRecord();	
				break;
			case "f": p.changeFirstName();
				break;
			case "l": p.changeLastName();
				break;
			case "n": p.addNewRecord();
				break;
			case "p": p.changePhoneNumber();
				break;
			case "q": //no method call, causes program to terminate
				break;
			case "s": p.setCurrentRecord();
				break;
			default: System.out.println("Illegal command \n");
				break;
			}
		}while(!response.equals("q"));
	}
	//after this method program is completely finished
}
