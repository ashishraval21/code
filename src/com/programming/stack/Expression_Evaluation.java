package com.programming.stack;

import java.util.Stack;

import javax.xml.bind.ValidationEvent;

public class Expression_Evaluation {
	
	static boolean precedence(char op1 , char op2) {
		if(op2 == '(' || op2 == ')')
			return false;
		
		if( (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-') ) 
			return false;
		
		return true;
		
	}
	
	// A utility method to apply an operator 'op' on operands 'a' 
    // and 'b'. Return the result.
    public static int applyOp(char op, int b, int a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }	
	
	static int expressionEvaluationResult(String exp) {
		Stack<Integer> values = new Stack<>();
		Stack<Character> ops = new Stack<>();
		
		char[] tokens= exp.toCharArray();
		int size = exp.length();
		for(int i = 0; i < size; i++) {
			
			if( tokens[i] ==' ') {
				continue;
			}
			// number
			if(tokens[i] >= '0' && tokens[i] <= '9') {
					
				StringBuffer sbf = new StringBuffer();
				
				while(i < size && tokens[i] >= '0' &&
						tokens[i] <= '9')
					sbf.append(tokens[i++]);
			
				values.push(Integer.parseInt(sbf.toString()));
				
			}else if( tokens[i] == '(') {
				ops.push(tokens[i]);
			}
			else if (tokens[i] == ')') {
				
				while (ops.peek() != '(') {
					
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
					
				}
				ops.pop();
				
			}else if(tokens[i] == '*' || tokens[i] == '+' ||
					tokens[i] == '/' ||  tokens[i] == '-' ) {
				
				while(!ops.empty() && precedence(tokens[i], ops.peek())) {
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				}
				ops.push(tokens[i]);
			}
				
			
			
		}
		
		 while (!ops.empty())
	            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
		 
	        return values.pop();
	}
	
 
	public static void main(String[] args) {
		
		System.out.println(expressionEvaluationResult("5 + ( 9 * 7 ) + 4 * 9"));

	}

}
