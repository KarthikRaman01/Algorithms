package com.leetcode.recursion.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		HashMap<String, String> combos = getCombinations();
		// letterCombinations("12", combos);
		recursiveSolution("", "12", combos);
	}

	public static void letterCombinations(String input, HashMap<String, String> combos) {
		if (input == null || input.isEmpty()) {
			return;
		}

		List<List<String>> ans = new ArrayList<>();
		Character firstChar = input.charAt(0);
		// ans.add(new ArrayList<>());

		String lettersOfFirstNumber = combos.get(firstChar.toString());
		for (int i = 0; i < lettersOfFirstNumber.length(); i++) {
			List<String> output = new ArrayList<>();
			Character ch = lettersOfFirstNumber.charAt(i);
			output.add(ch.toString());
			ans.add(output);
		}

		for (int j = 0; j < ans.size(); j++) {

			for (int i = 1; i < input.length(); i++) {

				Character subChar = input.charAt(i);
				String lettersOfSubSequentNumber = combos.get(subChar.toString());

				for (int start = 0; start < lettersOfSubSequentNumber.length(); start++) {
					Character letter = lettersOfSubSequentNumber.charAt(start);
					List<String> out = new ArrayList<>(ans.get(j));
					out.add(letter.toString());
					ans.add(out);

				}
				ans.remove(ans.get(j));

			}

		}
		/*
		 * for (int i = 1; i < input.length(); i++) {
		 * 
		 * Character subChar = input.charAt(i); String lettersOfSubSequentNumber =
		 * combos.get(subChar.toString());
		 * 
		 * for (int start = 0; start < lettersOfSubSequentNumber.length(); start++) {
		 * Character letter = lettersOfSubSequentNumber.charAt(start);
		 * 
		 * for (int j = 0; j < ans.size(); j++) { List<String> out = ans.get(j);
		 * out.add(letter.toString()); } }
		 * 
		 * }
		 */

		System.out.println(ans);

	}

	public static HashMap<String, String> getCombinations() {
		HashMap<String, String> phoneCombinations = new HashMap<>();
		char ch = 'a';
		for (Integer i = 0; i < 9; i++) {
			String ans = getAssociatedLettersPerNumber(i);
			Integer key = i + 1;
			phoneCombinations.put(key.toString(), ans);
		}
		return phoneCombinations;

	}

	public static String getAssociatedLettersPerNumber(int i) {
		Character ch = (char) ('a' + (i * 3));
		String s = ch.toString();
		for (int j = 1; j < 3; j++) {
			Character ch1 = (char) (ch + j);
			if (!(ch1 > 'z')) {
				s = s + ch1;
			}

		}
		return s;

	}

	public static void recursiveSolution(String p, String up, HashMap<String, String> combos) {
		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}

		Character ch = up.charAt(0);
		String letters = combos.get(ch.toString());

		for (int i = 0; i < letters.length(); i++) {
			Character ch1 = letters.charAt(i);
			recursiveSolution(p + ch1.toString(), up.substring(1), combos);
		}

	}

}
