package com.recursion.strings.subsetandsubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetIterativeWithoutDuplicates {

	public static void main(String[] args) {
		int a[] = { 2, 1, 2, 1 };
		subsetWithoutDuplicates(a);
		subsetWithoutDuplicates2(a);
	}

	public static void subsetWithoutDuplicates(int[] input) {
		Arrays.sort(input);
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> firstList = new ArrayList<>();
		ans.add(firstList);

		List<Integer> secondList = new ArrayList<>();
		secondList.add(input[0]);
		ans.add(secondList);

		for (int i = 1; i < input.length; i++) {
			int size = ans.size();
			for (int j = 0; j < size; j++) {
				List<Integer> newList = new ArrayList<>(ans.get(j));
				newList.add(input[i]);
				if (!(ans.contains(newList))) {
					ans.add(newList);
				}

			}

		}

		System.out.println(ans);

	}

	public static void subsetWithoutDuplicates2(int[] input) {
		Arrays.sort(input);
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> firstList = new ArrayList<>();
		ans.add(firstList);

		List<Integer> secondList = new ArrayList<>();
		secondList.add(input[0]);
		ans.add(secondList);

		int start = 0;
		int end = 0;
		for (int i = 1; i < input.length; i++) {
			start = 0;
			if (input[i] == input[i - 1]) {
				start = end + 1;
			}

			int size = ans.size();
			for (int j = start; j < size; j++) {
				List<Integer> newList = new ArrayList<>(ans.get(j));
				newList.add(input[i]);
				ans.add(newList);

			}

			end = size - 1;

		}

		System.out.println(ans);

	}

}
