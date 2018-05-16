package a_arrays_and_strings;

/**
 * Implement an algorithm to determine if a string has all unique characters. What if you
	can not use additional data structures?
 * 
 * @author ashish
 *
 */
public class Question1 {
	
	static boolean isUniqueCharacter(String str) {
		boolean[] charCheck = new boolean[256];
		for( char c : str.toCharArray())
		{
			if(charCheck[c])
				return false;
			charCheck[c] = true;
		}
		return true;
	}
	

	public static void main(String[] args) {
		
		System.out.println(isUniqueCharacter("ABCC"));
	}

}
