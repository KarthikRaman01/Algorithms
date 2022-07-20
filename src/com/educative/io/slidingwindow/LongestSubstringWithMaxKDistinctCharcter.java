package com.educative.io.slidingwindow;

import java.util.HashSet;

public class LongestSubstringWithMaxKDistinctCharcter {

	public static void main(String[] args) {
		String s = "cbbebi";
		int ans = longestSubstringWithMaxKDistinctCharcter(s, 10);
		System.out.println(ans);

	}

	public static int longestSubstringWithMaxKDistinctCharcter(String s, int k) {
		int length = 0;
		if (s == null || s.isEmpty()) {
			return length;
		}
		int windowStart = 0;
		String swString = "";
		for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
			swString = swString + s.charAt(windowEnd);

			if (isSubstringCharactersWithinK(swString, k)) {
				length = Math.max(length, windowEnd - windowStart + 1);
			} else {
				while (windowStart <= windowEnd && swString.length() > 0) {
					windowStart = windowStart + 1;
					swString = swString.substring(1);

					if (isSubstringCharactersWithinK(swString, k)) {
						break;
					}
				}
			}

		}

		return length;

	}

	private static boolean isSubstringCharactersWithinK(String s, int k) {
		HashSet<Character> set = new HashSet<>();
		char[] array = s.toCharArray();
		for (int start = 0; start < array.length; start++) {
			set.add(array[start]);
		}
		if (set.size() > k) {
			return false;
		}
		return true;
	}

}
