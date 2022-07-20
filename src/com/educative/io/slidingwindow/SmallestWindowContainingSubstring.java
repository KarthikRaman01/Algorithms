package com.educative.io.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallestWindowContainingSubstring {

	public static void main(String[] args) {
		String input = "ADOBECODEBANC", pattern = "ABC";
		System.out.println(smallestWinContainingSubStr(input, pattern));
	}

	public static String smallestWinContainingSubStr(String input, String pattern) {
		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		String output = "";
		int windowStart = 0;
		frequencyMap(frequencyMap, pattern);
		int[] ans = new int[2];
		ans[0] = -1;
		ans[1] = -1;
		int counter = 0;
		int minLength = Integer.MAX_VALUE;
		for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
			char ch = input.charAt(windowEnd);
			if (frequencyMap.containsKey(ch)) {
				frequencyMap.put(ch, frequencyMap.get(ch) - 1);

				if (frequencyMap.get(ch) == 0) {
					counter = counter + 1;
				}
			}

			if (counter == frequencyMap.size()) {
				// we found the answer
				int length = windowEnd - windowStart + 1;
				if (length < minLength) {
					minLength = length;
					ans[0] = windowStart;
					ans[1] = windowEnd;

					if (minLength == pattern.length()) {
						break;
					}

					while (length > pattern.length()) {
						char firstCh = input.charAt(windowStart);
						if (frequencyMap.containsKey(firstCh)) {
							if (frequencyMap.get(firstCh) == 0) {
								counter = counter - 1;
							}
							frequencyMap.put(firstCh, frequencyMap.get(firstCh) + 1);
						}

						windowStart = windowStart + 1;
						length = windowEnd - windowStart + 1;
						if (counter == frequencyMap.size()) {
							ans[0] = windowStart;
							ans[1] = windowEnd;
							minLength = length;
						}else {
							break;
						}

					}

				}

			}

		}

		System.out.println(Arrays.toString(ans));
		if(ans[0]==-1 && ans[1]==-1) {
			return "";
		}
		output = input.substring(ans[0], ans[1] + 1);
		return output;
	}

	private static void frequencyMap(Map<Character, Integer> frequencyMap, String pattern) {
		char[] array = pattern.toCharArray();
		for (char c : array) {
			frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
		}

	}

}
