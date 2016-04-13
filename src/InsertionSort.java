public class InsertionSort {
	//takes in an array of strings and returns it sorted. 
	//It is used by anagram for both the word sorting and for the array sorting.
	public static String[] sort(String[] inputArray){
		
		for(int i = 0;i<inputArray.length;i++){
			int j = i;
			String toInsert = inputArray[i]; //this is the string that will be inserted
				
			while((j > 0) && (inputArray[j-1].compareTo(toInsert) > 0)){
				inputArray[j] = inputArray[j-1]; //swap j with string before j if string is greater
				j--;	
			}
			inputArray[j] = toInsert; //inserts string into its proper location
		}
		return inputArray;
	}
	//returning an array that is now sorted alphabetically 
}
