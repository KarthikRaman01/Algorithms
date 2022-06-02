package com.questions.arrays.easy;

public class IsSortedArray {

	public static void main(String[] args) {
		int a[] = { 1, 3, 5, 7, 7, 9, 10 };
		System.out.println(isSorted(a));
		System.out.println(isSortedRecursive(a));

	}

	public static boolean isSorted(int a[]) {
		int count = 1;
		int first = 0;
		int second = 1;
		while (count < a.length) {
			if (a[first] > a[second]) {
				return false;
			}
			first++;
			second++;
			count++;
		}

		return true;
	}

	public static boolean isSortedRecursive(int a[]) {
		return helper2(a, 0, 1);
	}

	/**
	 * My method
	 * 
	 * @param a
	 * @param first
	 * @param second
	 * @return
	 */
	public static boolean helper(int a[], int first, int second) {
		if (second > a.length - 1) {
			return true;
		}

		if (a[first] > a[second]) {
			return false;
		}

		first = first + 1;
		second = second + 1;
		boolean ansForNextComparisions = helper(a, first, second);
		return ansForNextComparisions;

		// return (a[first] <= a[second]) && helper(a, ++first, ++second);

	}

	/**
	 * We can also use just one index instead of first and second
	 * @param a
	 * @param first
	 * @param second
	 * @return
	 */
	public static boolean helper2(int a[], int first, int second) {
		if (second > a.length - 1) {
			return true;
		}

		// recurrence relation
		// f(n) = f(0 & 1) & f(next elements in the array)
		// first comparison and then the next
		return (a[first] <= a[second]) && helper2(a, ++first, ++second);

	}

}
