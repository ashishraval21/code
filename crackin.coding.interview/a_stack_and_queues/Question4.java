package a_stack_and_queues;

import java.util.Arrays;
import java.util.Stack;

/***
 * Tower of Hanoi
 * 
 * @author ashish
 *
 */
public class Question4 {

	private Stack<Integer> disks;
	private int index;

	public Question4(int i) {
		disks = new Stack<Integer>();
		index = i;
	}

	public int index() {
		return index;
	}

	void moveTopTo(Question4 t){
		int top = disks.pop();
		t.disks.add(top);
		System.out.println("Move disk" + top + " from " + index() +
				" to " + t.index());
	}

	void moveDisks(int n, Question4 dest, Question4 buffer) {
		if (n > 0) {
			moveDisks(n - 1, buffer, dest);
			moveTopTo(dest);
			buffer.moveDisks(n - 1, dest, this);
		}

	}

	public static void main(String[] args) {
		int nDisks = 5;
		Question4[] towers = new Question4[3];
		for (int i = 0; i < 3; i++)
			towers[i] = new Question4(i);

		for (int i = nDisks; i > 0; i--)
			towers[0].disks.add(i);
		
		
		towers[0].moveDisks(nDisks, towers[2], towers[1]);
		
		
		System.out.println(Arrays.toString(towers[2].disks.toArray()));
		

	}

}
