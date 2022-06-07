package com.recursion.basic.string;

public class RemoveCharacter {

	public static void main(String[] args) {
		System.out.println(removeCharacter("baccad", 'a'));
		System.out.println(removeCharacterRecursive("baccad", 'a'));
		System.out.println(removeCharacterRecursive2("baccad", 'a'));
		System.out.println(removeCharacterRecursive3("baccad", 'a'));

		// kunal's way
		skip("", "baccad", 'a');
		System.out.println(skip2("", "baccad", 'a'));
	}

	public static String removeCharacter(String input, char letter) {
		StringBuilder output = new StringBuilder();
		char a[] = input.toCharArray();
		for (int i = 0; i < a.length; i++) {
			if (!(a[i] == letter)) {
				output = output.append(a[i]);
			}
		}
		return output.toString();
	}

	public static String removeCharacterRecursive(String input, char letter) {
		StringBuffer ans = helper(input, letter, 0);
		return ans.toString();
	}

	public static StringBuffer helper(String input, char letter, int index) {
		if (index == input.length()) {
			return new StringBuffer();
		}

		char indexChar = input.charAt(index);
		StringBuffer output = new StringBuffer();
		if (!(indexChar == letter)) {
			output.append(indexChar);
		}

		StringBuffer ans = helper(input, letter, index + 1);
		output = output.append(ans);
		return output;

	}

	public static String removeCharacterRecursive2(String input, char letter) {
		StringBuffer ans = helper2(input, letter);
		return ans.toString();
	}

	public static StringBuffer helper2(String input, char letter) {
		if (input == null || input.length() == 0) {
			return new StringBuffer();
		}

		char indexChar = input.charAt(0);
		StringBuffer output = new StringBuffer();
		if (!(indexChar == letter)) {
			output.append(indexChar);
		}

		StringBuffer ans = helper2(input.substring(1, input.length()), letter);
		output = output.append(ans);
		return output;

	}

	public static String removeCharacterRecursive3(String input, char letter) {
		StringBuffer ans = new StringBuffer();
		helper3(input, letter, ans);
		return ans.toString();
	}

	public static StringBuffer helper3(String input, char letter, StringBuffer ans) {
		if (input.isEmpty()) {
			return new StringBuffer();
		}

		char indexChar = input.charAt(0);
		if (!(indexChar == letter)) {
			ans.append(indexChar);
		}

		helper3(input.substring(1, input.length()), letter, ans);
		return ans;

	}

	static void skip(String p, String up, char letter) {
		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}

		char indexChar = up.charAt(0);
		if (indexChar == letter) {
			skip(p, up.substring(1), letter);
		} else {
			skip(p + indexChar, up.substring(1), letter);

		}
	}

	static String skip2(String p, String up, char letter) {
		if (up.isEmpty()) {
			return p;
		}

		char indexChar = up.charAt(0);
		if (indexChar == letter) {
			return skip2(p, up.substring(1), letter);
		} else {
			return skip2(p + indexChar, up.substring(1), letter);

		}
	}

	static String skip3(String up, char letter) {
		if (up.isEmpty()) {
			return "";
		}

		char indexChar = up.charAt(0);
		if (indexChar == letter) {
			return skip3(up.substring(1), letter);
		} else {
			return indexChar + skip3(up.substring(1), letter);

		}
	}

}
