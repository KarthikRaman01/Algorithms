package com.educative.io.cyclicsort;

public class SamllestMissingPositiveNumber {

	public static void main(String[] args) {
		int input[] = { 3, 2, 5, 1 };
		int ans = cyclicSort(input);
		System.out.println(ans);

	}

	private static int cyclicSort(int[] input) {
		int start = 0;
		int end = input.length - 1;

		while (start <= end) {
			int element = input[start];
			int swapIndex = element - 1;
			if (element - 1 == start) {
				start++;
				continue;
			}

			if (swapIndex >= 0 && swapIndex <= input.length - 1 && element != input[swapIndex]) {
				swap(input, start, swapIndex);
			}else {
				start++;
			}

		}
		
		start = 0;
		end = input.length - 1;
		while(start<=end) {
			if(input[start]-1 != start) {
				return start+1;
			}
			start++;
		}
		
		return -1;
		
	}

	private static void swap(int[] input, int firstIndex, int secondIndex) {
		int temp = input[firstIndex];
		input[firstIndex] = input[secondIndex];
		input[secondIndex] = temp;
	}

}
