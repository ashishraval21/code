package a_arrays_and_strings;

import java.util.Scanner;

/***
 * Assume you have a method isSubstring which checks if one word is a substring of
another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
 * @author ashish
 *
 */
public class Question7 {
	
	static boolean isRotation(String str1 , String str2) {
		int length = str1.length();
		if(length == str2.length() &&  length > 0) {
			str1+=str1;
			return str1.contains(str2);
		}
		return false;
	}

	public static void main(String[] args) {
		String s1, s2;
		s1 = "apple";
		s2 = "ple";
		
System.out.println( isRotation(s1, s2));
	}

}
