package com.educative.io.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class WordsConcatenation {

	public static void main(String[] args) {
		String[] arr = new String[] { "cat", "fox" };
		wordsConcatenation("catfoxcat", arr);
	}

	public static void wordsConcatenation(String str, String[] words) {
		int windowStart = 0;
		String slidingWindowString = "";
		List<String> combinationWords = combinationWords(words);
		int wordLength = combinationWords.get(0).length();
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			slidingWindowString = slidingWindowString + str.charAt(windowEnd);

			if (windowEnd + 1 >= wordLength) {

				if (combinationWords.contains(slidingWindowString)) {
					System.out.println(windowStart);
				}

				// remove the windowStart element from the string
				windowStart++;
				slidingWindowString = slidingWindowString.substring(1);
			}
		}
	}

	public static List<String> combinationWords(String[] words) {
		List<String> output = new ArrayList<String>();
		String firstWord = "";
		for (String word : words) {
			firstWord = firstWord + word;
		}
		output.add(firstWord);

		String secondWord = "";
		for (int i = words.length - 1; i >= 0; i--) {
			secondWord = secondWord + words[i];
		}
		output.add(secondWord);
		return output;

	}

}
