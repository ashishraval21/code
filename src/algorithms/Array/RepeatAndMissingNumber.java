package algorithms.Array;

import java.util.ArrayList;
import java.util.List;

public class RepeatAndMissingNumber {
	
	public  static ArrayList<Integer> repeatedNumber(final List<Integer> a) {
	    int t = 0, repeat, missing, diff = 0;
        long diffSq = 0, sum = 0;
        for(int i=0;i< a.size();i++){
            diff = (i + 1) - a.get(i);
            sum = i+1+a.get(i);
            t+= diff;
            diffSq += diff*sum;
            
            System.out.println("diff -> "+ diff +" sum -> "+sum+" t -> "+t+" diffSq -> "+diffSq);

        }
        sum = diffSq/t;
        missing = (int) ((t+sum)/2);
        repeat = (int) ((sum-t)/2);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(repeat);
        list.add(missing);
        return list;
	}

	

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(6);
		list.add(1);
		System.out.println(repeatedNumber(list));

	}

}
