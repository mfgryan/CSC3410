/* match.java   CSC 3410 MW 1:30 - 2:45
 * Author: Ryan Henao
 * Date: 10/30/13 
 * 1.The purpose of this program is to read a file input and to test whether the file is able to compile.
 *   the file will compile if the file contains valid matching brackets, braces, curly braces and comments. 
 * 2.The solution to the problem is to use a stack for each special character (,[,{,/* to test whether they are matched correctly.
 *   The program scans line by line checking the stack at the end of each line.
 *   (special characters have to match on the same line and cannot span multiple lines)
 *   At the end of each line each stack is checked and if the stack is not empty an error is set with the appropriate message.
 *   The program will terminate at this point if an error is found.
 *   Warnings are also checked for at the end of each line but it will not terminate if the error message is set.
 *   The algorithms used in this solution are a method that converts the input file into a vector of char arrays 
 *   so that each line is a char array and the second used is a compileFile method that used a combination of a nested for loop 
 *   and switch statement to check whether the file is able to compile.
 * 3.The three data structures used in this program are Stacks, Vectors, and Char Arrays. 
 * 4.The program is used by giving it a file name and from there if it is a valid file
 *   it will compile, otherwise it will give an invalid file message.
 * 	 The input for this program is straight forward for parenthesis, braces, and brackets, 
 *   but for comments there are many combinations of possible inputs and the compiler handles each differently.
 *   example comment inputs: c = compiles, w = warning, e = error, star = * 
 *   "/" w   "/1" c   "/a" w   "//" c   "///" w   "/a//" w   "//a/a" w   "*" e   "***" e
 *   "star/" e   "star//" e   "/star/" e   "/*" e   "//*" e   "/star star/" c
 *   The output of the program is a message stating if there are any errors
 *   and if there are none the message will say it compiled successfully. 
 *   The message will also give the line of the error and the special character involved.
 *   There is also a possibility of it compiling but also getting a warning message as the output.
 * 5.There are three classes in this program. match.java, ScanFile.java, and CommpileFile.java
 *   match.java is a controller class and has the main method from which it calls methods from the other two classes.
 *   match.java also stores the messages and vectors.
 *   ScanFile.java is used to read the file and return the vector.
 *   CompileFile.java handles all the logic involved in checking whether the file is able to compile.
 *   It is also the file that sets the error/warning messages.
 */
import java.util.Scanner;
import java.util.Vector;

public class match {
	private static String errorMessage;
	private static String warningMessage;
	private static Vector<String> vectorOfLines;
	private static Vector<char[]> vectorOfChars;
	private static Scanner input;
	
	//main method responsible for calling all other methods
	public static void main(String args[]){
		input = new Scanner(System.in);
		setWarningMessage(""); //empty string by default
		setErrorMessage(""); //empty string by default
		
		System.out.println("Please enter a file name: ");
		vectorOfLines = ScanFile.readFile(input.nextLine()); //vector that is returned from ScanFile
		
		//if its empty don't bother compiling
		if(vectorOfLines.size() == 0)
			setErrorMessage("The file is empty"); 
		else if(vectorOfLines.get(0) != null){
			vectorOfChars = convertVector(vectorOfLines); //vector is converted to vector with each element a char array
			CompileFile.compile(vectorOfChars); //compile this file and set the appropriate messages
		}
		
		//print the messages. if no message it prints an empty string
		System.out.print(getErrorMessage()); 
		System.out.print(getWarningMessage());
		
		input.close(); //close scanner
	}
	//input is a vector of strings with each string element representing a single line
	public static Vector<char[]> convertVector(Vector<String> inputVector){
		Vector<char[]> outputVector = new Vector<char[]>();
		for(String string: inputVector)
			outputVector.add(string.toCharArray());
		return outputVector;
	}
	//output is a vector of char arrays each array represents a single line
	
	public static void setErrorMessage(String errorMessage) {
		match.errorMessage = errorMessage;
	}
	
	public static String getErrorMessage() {
		return errorMessage;
	}
	
	public static void setWarningMessage(String warningMessage){
		match.warningMessage = warningMessage;
	}
	
	public static String getWarningMessage() {
		return warningMessage;
	}
	
	//this getter uses a try catch in case the index is out of bounds
	public static char getVectorOfCharsValue(int lineNumber, int charNumber) {
		try{
			return vectorOfChars.get(lineNumber)[charNumber];
		}catch(Exception e){
			return ' ';
		}
		
	}
	//returns the appropriate char and if there is an exception returns a space 
}
