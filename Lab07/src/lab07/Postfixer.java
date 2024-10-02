package lab07;

import java.util.*;

//Extension of Chapter 14.4 Case Study: Expression Evaluator

public class Postfixer {


	/**
	*  Determines if the first operator has same or greater
    *  precedence than the second
	*
	* @param op1 the first operator
	* @param op2 the second operator
	* @return the boolean result
	*/
	private static boolean hasPrecedence(String op1, String op2) {
	    
		return opToPrcd(op1)>=opToPrcd(op2);
		
	}


	/**
	* Converts an operator to its precedence priority
	*
	* We expect you to be able to handle +, -, *, /, ^, and (
	* (why don't you need ")" as well? see algorithm in part 4)
	*
	* The order of these is as follows:
	*    ^, * and /, + and -, (
	*
	* @param op a string representing an operator, e.g. "+" or "-"
	* @return an integer value reflecting its precedence
	*/
	private static int opToPrcd(String op) {
	    	
		switch(op) {
		case "^":
			return 4;
		case "*":
			return 3;
		case "/":
			return 3;
		case "+":
			return 2;
		case "-":
			return 2;
		case "(":
			return 1;
		default:
			return 0;
		}
		
	}

	/**
	* determines if the input token is an operator
	*
	* @param token the string token to check
	* @return a boolean reflecting the result
	*/
	private static boolean isOperator(String token) {
		int val = opToPrcd(token);
		if(token.equals(")")) {
			return true;
		}
		return (val>0);
	}

	/**
    * Evaluates an expression
    *
    * NOTE Beware the order of pop and evaluation when receiving operand1
    * and operand2 as input.
    *
    * @param operand1 the first operand
    * @param operator the operator to apply
    * @param operand2 the second operand
    * @return a double expressing the result
    * @throws IllegalArgumentException if operator passed is not one of
    *  "+", "-", "*", "/", or "^"
    *
	*/
	private static double evaluate(double operand1, String operator, double operand2){
		
		switch(operator) {
		case "^":
			return Math.pow(operand1,  operand2);
		case "*":
			return operand1*operand2;
		case "/":
			return operand1/operand2;
		case "+":
			return operand1+operand2;
		case "-":
			return operand1-operand2;
		default:
			throw new RuntimeException("illegal operator " + operator);
		}
		
	}


	/**
	* give a description of the purpose of this method
	* @param line fill in
	* @return fill in
	*/
	public static double infixEvaluator(String line){
		
		StringSplitter data = new StringSplitter(line);
		
		Stack<String> operators = new Stack<String>();  
		Stack<Double> operands = new Stack<Double>();
		
		
//	1. Scan the input string (infix notation) from left to right. One pass is sufficient, take  one token at a time. Each type of token is treated differently: 
		
		while(data.hasNext()) {
			String top = data.next();
		
//		1.1. number: push it onto the operand stack. 
			
			if(!isOperator(top)) {
				operands.push(Double.parseDouble(top));
			}
			
//		1.2. a left parenthesis: push it onto the operator stack. 
			
			else if(top.equals("(")) {
				operators.push(top);
			}
			
//		1.3. a right parenthesis: 
			
			else if(top.equals(")")) {
				
			
//			1.3.1. while the thing on top of the operator stack is not a left parenthesis
				
				while(!operators.peek().equals("(")) {
					
				
				
//				1.3.1.1. pop an operator from the operator stack, pop two operands from the operand stack, apply the operator to the operands, in the correct order, push the result onto the operand stack. 
											
					double num2 = operands.pop();
					String op = operators.pop();
					double num1 = operands.pop();
					
					double val = evaluate(num1, op, num2);
					operands.push(val);
					
				}
					
//			1.3.2. pop the left parenthesis from the operator stack and discard it 
		
				operators.pop();
				
			}
//		1.4. an operator (call it current operator): 
				
			else if (isOperator(top)) {
				
//		1.4.1. while the operator stack is not empty, and the top thing on the operator  stack has the same or greater precedence as the current operator [“(“ should have the smallest precedence as is suggested in the code comments]
				
				while(!operators.isEmpty() && hasPrecedence(operators.peek(), top)) {
				
//			1.4.1.1. pop an operator from the operator stack, pop two operands from the operand stack, apply the operator to the operands, in the correct order, push the result onto the operand stack
					
					double num2 = operands.pop();
					String op = operators.pop();
					double num1 = operands.pop();
					
					double val = evaluate(num1, op, num2);
					operands.push(val);
					
				}
				
//		1.4.2. push the current operator onto the operator stack
				
				operators.push(top);
				
			}
				
		}
//
//	2. (After you have traversed the entire StringSplitter queue) While the operator stack is not empty:
		
		while(!operators.isEmpty()) {
		
//		2.1. pop an operator from the operator stack, pop two operands from the operand  stack, apply the operator to the operands, in the correct order, push the  result onto the operand stack 
			
			double num2 = operands.pop();
			String op = operators.pop();
			double num1 = operands.pop();
			
			double val = evaluate(num1, op, num2);
			operands.push(val);
			
		}
		
		
//	3. At this point the operator stack MUST be empty, and the operand stack MUST have  a single value, which is the final result.
		
		if(!operators.isEmpty() && operands.size()!=1) {
			throw new RuntimeException("Shunting Yard Went Wrong!");
		}
		
//	4. pop that value and return it. 

		return operands.pop();

	}

