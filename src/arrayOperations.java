public class arrayOperations {
	//takes an array and returns a sorted and cleaned up array with lowercase letters and no punctuation
	public static String[] formatWords(String[] inputArray){
		for(int i = 0;i<inputArray.length;i++){
			
			if(inputArray[i].length() > 12) //skips over words that are too large
				continue;
			
			inputArray[i] = inputArray[i].replaceAll("(\\W|[0-9]|_)", "").toLowerCase(); //regex used to remove punctuation
			
			String[] wordArray = inputArray[i].split("(?!^)"); // splits the current string into an array each element containing a single character
			
			String[] sortedWordArray = InsertionSort.sort(wordArray); //the wordArray is then passed into insertion sort to be sorted properly and returned
			
			inputArray[i] = ""; //erases current index so that it can be overwritten with new string result
			
			for(String string: sortedWordArray) //takes the sortedWordArray and makes it back into a string so it can be placed back into the array
				inputArray[i] += string;
		}
		return inputArray;
	}
	
	//doesn't return anything but prints out the final results using a mapping technique
	public static void printAnagrams(String[] originalArray,String[] sortedArray){
		for(int i=0;i<originalArray.length;i++){
			String[] sortedArraySplit = sortedArray[i].split(" "); //splits the array into two components
			//the first is the sorted word signature and the second is its original position before it was sorted
			
			
			String line = originalArray[Integer.parseInt(sortedArraySplit[1])] + " "; //line to be printed 
			//uses the number given from the sortedArray to map to its equivalent in the original array
			
			if(i+1 < originalArray.length ){ //must check to avoid out of bound exception
				String[] sortedArraySplit2 = sortedArray[i+1].split(" "); // splits the next entry on the array
				if( !(sortedArraySplit[0].equals(sortedArraySplit2[0])) ) //checks if the next entry is not equal if so add a new line character
					line = line + "\n";
			}
			
			System.out.print(line); //print the line
		}
	}
	
	//adds number markers to each element in the arrray
	public static String[] addPositionMarkers(String[] fixedArray){
		for(int i=0;i<fixedArray.length;i++) 
			fixedArray[i] +=" "+i;
		return fixedArray;
	}
	//returns array with all elements marked in ascending order. example "bob 1","ryan 2","james 3" and so on.
	//markers are used later for mapping new sorted array to original unsorted array.
	
}
