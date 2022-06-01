package com.recursion.basic;

/**
 * Leetcode - https://leetcode.com/problems/fibonacci-number/
 * @author Karthik
 *
 */
public class BinarySearch {

	// Recurrence relation
	// f(n) = o(1)[compare] + f(n/2)
	public static void main(String[] args) {
		int[] inputArray = { 1, 3, 5, 6, 7, 9, 11, 12, 15 };
		int elementToSearch = 15;

		int indexFound = binarySearch(inputArray, elementToSearch);
		System.out.println("Index found: " + indexFound);

		indexFound = binarySearchRecursive(inputArray, elementToSearch, 0, inputArray.length - 1);
		System.out.println("Index found: " + indexFound);

	}

	public static int binarySearch(int[] inputArray, int elementToSearch) {
		int start = 0;
		int end = inputArray.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (elementToSearch < inputArray[mid]) {
				end = mid - 1;
			} else if (elementToSearch > inputArray[mid]) {
				start = mid + 1;
			} else {
				return mid;
			}

		}
		return -1;
	}

	/**
	 * Dont need a while loop
	 * 
	 * @param inputArray
	 * @param elementToSearch
	 * @param start
	 * @param end
	 * @return
	 */
	public static int binarySearchRecursive(int[] inputArray, int elementToSearch, int start, int end) {
		if (start > end) {
			return -1;
		}

		int mid = (start + end) / 2;
		if (elementToSearch < inputArray[mid]) {
			// make sure to return the result of the function call
			return binarySearchRecursive(inputArray, elementToSearch, start, mid - 1);
		} else if (elementToSearch > inputArray[mid]) {
			return binarySearchRecursive(inputArray, elementToSearch, mid + 1, end);
		} else {
			return mid;
		}

	}

}
