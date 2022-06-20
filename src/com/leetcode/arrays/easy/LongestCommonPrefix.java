package com.leetcode.arrays.easy;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		// String[] strs = { "", "b" };
		System.out.println(longestCommonPrefix(strs));

	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length < 1) {
			return "";
		} else if (strs.length == 1) {
			return strs[0];
		}

		int length = getLengthOfSmallestWord(strs);
		String longestCommonPrefix = "";
		for (int i = 0; i < length; i++) {
			Character letter = strs[0].charAt(i);
			for (int start = 1; start < strs.length; start++) {
				if (strs[start].charAt(i) != letter) {
					return longestCommonPrefix;
				}
			}
			longestCommonPrefix = longestCommonPrefix + letter;
		}
		return longestCommonPrefix;

	}

	// change the method name
	public static Integer getLengthOfSmallestWord(String[] strs) {
		Integer length = strs[0].length();
		for (int i = 0; i < strs.length; i++) {
			length = strs[i].length() < length ? strs[i].length() : length;
		}
		return length;
	}

	/**
	 * Initial thought
	 * 
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix1(String[] strs) {
		if (strs.length < 1) {
			return "";
		}

		if (strs.length == 1) {
			return strs[0];
		}

		String compareString = compareStringsForCommonPrefix(strs[0], strs[1]);
		for (int i = 2; i < strs.length; i++) {
			// compare 2 strings
			compareString = compareStringsForCommonPrefix(compareString, strs[i]);
			if (compareString == "" || compareString.isEmpty()) {
				return compareString;
			}
		}

		return compareString;

	}

	public static String compareStringsForCommonPrefix(String first, String second) {
		int length = first.length() < second.length() ? first.length() : second.length();
		int start = 0;
		String comparisonString = "";
		while (start < length) {
			if (first.charAt(start) == second.charAt(start)) {
				comparisonString = comparisonString + first.substring(start, start + 1);
			} else {
				break;
			}

			start++;
		}
		return comparisonString;
	}

}
