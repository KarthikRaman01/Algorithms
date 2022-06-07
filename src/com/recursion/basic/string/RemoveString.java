package com.recursion.basic.string;

public class RemoveString {

	public static void main(String[] args) {
		System.out.println(skipWord("bitapplebitapple", "apple"));
		System.out.println(skipWordRecursion("", "bitapplebitapple", "apple"));

	}

	public static String skipWord(String input, String word) {
		StringBuffer ans = new StringBuffer();
		for (int i = 0; i < input.length(); i++) {
			if (!(input.substring(i).startsWith(word))) {
				ans.append(input.charAt(i));
			} else {
				i = i + word.length() - 1;
			}
		}
		return ans.toString();
	}

	public static String skipWordRecursion(String p, String up, String word) {
		if (up.isEmpty()) {
			return p;
		}

		if (up.startsWith(word)) {
			return skipWordRecursion(p, up.substring(word.length()), word);
		} else {
			return skipWordRecursion(p + up.charAt(0), up.substring(1), word);
		}

	}

}
