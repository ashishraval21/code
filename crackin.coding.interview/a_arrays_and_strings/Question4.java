package a_arrays_and_strings;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * Write a method to decide if two strings are anagrams or not.
 * 
 * @author ashish
 *
 */

public class Question4 {

	static boolean isAnagram(String str1, String str2) {

		if (str1 == null || str2 == null)
			return false;
		if (str1.length() != str2.length())
			return false;

		char[] str12 = str1.toCharArray();
		char[] str22 = str2.toCharArray();

		Arrays.sort(str12);
		Arrays.sort(str22);

		return Arrays.equals(str12, str22);
	}

	static boolean isAnagramUsingHashMap(String str1, String str2) {
		if (str1 == null || str2 == null)
			return false;
		if (str1.length() != str2.length())
			return false;

		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			int value = 0;
			char str1_c = str1.charAt(i);
			if (map.containsKey(str1_c))
				value = map.get(str1_c);
			map.put(str1_c, ++value);

			value = 0;
			char str2_c = str2.charAt(i);
			if (map.containsKey(str2_c))
				value = map.get(str2_c);
			map.put(str2_c, --value);
		}

		for (Integer i : map.values()) {
			if (i != 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		String a = "ABC";
		String b = "CAB";
		System.out.println("String a and b isAnagram : " + isAnagram(a, b));
		
		
		System.out.println("String a and b isAnagram : " + isAnagramUsingHashMap(a, b));
		

	}

}
