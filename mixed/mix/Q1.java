package mix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] values = new int[n];
		int[] temp = new int[n];

		for (int i = 0; i < n; i++) {
			values[i] = sc.nextInt();
		}
		Arrays.fill(temp, -1);
		Stack<Integer> stack = new Stack<Integer>();
		int curr, front;
		stack.push(0);
		for (int i = 1; i < n; i++) {
			curr = values[i];
			if (!stack.isEmpty()) {
				int stackSize = stack.size();
				for (int j = 0; j < stackSize; j++) {
					front = stack.pop();
					if (values[front] % curr == 0) {
						temp[front] = curr;
					} else {
						stack.add(front);
					}

				}
				
			}
			stack.add(i);
		}

		for (int i = 0; i < n; i++) {
			System.out.println(temp[i]);
		}

	}

}
