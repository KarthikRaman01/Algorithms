package com.educative.io.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {

	public static void main(String[] args) {
		String input = "abbcabc";
		String pattern = "abc";
		List<Integer> ans = StringAnagrams.anagrams1(input, pattern);
		System.out.println(ans);

	}

	public static List<Integer> anagrams(String input, String pattern) {
		List<Integer> anagramStartIndices = new ArrayList<Integer>();

		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		frequencyMap(frequencyMap, pattern);

		int windowStart = 0;
		int counter = 0;
		for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
			char endCh = input.charAt(windowEnd);
			if (frequencyMap.containsKey(endCh)) {
				frequencyMap.put(endCh, frequencyMap.get(endCh) - 1);
			}

			if (frequencyMap.get(endCh) == 0) {
				counter = counter + 1;
			}

			if (counter == frequencyMap.size()) {
				anagramStartIndices.add(windowStart);
			}

			if (windowEnd >= pattern.length() - 1) {
				char startCh = input.charAt(windowStart);
				if (frequencyMap.containsKey(startCh)) {
					if (frequencyMap.get(startCh) == 0) {
						counter = counter - 1;
					}
					frequencyMap.put(startCh, frequencyMap.get(startCh) + 1);
				}
				windowStart++;

			}

		}

		return anagramStartIndices;

	}

	public static List<Integer> anagrams1(String input, String pattern) {
		List<Integer> anagramStartIndices = new ArrayList<Integer>();

		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		frequencyMap(frequencyMap, pattern);

		int windowStart = 0;

		Map<Character, Integer> slidingWindowMap = new HashMap<Character, Integer>();

		for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
			char endCh = input.charAt(windowEnd);
			if (slidingWindowMap.containsKey(endCh)) {
				slidingWindowMap.put(endCh, slidingWindowMap.get(endCh) + 1);
			} else {
				slidingWindowMap.put(endCh, 1);
			}

			if (windowEnd >= pattern.length() - 1) {
				if (slidingWindowMap.equals(frequencyMap)) {
					anagramStartIndices.add(windowStart);
				}

				// remove the first character from the sliding window map
				char startCh = input.charAt(windowStart);
				if (slidingWindowMap.containsKey(startCh)) {
					slidingWindowMap.put(startCh, slidingWindowMap.get(startCh) - 1);
				}

				if (slidingWindowMap.get(startCh) == 0) {
					slidingWindowMap.remove(startCh);
				}
				windowStart++;

			}

		}

		return anagramStartIndices;

	}

	private static void frequencyMap(Map<Character, Integer> frequencyMap, String pattern) {
		char[] array = pattern.toCharArray();
		for (char c : array) {
			frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
		}

	}

}
