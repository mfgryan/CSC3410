import java.util.Stack;
import java.util.Vector;

public class CompileFile {
	
	private static Stack<Object> parenthStack = new Stack<Object>();
	private static Stack<Object> bracketStack = new Stack<Object>();
	private static Stack<Object> bracesStack = new Stack<Object>();
	private static Stack<Object> commentStack = new Stack<Object>();
	
	//input is a vector of char arrays to be compiled
	public static void compile(Vector<char[]> inputFile){
		boolean quitStatus = false; //boolean to see if there is an error
		int lineCount = 1;
		for(char[] line: inputFile){
			int charCount = 0;
			//switch statement used to check if current char is a special character
			//if there is a match the appropriate stack method is called
			for(char character: line){
				switch (character){
				case '(':
					setParenthStack(character);
					break;
				case ')':
					setParenthStack(character);
					break;
				case '[':
					setBracketStack(character);
					break;
				case ']':
					setBracketStack(character);
					break;
				case '{':
					setBracesStack(character);
					break;
				case '}':
					setBracesStack(character);
					break;
				case '/': case '*':
					setCommentStack(character,lineCount-1,charCount);
					break;
				default:
					break;
				}
				charCount++;
			}
			quitStatus = checkStacks(lineCount); //check the stacks
			lineCount++;
			if(quitStatus) //if error was found break out of the loop
				break;
		}
		
	}
	//doesn't return anything but after this method is done error/warning messages are set
	
	//parenthesis Stack operations
	private static void setParenthStack(char parenth) {
		if(parenthStack.empty())
			parenthStack.push(parenth);
		else if(parenth == ')' && (char)parenthStack.peek() == '(')
			parenthStack.pop();
		else
			parenthStack.push(parenth);
		
	}
	
	//Braces Stack operations
	private static void setBracesStack(char brace) {
		if(bracesStack.empty())
			bracesStack.push(brace);
		else if(brace == '}' && (char)bracesStack.peek() == '{')
			bracesStack.pop();
		else
			bracesStack.push(brace);
	}
	
	//Brackets Stack operations
	private static void setBracketStack(char bracket) {
		if(bracketStack.empty())
			bracketStack.push(bracket);
		else if(bracket == ']' && (char)bracketStack.peek() == '[')
			bracketStack.pop();
		else
			bracketStack.push(bracket);
	}
	
	//CommentStack operations takes lineCount and charCount inputs as well to check for warnings
	private static void setCommentStack(char comment,int lineCount, int charCount){
		
		char nextChar = match.getVectorOfCharsValue(lineCount, charCount+1);
		char prevChar = match.getVectorOfCharsValue(lineCount, charCount-1);
		
		if(commentStack.empty()){
			if(comment == '*')
				commentStack.push(comment);
			else if(!Character.isDigit(nextChar) && !(nextChar == '/' || nextChar == '*'))
				match.setWarningMessage("Warning with comments on line " + lineCount); //sets the warning message
			else if(!Character.isDigit(nextChar))
				commentStack.push(comment);
		}else{
			// if they are equal pop them
			if(comment == (char)commentStack.peek()) 
				commentStack.pop();
			// only push if its next to the right character or behind the right character
			else if( nextChar == '*' || nextChar == '/' || prevChar == '*' || prevChar == '/') 
				commentStack.push(comment);		
		}
					
		return;
	}
	
	//checks all the stacks, sets the messages, and returns true or false
	private static boolean checkStacks(int lineCount){
		if(!parenthStack.empty()){
			match.setErrorMessage("Error with parenthesis on line " + lineCount +"\n");
			return true;
		}else if(!bracketStack.empty()){
			match.setErrorMessage("Error with brackets on line " + lineCount +"\n");
			return true;
		}else if(!bracesStack.empty()){
			match.setErrorMessage("Error with curly braces on line " + lineCount + "\n");
			return true;
		}else if(!commentStack.empty()){
			if(match.getWarningMessage() == ""){
				match.setErrorMessage("Error with comments on line " + lineCount + "\n");
				return true;
			}
			else{
				commentStack.clear();
			}
		}
		match.setErrorMessage("No errors found. File compiled successfully \n" );
		return false;	
	}
	//boolean set to true if there is an error and false if no error
	//warnings will not set boolean to true and compiler will continue
}
