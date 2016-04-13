/*	Ryan Henao CSC 3410 1:30-2:45 9/25/2013
 * 	program name - anagram.java
 *	1. The purpose of this program is to take a text file of 50 words or less and find every word that is an anagram of another word.
 *	The words that are matched are all printed on the same line. It also can handle empty files, incorrect file paths,
 *	files larger than 50 words and words longer than 12 characters.
 *	2. The solution to this problem is done with several steps.
 *	First begin by turning the file into an array containing each word.
 *	Next check if the program needs to exit because of an empty file using the checkForExit method.
 *	Next if the file is valid the array is cloned so that changes can be made to one while not affecting the original.
 *	The next step is to sort each word in the array to create a signature. This is done by using the formatWords method.
 *	The next step is to add a position marker on each word so that when the array is sorted the original positions are still there.
 *	Next the array itself is sorted so that each all the signatures are in order.
 *	The final step is to print the results and that is done by using the position markers to map the new sorted anagram array to 
 *	the original array.
 *	The main algorithm used is Insertion sort which is used to sort each word in the array and then the entire array it self
 * 	3.	The data structures used in this solution are Arrays.
 * 	4.	In order to use this program enter a valid text file with 50 or less words and it will return all of the anagram matches.
 * 	5.	There are four classes used by this program. anagram is the main controller class and calls the others.
 * ReadFile is responsible for opening the file and returning an array.
 * InsertionSort takes an array of strings and returns the sorted result
 * arrayOperations performs all the important operations on the array including adding the markers,
 * formatting the strings properly, and printing the results.
 */
import java.util.Scanner;
public class anagram {	
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a file name");
		String file = input.nextLine();
		
		String[] fileArray = ReadFile.readFile(file); //calls the ReadFile class which returns an array with each word
		
		checkForExit(fileArray); //checks if the file is valid and if not runs system.exit
		
		String[] fileArrayToChange = fileArray.clone(); //makes a copy of the array so that one can be changed
		String[] sortedWords = arrayOperations.formatWords(fileArrayToChange); //sorts each word in the array to create signatures
		String[] markedWords = arrayOperations.addPositionMarkers(sortedWords);//marks each word with its index in ascending order
		String[] sortedArray = InsertionSort.sort(markedWords); //returns the array that has been sorted
		
		arrayOperations.printAnagrams(fileArray, sortedWords); //takes two parameters (the original array and the sorted one) and prints results
	}
	
	//checks for a null array, larger than 50 array, and 0 length array
	public static void checkForExit(String[] wordsArray){
		if(wordsArray == null)
			System.exit(0); //stops the program
		else if(wordsArray.length == 0){
			System.out.println("the input file is empty");
			System.exit(0);	//stops the program
		}
		
		int newLength = wordsArray.length;
		for(int i = 0; i< wordsArray.length;i++){
			if(wordsArray[i].length() > 12) //removes words over 12 characters long from the total length
				newLength--;
		}
		
		if(newLength > 50){
			System.out.println("there are more than 50 words in the input file");
			System.exit(0);	//stops the program
		}	
	}
}
