public class Record {
	
	//all the fields used by one record
	public String firstName;
	public String lastName;
	public String phoneNumber;
	public Record nextRecord; //stores a link to the next record
	
	//initializes the record
	public Record(String firstName,String lastName,String phoneNumber){
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
	//copy constructor
	//this is used instead of clone() method because of problems when trying to perform a deep clone
	//other classes call this method to make clones for themselves
	public Record(Record aRecord) {
	    this(aRecord.firstName, aRecord.lastName,aRecord.phoneNumber);
	}
	//new reocord created that is now a clone of record given
	
	
	//prints the first name last name and phone number in a nice format
	public void printItems(){
		System.out.println(this.firstName + "\t \t" + this.lastName + "\t \t" + this.phoneNumber);
	}
	
}
