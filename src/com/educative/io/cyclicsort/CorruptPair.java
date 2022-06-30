package com.educative.io.cyclicsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CorruptPair {

	public static void main(String[] args) {
		int[] input = { 3, 1, 2, 3, 6, 4 };
		int[] duplicates = corruptPair(input);
		System.out.println(Arrays.toString(duplicates));

	}

	private static int[] corruptPair(int[] input) {

		int start = 0;
		int end = input.length - 1;

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
				int[] ans = new int[2];
				ans[0] = input[start];
				ans[1] = start + 1;
				return ans;
			}
			start++;
		}

		return new int[] { -1, 1 };
	}

	private static void swap(int input[], int firstIndex, int secondIndex) {
		int temp = input[firstIndex];
		input[firstIndex] = input[secondIndex];
		input[secondIndex] = temp;
	}

}
