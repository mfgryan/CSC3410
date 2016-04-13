import java.util.Scanner;

//all methods here are void

public class phoneDirMethods {
	
	// table header used when printing out the table
	private static String tableHeader = "First Name \t Last Name \t Phone Number \n-------- \t ---------- \t ---------";
	RecordList recordsList = new RecordList(); //the custom linked list that stores all the records
	
	//shows all the records, takes no parameters, users table Header
	public void showRecords(){
		if(!recordsList.isEmpty())
			System.out.println(tableHeader);
		recordsList.printRecords();
	}
	
	//deletes the currentRecord by calling the deleteCurrentRecord method in RecordList
	//also makes sure list is not already empty
	public void deleteCurrentRecord(){
		if(!recordsList.isEmpty())
			recordsList.deleteCurrentRecord();
		else
			System.out.println("No records to Delete");
	}
	
	//Changes the first name of the current record using a getter
	public void changeFirstName(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a new first Name: ");
		String firstName = input.nextLine();
		recordsList.getCurrentRecord().firstName = firstName;
	}
	//firts name now equal to input
	
	//changes last name of current record using another getter
	public void changeLastName(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter new last name: ");
		String lastName = input.nextLine();
		
		Record currentRecord = recordsList.getCurrentRecord();
		currentRecord.lastName = lastName;
	}
	//last name now equal to input
	
	//adds a new record while keeping the list in order
	//asks user for three values first name last name and phone number
	public void addNewRecord(){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter first name: ");
		String firstName = input.nextLine();
		
		System.out.println("Enter last name: ");
		String lastName = input.nextLine();
		
		System.out.println("Enter phone number: ");
		String phoneNumber = input.nextLine();
		
		addRecordHelper(firstName,lastName,phoneNumber);
		
		System.out.print("Current record is: ");
		recordsList.getCurrentRecord().printItems();
	}
	
	//changes the phone number using a getter
	public void changePhoneNumber(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a new phone Number: ");
		String phoneNumber = input.nextLine();
		recordsList.getCurrentRecord().phoneNumber = phoneNumber;
	}
	//phone number now equal to input
	
	//changes the current record using a setter
	//the setter also makes sure the record exists in the list
	public void setCurrentRecord(){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter first name: ");
		String firstName = input.nextLine();
		
		System.out.println("Enter last name: ");
		String lastName  = input.nextLine();
		
		recordsList.setCurrentRecord(firstName,lastName);
	}
	
	//helper method for addRecord
	//checks if list is empty first
	private void addRecordHelper(String firstName, String lastName, String phoneNumber){
		if(recordsList.isEmpty()){
			recordsList.insertFirst(firstName, lastName, phoneNumber);
		}else{
			recordsList.insertInOrder(firstName, lastName, phoneNumber);
		}
	}
}
