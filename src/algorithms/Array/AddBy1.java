package algorithms.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class AddBy1 {

	public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		Stack<Integer> stack = new Stack();

		for (int i = 0; i < A.size(); i++) {
			//System.out.println(A.get(i));
			stack.push(A.get(i));
		}
		A.clear();
		boolean lastItem = false;
		boolean isLast = true;
		while (!stack.isEmpty()) {
			
			Integer top = stack.pop();
			if(isLast) {
				if(top + 1  == 10) {
					A.add(0, 0);
					lastItem = true;					
				}
				else {
					A.add(0,top+1);
				}
				
				isLast = false;
			}
			else if( lastItem ) {
				if(top + 1  == 10) {
					A.add(0, 0);
					lastItem = true;					
				}
				else {
					A.add(0,top+1);
					lastItem =false;
				}
				
			}else {
				A.add(0, top);
			}
			
		if(stack.empty() && lastItem) {
			A.add(0, 1);
		}
			
		}
	
		return A;

	}

	public static void main(String[] args) {
		ArrayList<Integer> a= new ArrayList<>();
		a.add(0);;
		System.out.println(Arrays.toString(a.toArray()));
		System.out.println(Arrays.toString(plusOne(a).toArray()));
		;

	}

}
