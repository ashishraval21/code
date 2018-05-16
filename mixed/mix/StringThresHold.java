package mix;

public class StringThresHold {

	public static void main(String[] args) {
		String str = "1234567879";
		int thresHold = 10;
		int tempThres = thresHold;
		int sum = 0;
		int i = 0;
		int size = str.length() - 1;
		int count = 0;
		String temp ="";
		while(str.length() != 1) {
			int value = Integer.parseInt(str.charAt(i)+"");
			sum+=value;
			
			if(sum > thresHold) {
				temp+= sum;
				thresHold = sum;
				sum =0;
				count++;
				
			}
			
			if(i == size) {
				str = temp + sum;
				size = str.length() - 1;
				i =-1;
				temp = "";
				thresHold = tempThres;
				sum = 0;
				
			}
			
			i++;
		}
		
		
		System.out.println(str);
		
		

	}

}
