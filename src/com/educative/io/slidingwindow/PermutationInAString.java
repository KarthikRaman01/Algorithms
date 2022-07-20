package com.educative.io.slidingwindow;

import java.util.HashMap;

public class PermutationInAString {

	static HashMap<Character, Integer> patternMap = new HashMap<>();

	public static void main(String[] args) {
		String k = "abc";
		characterCount(k, patternMap);
		System.out.println(permutationInAString("aaacb", k));

	}

	public static boolean permutationInAString(String input, String k) {

		int windowStart = 0;
		HashMap<Character, Integer> slidingWindowMap = new HashMap<>();
		for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
			char ch = input.charAt(windowEnd);
			if (slidingWindowMap.containsKey(ch)) {
				slidingWindowMap.put(ch, slidingWindowMap.get(ch) + 1);
			} else {
				slidingWindowMap.put(ch, 1);
			}

			if ((windowEnd - windowStart + 1) == k.length()) {
				if (slidingWindowMap.equals(patternMap)) {
					return true;
				}

				char remove = input.charAt(windowStart);
				slidingWindowMap.put(remove, slidingWindowMap.get(remove) - 1);
				if (slidingWindowMap.get(remove) == 0) {
					slidingWindowMap.remove(remove);
				}
				windowStart++;
			}
		}
		return false;
	}

	public static HashMap<Character, Integer> characterCount(String input, HashMap<Character, Integer> countMap) {
		char[] charArray = input.toCharArray();
		for (char c : charArray) {
			if (countMap.containsKey(c)) {
				countMap.put(c, countMap.get(c) + 1);
			} else {
				countMap.put(c, 1);
			}
		}
		return countMap;
	}

}
