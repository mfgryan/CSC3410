public class RecordList {
	//Record list holds all the logic performed on the list
	
	private Record first; //important this is used to begin looping through the array
	private Record currentRecord = null; //current record
	
	public RecordList(){
		first = null; //by defualt the first value is null
	}
	
	public boolean isEmpty() {
	    return first == null; //if empty returns true
    }
	
	//used to insert a value if it is know to be the very first one
	//sets first equal to its new correct value as well
	public void insertFirst(String firstName, String lastName, String phoneNumber){
		Record record = new Record(firstName,lastName,phoneNumber);
		record.nextRecord = first;
		first = record;
		setCurrentRecord(record);
	}
	
	//inserts an item into the list in the correct position
	//checks first to see if the item is first
	//if item is first it calls the insert first method
	public void insertInOrder(String firstName,String lastName,String phoneNumber){
		if(lastName.compareToIgnoreCase(first.lastName) < 0)
			insertFirst(firstName,lastName,phoneNumber);
		else{
			Record currentRecord = first;
			while(currentRecord.nextRecord!= null && lastName.compareToIgnoreCase(currentRecord.nextRecord.lastName) > 0)
				currentRecord = currentRecord.nextRecord;
				
				Record temp;
				if(currentRecord.nextRecord != null){
					temp = new Record(currentRecord.nextRecord);
					if((currentRecord.nextRecord).nextRecord != null)
						temp.nextRecord = (currentRecord.nextRecord).nextRecord; //clone method used here
					else
						temp.nextRecord = null;
				}else
					temp = null;
				
				
				
				currentRecord.nextRecord = new Record(firstName,lastName,phoneNumber);
				currentRecord = currentRecord.nextRecord; //new record is being inserted in between the two old records
				currentRecord.nextRecord = temp;
				
				setCurrentRecord(currentRecord);
		}	
	}
	//list will now have the item stored in its correct position
	
	public void printRecords(){
		Record currentRecord = first;
		
		if(currentRecord == null)
			System.out.println("No records");
		
		//iterates through the entire list
		while(currentRecord != null){
			currentRecord.printItems();  //record has a special printing method
			currentRecord = currentRecord.nextRecord;
		}
	}
	//returns the current record
	public Record getCurrentRecord() {
		return currentRecord;
	}
	//sets the current record to the given record
	public void setCurrentRecord(Record currentRecord) {
		this.currentRecord = currentRecord;
	}
	//sets the current record to the given first name and last name by matching them
	//if no match prints out record not found
	public void setCurrentRecord(String firstName, String lastName){
		Record currentRecord = first;
		while(currentRecord.nextRecord != null){
			if(firstName.equals(currentRecord.firstName) && lastName.equals(currentRecord.lastName)){
				setCurrentRecord(currentRecord);
				return;
			}
			currentRecord = currentRecord.nextRecord;
		}
		System.out.println("No Matching record found");
	}
	// deletes the current record
	public void deleteCurrentRecord(){
		Record currentRecord = first;
		
		if(currentRecord.nextRecord != null){
			//booleans used to simplify the while condition
			boolean firstN = currentRecord.nextRecord.firstName.equals(getCurrentRecord().firstName);
			boolean last  = currentRecord.nextRecord.lastName.equals(getCurrentRecord().lastName);
			boolean phone = currentRecord.nextRecord.phoneNumber.equals(getCurrentRecord().phoneNumber);
			
			//checks for equality with each record to currentRecord
			while(currentRecord.nextRecord != null && (!firstN || !last || !phone))
				currentRecord = currentRecord.nextRecord;
			
			
			firstN = first.firstName.equals(getCurrentRecord().firstName);
			last   = first.lastName.equals(getCurrentRecord().lastName);
			phone  = first.phoneNumber.equals(getCurrentRecord().phoneNumber);
			
			if(firstN && last && phone){
				first = first.nextRecord; //if it is the first record, shift over one
			}
			
			//otherwise take the record before the one to delete and link it to the one after
			try{
				currentRecord.nextRecord = currentRecord.nextRecord.nextRecord;
			}catch(Exception e){
				currentRecord.nextRecord = null;
			}
			
	
		}else{
			first = null;
		}
		setCurrentRecord(null);
	}
	//new list with currentRecord gone
}