package com.educative.io.cyclicsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstKMissingPositiveNumbers {

	public static void main(String[] args) {
		int input[] = { 3, 4, 5 };
		System.out.println(cyclicSort(input, 3));

	}

	private static List<Integer> cyclicSort(int[] input, int k) {
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
			} else {
				start++;
			}

		}
		
		System.out.println(Arrays.toString(input));

		start = 0;
		end = input.length - 1;
		Set<Integer> alreadyPresentNumbers = new HashSet<>();
		List<Integer> missingPositiveNos = new ArrayList<Integer>();
		while (start <= end && k > 0) {

			if (input[start] - 1 != start) {
				missingPositiveNos.add(start + 1);
				k--;
			}
			
			alreadyPresentNumbers.add(input[start]);

			start++;
		}

		int nextNumber = missingPositiveNos.get(missingPositiveNos.size()-1);
		while (k > 0) {
			nextNumber = nextNumber + 1;
			if(alreadyPresentNumbers.contains(nextNumber)) {
				continue;
			}
			missingPositiveNos.add(nextNumber);
			k--;
		}

		return missingPositiveNos;

	}

	private static void swap(int[] input, int firstIndex, int secondIndex) {
		int temp = input[firstIndex];
		input[firstIndex] = input[secondIndex];
		input[secondIndex] = temp;
	}

}
