package a_stack_and_queues;

import java.util.ListIterator;
import java.util.Stack;

/***
 * sorted stack
 * @author ashish
 *
 */
public class Question6 {
	
	static Stack<Integer> stack = new Stack<>();
	
	
static void printStack() {
		
		ListIterator<Integer> li = stack.listIterator();
		while(li.hasNext())
			li.next();
		
		while(li.hasPrevious())
			System.out.print(li.previous()+" ");
	
	}

		static void sortedStack(int value){
			if(stack.isEmpty() || stack.peek() < value) {
				stack.push(value);
				return;
			}
			int pop = stack.pop();
			sortedStack(value);
			stack.push(pop);
			
		}


	static void sortStack() {
		if(stack.size() > 0 ){
			int value = stack.pop();
			sortStack();
			sortedStack(value);
		}
	}

	public static void main(String[] args) {
	
		stack.push(12);
		stack.push(-12);
		stack.push(120);
		stack.push(-120);
		stack.push(2);
		stack.push(10);
		stack.push(-122);
		printStack();
		System.out.println();
		sortStack();
		printStack();
		
		
	}

}
