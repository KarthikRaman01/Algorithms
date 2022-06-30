package com.educative.io.cyclicsort;

import java.util.Arrays;

public class BasicCyclicSort {

	public static void main(String[] args) {
		int input[] = { 1, 5, 6, 4, 3, 2 };
		cyclicSort(input);
		System.out.println(Arrays.toString(input));
	}

	public static void cyclicSort(int input[]) {

		int start = 0;
		int end = input.length - 1;

		while (start < end) {
			if (input[start] - 1 == start) {
				start = start + 1;
				continue;
			}

			// swap the element to the right index
			int swapIndex = input[start] - 1;
			swap(input, start, swapIndex);

		}

	}

	public static void swap(int input[], int index1, int index2) {
		int temp = input[index1];
		input[index1] = input[index2];
		input[index2] = temp;
	}

}
