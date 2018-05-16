package a_arrays_and_strings;

import java.util.Arrays;

/**
 * 
 * Write a method to replace all spaces in a string with ‘%20’.
 * 
 * @author ashish
 *
 */
public class Question5 {

	static String getUpdatedStringWithReplacingValue(String str, String replaceValue) {
		if(str == null || replaceValue == null)
			return "";
		String[] arr = str.split(" ");
		if(arr.length <=1 )
			return str;
			
		str = "";
		int i = 0;
		for (String value : arr) {

			str += value;
			if (i != arr.length-1) {
				str += replaceValue;
				i++;
			}
		}
		return str;
	}
	
	// replacing value is '%20'.
	static char[] updatedStringWithReplacedvalue(char[] str) {
		int length = str.length;
		int countSpace = 0;
		for (int i =0; i< length; i++) {
			if(str[i] == ' ')
				countSpace++;
			
		}
		
		int newLength = length + ( countSpace * 2);
		// increase array size to new length and copy previous array.
		str = Arrays.copyOf(str, newLength+1);
		str[newLength] = '\0';
		
		for(int i = length - 1; i >= 0; i--) {
			if(str[i]==' ') {
				str[newLength -1] = '0';
				str[newLength -2] = '2';
				str[newLength -3] = '%';
				newLength-=3;
			}else {
				str[newLength - 1] = str[i];
				newLength--;
			}
		}
		
		return str;
		
	}
	
	

	public static void main(String[] args) {
		
		String abc = "Hello World ! Java";
		System.out.println( getUpdatedStringWithReplacingValue(abc, "%20"));
		
		System.out.println( updatedStringWithReplacedvalue(abc.toCharArray()));

	}

}
 