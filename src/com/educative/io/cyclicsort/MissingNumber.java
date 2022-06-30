package com.educative.io.cyclicsort;

public class MissingNumber {

	public static void main(String[] args) {
		int input[] = { 8, 3, 5, 0, 4, 6, 7, 1 };
		int missingNumber = cyclicSort1(input);
		System.out.println(missingNumber);

	}

	public static int cyclicSort(int[] input) {
		if (input.length <= 0) {
			return -1;
		}

		int start = 0;
		int end = input.length - 1;

		while (start <= end) {
			// whether the number is at the right index
			int number = input[start];
			if (start == number - 1) {
				start++;
				continue;
			}

			int swapIndex = number - 1;
			if (swapIndex < 0 || swapIndex >= input.length) {
				start++;
				continue;
			} else {
				swap(input, start, number - 1);
			}

		}

		start = 0;
		end = input.length - 1;
		while (start <= end) {
			if (input[start] - 1 != start) {
				return start + 1;
			}
			start++;
		}

		return -1;
	}

	public static void swap(int input[], int index1, int index2) {
		int temp = input[index1];
		input[index1] = input[index2];
		input[index2] = temp;
	}

	public static int cyclicSort1(int[] input) {
		if (input.length <= 0) {
			return -1;
		}

		int start = 0;
		int end = input.length - 1;

		while (start <= end) {
			// whether the number is at the right index
			int number = input[start];
			if (start == number) {
				start++;
				continue;
			}

			if (number < 0 || number >= input.length) {
				start++;
				continue;
			} else {
				swap(input, start, number);
			}

		}

		start = 0;
		end = input.length - 1;
		while (start <= end) {
			if (input[start] != start) {
				return start;
			}
			start++;
		}

		return -1;
	}

}
