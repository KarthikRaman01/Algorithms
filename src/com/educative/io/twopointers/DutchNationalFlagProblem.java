package com.educative.io.twopointers;

import java.util.Arrays;

public class DutchNationalFlagProblem {

	public static void main(String[] args) {
		int a[] = { 2, 0, 1 };
		dutchNationalFlagProb2(a);
		System.out.println(Arrays.toString(a));
	}

	public static void dutchNationalFlagProb(int[] a) {
		int low = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				// swap with low index
				int temp = a[low];
				a[low] = a[i];
				a[i] = temp;
				// increase the low index
				low++;
			}
		}

		int high = a.length - 1;
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] == 2) {
				// swap with low index
				int temp = a[high];
				a[high] = a[i];
				a[i] = temp;
				// increase the low index
				high--;
			}
		}

	}

	public static void dutchNationalFlagProb1(int[] a) {
		int low = 0;
		int high = a.length - 1;
		int i = 0;

		while (i <= high) {
			if (a[i] == 0) {
				swap(a, low, i);
				low++;
				i++;
			} else if (a[i] == 1) {
				i++;
			} else {
				swap(a, high, i);
				high--;
			}

		}

	}

	public static void swap(int[] a, int firstIndex, int secondIndex) {
		int temp = a[firstIndex];
		a[firstIndex] = a[secondIndex];
		a[secondIndex] = temp;
	}

	public static void dutchNationalFlagProb2(int[] a) {
		int zeroPointer = 0;
		int twoPointer = a.length - 1;

		int counter = 0;

		while (counter <= twoPointer) {

			if (a[counter] == 1) {
				counter++;

			} else if (a[counter] == 0) {
				swap(a, zeroPointer, counter);

				if (zeroPointer == counter) {
					counter++;
				}
				zeroPointer++;

			}

			else if (a[counter] == 2) {
				swap(a, twoPointer, counter);
				if (twoPointer == counter) {
					counter++;
				}

				twoPointer--;
				continue;
			}
		}

	}

}
