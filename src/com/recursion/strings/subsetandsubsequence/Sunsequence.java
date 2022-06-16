package com.recursion.strings.subsetandsubsequence;

import java.util.Arrays;

public class Sunsequence {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3 };
		printSubSequence(a);

	}

	public static void printSubSequence(int[] input) {
		int[] processed = new int[0];
		helper(processed, input);
	}

	public static void helper(int[] processed, int[] unProcessed) {
		if (unProcessed.length == 0) {
			System.out.println(Arrays.toString(processed));
			return;
		}

		int mergeElement = unProcessed[0];
		int[] mergedArray = createArray(processed, mergeElement);
		int[] unProcessedAfterRemovingFirstElement = removeFirstElement(unProcessed);
		helper(mergedArray, unProcessedAfterRemovingFirstElement);
		helper(processed, unProcessedAfterRemovingFirstElement);

	}

	public static int[] createArray(int[] processed, int mergeElement) {
		int[] tempArray = new int[processed.length + 1];
		int count = 0;
		while (count < processed.length) {
			tempArray[count] = processed[count];
			count = count + 1;
		}
		tempArray[count] = mergeElement;
		return tempArray;
	}

	public static int[] removeFirstElement(int[] unProcessed) {
		int[] tempArray = new int[unProcessed.length - 1];
		int count = 0;
		while (count < unProcessed.length - 1) {
			tempArray[count] = unProcessed[count + 1];
			count = count + 1;
		}
		return tempArray;
	}

}
