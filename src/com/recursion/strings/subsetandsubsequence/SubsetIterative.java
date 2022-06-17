package com.recursion.strings.subsetandsubsequence;

import java.util.ArrayList;
import java.util.List;

public class SubsetIterative {

	public static void main(String[] args) {
		String letter = "abc";
		subsetIterative1(letter);
		
		int[] input = {1, 2, 3};
		subsetIterative2(input);

	}

	public static void subsetIterative(String letter) {

		List<String> firstLetter = new ArrayList<>();
		Character ch = letter.charAt(0);
		firstLetter.add(ch.toString());

		List<String> nullLetter = new ArrayList<>();
		nullLetter.add("");

		List<List<String>> ans = new ArrayList<>();
		ans.add(firstLetter);
		ans.add(nullLetter);

		for (int i = 1; i < letter.length(); i++) {
			Character let = letter.charAt(i);
			int size = ans.size();
			for (int j = 0; j < size; j++) {
				String secondAns;
				List<String> present = ans.get(j);
				secondAns = present.get(0) + let;

				List<String> out = new ArrayList<>();
				out.add(secondAns);
				ans.add(out);

			}

		}

		System.out.println(ans);

	}

	public static void subsetIterative1(String letter) {
		List<String> nullLetter = new ArrayList<>();
		nullLetter.add("");

		List<List<String>> ans = new ArrayList<>();
		ans.add(nullLetter);

		for (int i = 0; i < letter.length(); i++) {
			Character let = letter.charAt(i);
			int size = ans.size();
			for (int j = 0; j < size; j++) {
				String secondAns;
				List<String> present = ans.get(j);
				secondAns = present.get(0) + let;

				List<String> out = new ArrayList<>();
				out.add(secondAns);
				ans.add(out);

			}

		}

		System.out.println(ans);

	}

	public static void subsetIterative2(int[] letter) {
		List<Integer> emptyList = new ArrayList<>();
		List<List<Integer>> ans = new ArrayList<>();
		ans.add(emptyList);

		/*int firstInt = letter[0];
		List<Integer> firstIntList = new ArrayList<>();
		firstIntList.add(firstInt);
		ans.add(firstIntList);*/

		for (int i = 0; i < letter.length; i++) {
			int size = ans.size();
			for (int j = 0; j < size; j++) {
				List<Integer> copy = new ArrayList<>(ans.get(j));
				copy.add(letter[i]);
				ans.add(copy);
			}
		}

		System.out.println(ans);
	}

}
