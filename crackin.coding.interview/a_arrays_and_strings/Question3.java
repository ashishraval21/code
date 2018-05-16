package a_arrays_and_strings;

/**
 * Design an algorithm and write code to remove the duplicate characters in a
 * string without using any additional buffer. NOTE: One or two additional
 * variables are fine. An extra copy of the array is not.
 * 
 * @author ashish
 *
 */
public class Question3 {

	static char[] removeDuplicateCharacterFromString(char[] str) {
		if (str == null)
			return null;

		if (str.length < 2)
			return null;

		int tail = 1;
		for (int i = 1; i < str.length; i++) {
			int j;

			for (j = 0; j < tail; j++) {

				if (str[i] == str[j]) {
					break;
				}

			}

			if (j == tail) {
				str[tail] = str[i];
				tail++;
			}
		}

		str[tail] = 0;

		return str;
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicateCharacterFromString("ABCBECEDA".toCharArray()));

	}

}
