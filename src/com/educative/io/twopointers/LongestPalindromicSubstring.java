package com.educative.io.twopointers;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		longestPalindromicSubstring("baab");

	}

	public static void longestPalindromicSubstring(String s) {
		int maxLength = 0;
		String output = "";
		for (int i = 0; i < s.length(); i++) {

			int left = i;
			int right = i;

			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				int length = right - left + 1;
				if (length > maxLength) {
					maxLength = length;
					output = s.substring(left, right + 1);
				}

				left = left - 1;
				right = right + 1;

			}
			
			left = i;
			right = i+1;

			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				int length = right - left + 1;
				if (length > maxLength) {
					maxLength = length;
					output = s.substring(left, right + 1);
				}

				left = left - 1;
				right = right + 1;

			}

		}

		System.out.println(output);

	}

}
