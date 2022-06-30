package com.educative.io.cyclicsort;


public class DuplicateNumber {

	public static void main(String[] args) {
		int[] input = { 2, 1, 3, 3, 5, 4 };
		System.out.println(duplicateNumber(input));

	}

	private static int duplicateNumber(int[] input) {

		int start = 0;
		int end = input.length - 1;

		while (start <= end) {
			int element = input[start];
			int swapIndex = element - 1;
			if (swapIndex == start) {
				start = start + 1;
				continue;
			}

			if (swapIndex >= 0 && swapIndex <= input.length - 1) {
				if (input[swapIndex] == element) {
					return element;
				}
				swap(input, start, swapIndex);
			} else {
				start = start + 1;
			}

		}

		return -1;
	}

	private static void swap(int input[], int firstIndex, int secondIndex) {
		int temp = input[firstIndex];
		input[firstIndex] = input[secondIndex];
		input[secondIndex] = temp;
	}

}
