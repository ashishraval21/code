package com.programming.stack;

import java.util.Stack;

public class INFIX_TO_POSTFIX {

	static boolean isCharacter(char value) {
		if ((value >= 'a' && value <= 'z') || (value >= 'A' && value <= 'Z')) {
			return true;
		}

		return false;
	}

	static int precedenceOfOperator(char value) {
		switch (value) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;

		default:
			return -1;
		}

	}

	static String infixToPostFix(String str) {
		Stack<Character> stack = new Stack<>();
		String result = "";
		for (char c : str.toCharArray()) {
			if (isCharacter(c))
				result += c;
			else if (c == '(')
				stack.push(c);
			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					result += stack.pop();
				}
				if (!stack.isEmpty() && stack.peek() != '(')
					return "Invalid Expression";
				else
					stack.pop();
			} else {

				while (!stack.isEmpty() && precedenceOfOperator(c) <= precedenceOfOperator(stack.peek())) {
					result += stack.pop();
				}
				stack.push(c);
			}
		}

		while (!stack.isEmpty()) {
			result += stack.pop();
		}

		return result;
	}

	public static void main(String[] args) {

		System.out.println(infixToPostFix("(A*B+E)*(C+D)"));
	}

}





