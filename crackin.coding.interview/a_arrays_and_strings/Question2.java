package a_arrays_and_strings;

/**
 * Write code to reverse a C-Style String. (C-String means that “abcd” is
 * represented as five characters, including the null character.)
 * 
 * @author ashish
 *
 */
public class Question2 {

	static char[] getC_StyleString(char[] str) {
		int j =0 , i = 0;
		// must needed becuase in str array some time string have less character than a size of an array.
		while(j != str.length && str[j] != '\u0000')
			j++;
		j--;
		while (i < j) {
			char c = str[i];
			str[i] = str[j];
			str[j] = c;
			i++;
			j--;
		}

		return str;
	}

	public static void main(String[] args) {
		System.out.println(getC_StyleString(new char[10]));

		char[] charArray = new char[10];
		String tempString = "abc";
		for (int i = 0; i < tempString.length(); i++)
			charArray[i] = tempString.charAt(i);
		
		System.out.println(getC_StyleString(charArray));

		tempString = "";
		charArray = new char[5];
		for (int i = 0; i < tempString.length(); i ++)
			charArray[i] = tempString.charAt(i);
		System.out.println(getC_StyleString(charArray)); 
		
		
		tempString = "abcde";
		charArray = new char[5];
		for (int i = 0; i < tempString.length(); i ++)
			charArray[i] = tempString.charAt(i);
		System.out.println(getC_StyleString(charArray));	

		System.out.println("All tests completed");
		
	}

}
