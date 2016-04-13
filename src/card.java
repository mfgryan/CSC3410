/* Card.java
 * Author: Ryan Henao
 * Class: CSC 3410 MW 1:30-2:45
 * Date: 9/9/2013
 * 
 * 1. Purpose: This program was created to initialize a deck of 52 cards, 
 * shuffle the deck at least 20 times, 
 * and print the old deck and the new deck of cards.
 * 
 * 2. Solution: The solution to the problem was to create three methods, 
 * one to initialize the deck, one to shuffle the deck and one to print the deck.
 * The first method InitializeDeck uses a nested for loop and an array to populate the Vector.
 * The second method shuffleDeck takes two parameters, a deck of type Vector<String> and a shuffle number of type int. 
 * The algorithm used by this method is a loop that randomly swaps cards (Fisher-Yates shuffle variation). 
 * The loop iterates through the Vector and each card in the deck gets swapped with another randomly chosen card. 
 * (Some cards may be swapped more than once or with themselves which is why it is shuffled at least 20 times).
 * 
 * 3. The data structures used in the program are Vectors and Arrays.
 * 
 * 4. To use the program you must initialize a deck using the InitializeDeck method, 
 * shuffle the deck using the shuffleDeck method, 
 * and print the deck using the printDeck method.
 * The output is the old deck and the new shuffled deck.
 * 
 * 5. This program consists of one class (cards.java) which carries out all of the methods 
 */
import java.util.*;
public class card {
	
	//main method which executes the three methods required for this program
	public static void main(String args[]){
		
		Vector<String> myOldDeck =  initializeDeck(); // original deck before shuffling
		printDeck(myOldDeck); // print out the Old deck
		
		System.out.println("\n\n\n"); //add some lines in between for readability on the console
		
		Vector<String> myNewDeck = shuffleDeck(myOldDeck,20); // new deck that is now shuffled
		printDeck(myNewDeck); // print out the New deck
		
	}
	
	//takes no parameters and is called in the beginning to create a new deck
	public static Vector<String> initializeDeck(){
		Vector<String> cards = new Vector<String>(52);
		
		String[] number = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"}; //all possible card numbers
		String[] suit = {"Hearts","Clubs","Spades","Diamonds"}; //all possible suits
		
		//creates each card in the deck with the outer loop handling each suit and the inner handling all numbers
		for(int i = 0;i < suit.length;i++){
			for(int j = 0; j < number.length;j++){
				cards.addElement(number[j] + " of " + suit[i]);
			}
		}	
		return cards;	
	}
	//returns a new 52 deck card vector with all cards in order
	
	//takes two parameters cards Vector and numOfShuffles int
	//uses these parameters to shuffle the given Vector
	public static Vector<String> shuffleDeck(Vector<String> cards,int numOfShuffles){
		
		Random generator = new Random();
		
		//outer for loop runs the shuffle 20 times
		for(int i = 0;i<numOfShuffles;i++){
			int count = 0;
			
			//inner enhanced for loop is used to iterate through the Vector
			for(String string: cards){
				//for each element a random number is generated 0-51
				int randIndex = generator.nextInt(52);
				String tempString = string;
				
				//the current element is set to the randomly chosen element
				cards.set(count, cards.get(randIndex));
				//the randomly chosen element is set to the current element
				cards.set(randIndex, tempString);
				
				//the card has now been swapped with another random card
				count++;
			}
		}	
		return cards;
	}
	//returns a shuffled deck
	
	//takes a deck Vector and prints it
	public static void printDeck(Vector<String> cards){
		//enhanced for loop prints each element in the deck
		for(String string: cards)
			System.out.println(string);
	}
}
