package com.educative.io.slidingwindow;

public class AverageOfAllSubArraysOfSizeK {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
		int k = 5;
		avgOfSubArrays(arr, k);
		System.out.println("====================");
		avgOfSubArrays2(arr, k);
		System.out.println("====================");
		avgOfSubArrays3(arr, k);
	}

	private static void avgOfSubArrays(int arr[], int k) {
		int itCount = arr.length - k + 1;

		for (int i = 0; i < itCount; i++) {
			int sum = getSum(arr, i, k + i);
			double avg = (double) sum / k;
			System.out.print(avg + "      ");
		}
	}

	private static int getSum(int arr[], int startIndex, int endIndex) {
		int sum = 0;
		for (int i = startIndex; i < endIndex; i++) {
			sum = sum + arr[i];
		}
		return sum;
	}

	private static void avgOfSubArrays2(int arr[], int k) {
		int itCount = arr.length - k + 1;
		int sum = getSum(arr, 0, k);
		double avg = (double) sum / k;
		System.out.print(avg + "      ");
		for (int i = 1; i < itCount; i++) {
			sum = sum + arr[k + i - 1] - arr[i - 1];
			avg = (double) sum / k;
			System.out.print(avg + "      ");
		}
	}

	private static void avgOfSubArrays3(int arr[], int k) {
		int windowStart = 0;
		double sum = 0;

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			sum = sum + arr[windowEnd];

			if (windowEnd >= k - 1) {
				double avg = sum / k;
				System.out.println(avg);
				sum = sum - arr[windowStart];
				windowStart++;
			}
		}
	}

}