	/**
	* give a description of the purpose of this method
	* @param line fill in
	* @return fill in
	*/
	public static String toPostfix(String line){
		
		StringSplitter data = new StringSplitter(line);
		
		Stack<String> operators = new Stack<String>();
		
		String PostMalone = new String("");
		
//		1. 	Scan the input string (infix notation) from left to right (one pass)
		
		while(data.hasNext()) {
			String top = data.next();
		
//		2. 	If the current token is an operand
			
			if(!isOperator(top) && !top.equals("(") && !top.equals(")")) {
		
//			2.1. append it to the postfix string.
				
				PostMalone += top;
				
			}
		
//		
		
//		4. 	If the current token is a left parenthesis 
				
			else if(top.equals("(")) {
		
//			4.1. push it onto the stack.
					
					operators.push(top);
					
				}
		
//		5. 	If the current token is a right parenthesis
				
			else if(top.equals(")")) {
					
		
//			5.1. Pop all operators down to the most recently scanned left parenthesis and append them to the postfix string.
				
			
				
					while(!operators.isEmpty() && !operators.peek().equals("(")) {
						
						
						PostMalone += operators.pop();
						
					
					}
		
//			5.2. Pop the corresponding left parenthesis and discard this pair of parentheses
					
					if(!operators.isEmpty()) {
						operators.pop();
						
					}

				}
//3. 	If the current token is an operator (call it current operator).
			
			else if (isOperator(top) && !operators.isEmpty()) {
		
//			3.1. Pop from the operator stack and append to the postfix string every operator on the stack that
				
				
		
//		              3.1.1.  is above the most recently scanned left parenthesis, and
				
				while(!top.equals("(") && hasPrecedence(operators.peek(), top)) {
					PostMalone += operators.pop();
				}
		
//		              3.1.2. has precedence higher than to that of the current operator 
		
//		    3.2. Push the current operator onto the stack.
					
					operators.push(top);
				
			}
			
		}
		
		return PostMalone; // placeholder
	}


	public static void main(String[] args){

        if (infixEvaluator("10 + 2") != 12)
            System.err.println("test1 failed --> your answer should have been 12");

        if (infixEvaluator("10 - 2 * 2 + 1") != 7)
            System.err.println("test2 failed --> your answer should have been 7");

        if (infixEvaluator("100 * 2 + 12") != 212)
            System.err.println("test3 failed --> your answer should have been 212");

        if (infixEvaluator("100 * ( 2 + 12 )") != 1400)
            System.err.println("test4 failed --> your answer should have been 1400");

        if (infixEvaluator("100 * ( 2 + 12 ) / 14") != 100)
            System.err.println("test5 failed --> your answer should have been 100");


        System.out.println("Lab Testing Done!!!");

        /* uncomment the below lines for assignmemt */
		 if (!toPostfix(new String("(4+5)")).equals("45+"))
		     System.err.println("test1 failed --> should have been 45+ ----> You printed: " + toPostfix(new String("(4+5)")));

		if (!toPostfix(new String("((4+5)*6)")).equals("45+6*"))
		     System.err.println("test2 failed --> should have been 45+6* ----> You printed: " + toPostfix(new String("((4+5)*6)")));

		 if (!toPostfix(new String("((4+((5*6)/7))-8)")).equals("456*7/+8-"))
		     System.err.println("test3 failed --> should have been 456*7/+8- ----> You printed: " + toPostfix(new String("((4+((5*6)/7))-8)")));

		 if (!toPostfix(new String("((4+5*(6-7))/8)")).equals("4567-*+8/"))
		     System.err.println("test4 failed --> should have been 4567-*+8/ ----> You printed: " + toPostfix(new String("((4+5*(6-7))/8)")));

		 if (!toPostfix(new String("(9+(8*7-(6/5^4)*3)*2)")).equals("987*654^/3*-2*+"))
		     System.err.println("test5 failed --> should have been 987*654^/3*-2*+ ----> You printed: " + toPostfix(new String("(9+(8*7-(6/5^4)*3)*2)")));

		 if (!toPostfix(new String("((4*3)/12^6)")).equals("43*126^/"))
		     System.err.println("test6 failed --> should have been 43*126^/ ----> You printed: " + toPostfix(new String("((4*3)/12^6)")));
		 
		 if (!toPostfix(new String("((4*3)/6^8*(4-2+3)*18)")).equals("43*68^/42-3+*18*"))
		     System.err.println("test7 failed --> should have been 43*68^/42-3+*18* ----> You printed: " + toPostfix(new String("((4*3)/6^8*(4-2+3)*18)")));

         System.out.println("Assignment Testing Done!!!");


	}

}
