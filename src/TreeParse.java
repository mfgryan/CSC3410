
public class TreeParse {

	//expression must be postfix by this point
	//takes input as postfix string and converts into tree
	public static void parseLine(String input){
		for(int i = 0;i<input.length();i++){
			
			String currentChar = parseChar(input,i);
			i+=currentChar.length()-1; //skip past all integer characters if there are any
			
			if(checkOperand(currentChar)){
				expressionTree.treeStack.push(new Node(currentChar));
			}else if(checkOperator(currentChar)){
				Node node = new Node(currentChar);
				
				if(!expressionTree.treeStack.empty()){
					node.rightNode = (Node) expressionTree.treeStack.peek();
					node.rightNode.parentNode = node;
					expressionTree.treeStack.pop();
				}
				if(!expressionTree.treeStack.empty()){
					node.leftNode = (Node) expressionTree.treeStack.peek();
					node.leftNode.parentNode = node;
					expressionTree.treeStack.pop();
				}
				
				
				expressionTree.treeStack.push(node);
			}
		}
	}
	//top of stack should have entire tree
	
	//takes an input and returns true if its an operand
	public static boolean checkOperand(String inputChar){
		char tempChar = inputChar.charAt(0);
		
		if(tempChar >= 48 && tempChar <= 57)
			return true;
		else if(tempChar == 'x' || tempChar == 'X')
			return true;
		
		return false;
	}
	
	//returns true if input is an operator
	public static boolean checkOperator(String inputChar){
		char tempChar = inputChar.charAt(0);
		
		switch(tempChar){
			case '+': return true;
			case '-': return true;
			case '*': return true;
			case '/': return true;
			case '%': return true;
			case '&': return true;
		}
		
		return false;
	}
	
	//takes an input and checks if its a number or not
	public static String parseChar(String input, int i){
		String resultString = "";
		while(i < input.length()){
			char currentChar = input.charAt(i);
			if(currentChar >= 48 && currentChar <= 57){
				resultString+=currentChar;
				i++;
			}
			else{
				break;
			}
		}
		if(resultString == "")
			return input.substring(i,i+1);
		return resultString;
	}
	//returns a string of length 1 or longer if big number
}
