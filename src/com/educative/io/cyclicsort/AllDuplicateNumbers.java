package com.educative.io.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class AllDuplicateNumbers {

	public static void main(String[] args) {
		int[] input = { 5, 4, 7, 2, 3, 5, 3 };
		List<Integer> duplicates = duplicateNumber(input);
		System.out.println(duplicates);

	}

	private static List<Integer> duplicateNumber(int[] input) {

		int start = 0;
		int end = input.length - 1;
		List<Integer> ans = new ArrayList<Integer>();

		while (start <= end) {
			int element = input[start];
			int swapIndex = element - 1;
			if (swapIndex == start) {
				start = start + 1;
				continue;
			}

			if (swapIndex >= 0 && swapIndex <= input.length - 1 && input[swapIndex] != element) {
				swap(input, start, swapIndex);
			} else {
				start = start + 1;
			}
		}

		start = 0;
		end = input.length - 1;
		while (start <= end) {
			if (input[start] - 1 != start) {
				ans.add(input[start]);
			}
			start++;
		}

		return ans;
	}

	private static void swap(int input[], int firstIndex, int secondIndex) {
		int temp = input[firstIndex];
		input[firstIndex] = input[secondIndex];
		input[secondIndex] = temp;
	}

}
