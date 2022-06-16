package com.leetcode.arrays.easy;

public class ValidPalindrome2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abca";
		System.out.println(validPalindrome(s));

	}

	/**
	 * Leetcode method
	 * @param s
	 * @return
	 */
	public static boolean validPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (!(s.charAt(start) == s.charAt(end))) {
				return isValid(s, start, end - 1) || isValid(s, start + 1, end);
			}
			start = start + 1;
			end = end - 1;
		}
		return true;
	}

	public static boolean isValid(String s, int start, int end) {
		while (start < end) {
			if (!(s.charAt(start) == s.charAt(end))) {
				return false;
			}
			start = start + 1;
			end = end - 1;
		}
		return true;
	}

	/**
	 * my method - brute force
	 * should not be using substrings for large strings
	 * @param s
	 * @return
	 */
	private static boolean isValidPalindrome2(String s) {
		boolean isStringPalindrome = isPalindrome(s);
		if (isStringPalindrome) {
			return true;
		}

		for (int i = 0; i < s.length(); i++) {
			if (isPalindrome(s.substring(0, i) + s.substring(i + 1))) {
				return true;
			}

		}

		return false;
	}

	/**
	 * 2 pointer approach
	 * @param s
	 * @return
	 */
	private static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (!(s.charAt(start) == s.charAt(end))) {
				return false;
			}
			start = start + 1;
			end = end - 1;
		}
		return true;
	}

	/**
	 * Very naive approach
	 * @param s
	 * @return
	 */
	private static boolean isPalindrome2(String s) {
		if (reverse(s).equalsIgnoreCase(s)) {
			return true;
		}
		return false;
	}

	private static String reverse(String s) {
		String reverse = new String();
		for (int start = s.length() - 1; start >= 0; start--) {
			reverse = reverse + s.charAt(start);
		}
		return reverse;
	}
}
