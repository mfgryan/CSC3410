
public class postFix {
	//takes a string and returns it in postfix array format
	public static String[] convertPost(String string) {
		int index = 0;
		String[] result = new String[string.length()+20];
		for(int x = 0;x<result.length;x++){
			result[x]="";
		}
		//assuming input string is already error checked and has had spaces removed
		for(int i = 0;i<string.length();i++){
			String currentChar = string.substring(i,i+1);
			String topOfStack = "";
			
			if(!expressionTree.operatorStack.empty()){
				topOfStack  = (String) expressionTree.operatorStack.peek();
			}
			
			if(TreeParse.checkOperand(currentChar)){
				result[index]+=currentChar;
				//result+=currentChar;
			}else{
				index++;
				if(expressionTree.operatorStack.empty()){
					expressionTree.operatorStack.push(currentChar);
				}else if(precedenceCheck(currentChar, topOfStack)){
					expressionTree.operatorStack.push(currentChar);
				}else{
					while(!expressionTree.operatorStack.empty() && !precedenceCheck(currentChar, topOfStack) && !topOfStack.equals("(")){
						result[index]+=topOfStack;
						expressionTree.operatorStack.pop();
						if(!expressionTree.operatorStack.empty())
							topOfStack = (String) expressionTree.operatorStack.peek();
					}
					
					if(currentChar.equals(")"))
						expressionTree.operatorStack.pop();
					else
						expressionTree.operatorStack.push(currentChar);
				}
				index++;
			}
			
		}
		if(!result[index].equals(null))
			index++;
		while(!expressionTree.operatorStack.empty()){
			result[index]+=expressionTree.operatorStack.peek();
			//result+=expressionTree.operatorStack.peek();
			expressionTree.operatorStack.pop();
			index++;
		}
		return result;
	}
	//result is now an array with each element representing one char or number
	//also is in postfix
	
	// returns true if currentChar is higher on precedence than topOfStack
	public static boolean precedenceCheck(String currentChar, String topOfStack){
		int curChar = 0;
		int stackChar = 0;
		
		//give precedence and compare
		switch(currentChar){
		case "(": curChar = 4;
			break;
		case "_": curChar = 3;
			break;
		case "&": curChar = 3;
			break;
		case "*": curChar = 2;
			break;
		case "/": curChar = 2;
			break;
		case "%": curChar = 2;
			break;
		case "+": curChar = 1;
			break;
		case "-": curChar = 1;
			break;
		}
		
		switch(topOfStack){
		case "_": stackChar = 3;
			break;
		case "&": stackChar = 3;
			break;
		case "*": stackChar = 2;
			break;
		case "/": stackChar = 2;
			break;
		case "%": stackChar = 2;
			break;
		case "+": stackChar = 1;
			break;
		case "-": stackChar = 1;
			break;
		case "(": stackChar = 0;
		break;
	}
		
	if(curChar > stackChar)
		return true;
	return false;
	}
}
