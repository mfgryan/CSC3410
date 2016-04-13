
public class Calculator {
	
	//takes an and variable array and calculates using stack
	//variable must be given but it might not be used if not in expression
	public static void calculate(String[] input,int x){
		expressionTree.operandStack.removeAllElements();
		
		for(int i = 0;i<input.length;i++){
			String currentChar = input[i];
			if(currentChar.equals("") || currentChar == null){
				continue;
			}
			if(TreeParse.checkOperand(currentChar)){
				expressionTree.operandStack.push(currentChar);
			}else{
				checkOp(currentChar,x); //method that performs stack operations
			}
		}
		System.out.println(expressionTree.operandStack.peek());
	}
	
	//does an operation depending on the symbol
	//takes the symbol and the possible variable x
	//operates on top two stack elements unless unary
	public static void checkOp(String currentChar,int x){
		int opA;
		int opB;
		int c;
		
		if(currentChar.equals("+")){
			try{
				opA = Integer.parseInt((String) expressionTree.operandStack.peek());
			}catch(Exception e){
				opA = x;
			}
			
			expressionTree.operandStack.pop();
			
			try{
				opB = Integer.parseInt((String) expressionTree.operandStack.peek());
			}catch(Exception e){
				opB = x;
			}
			
			expressionTree.operandStack.pop();
			
			c = opB+opA;
			expressionTree.operandStack.push(c+"");
		}else if(currentChar.equals("-")){
			try{
				opA = Integer.parseInt((String) expressionTree.operandStack.peek());
			}catch(Exception e){
				opA = x;
			}
			
			expressionTree.operandStack.pop();
			
			try{
				opB = Integer.parseInt((String) expressionTree.operandStack.peek());
			}catch(Exception e){
				opB = x;
			}
			expressionTree.operandStack.pop();
			
			c = opB-opA;
			expressionTree.operandStack.push(c+"");
		}else if(currentChar.equals("*")){
			try{
				opA = Integer.parseInt((String) expressionTree.operandStack.peek());
			}catch(Exception e){
				opA = x;
			}
			
			expressionTree.operandStack.pop();
			
			try{
				opB = Integer.parseInt((String) expressionTree.operandStack.peek());
			}catch(Exception e){
				opB = x;
			}
			expressionTree.operandStack.pop();
			
			c = opB*opA;
			expressionTree.operandStack.push(c+"");
		}else if(currentChar.equals("/")){
			try{
				opA = Integer.parseInt((String) expressionTree.operandStack.peek());
			}catch(Exception e){
				opA = x;
			}
			
			expressionTree.operandStack.pop();
			
			try{
				opB = Integer.parseInt((String) expressionTree.operandStack.peek());
			}catch(Exception e){
				opB = x;
			}
			expressionTree.operandStack.pop();
			
			c = opB/opA;
			expressionTree.operandStack.push(c+"");
		}else if(currentChar.equals("%")){
			try{
				opA = Integer.parseInt((String) expressionTree.operandStack.peek());
			}catch(Exception e){
				opA = x;
			}
			
			expressionTree.operandStack.pop();
			
			try{
				opB = Integer.parseInt((String) expressionTree.operandStack.peek());
			}catch(Exception e){
				opB = x;
			}
			expressionTree.operandStack.pop();
			
			c= opB%opA;
			expressionTree.operandStack.push(c+"");
		}else if(currentChar.equals("_")){
			try{
				opA = Integer.parseInt((String) expressionTree.operandStack.peek());
			}catch(Exception e){
				opA = x;
			}
			
			expressionTree.operandStack.pop();
		
			c = opA*-1;
			expressionTree.operandStack.push(c+"");
		}else{
			try{
				opA = Integer.parseInt((String) expressionTree.operandStack.peek());
			}catch(Exception e){
				opA = x;
			}
			
			expressionTree.operandStack.pop();
			
			c = opA;
			
			expressionTree.operandStack.push(c+"");
		}
			
	}
	//top two elements have now been operated on
}
