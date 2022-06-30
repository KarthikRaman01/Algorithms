package com.educative.io.cyclicsort;

import java.util.Arrays;

public class AllMissingNumbers {

	public static void main(String[] args) {
		int input[] = { 2, 3, 1, 8, 2, 3, 5, 1 };
		missingAllNumbers(input);
		//System.out.println(Arrays.toString(input));

	}

	public static void missingAllNumbers(int[] input) {

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
		
		System.out.println(Arrays.toString(input));
		
		start = 0;
		end = input.length - 1;
		while(start <= end) {
			if(input[start]-1 != start) {
				System.out.println(start+1);
			}
			start++;
		}

	}

	public static void swap(int[] input, int firstIndex, int secondIndex) {
		int temp = input[firstIndex];
		input[firstIndex] = input[secondIndex];
		input[secondIndex] = temp;
	}

}
