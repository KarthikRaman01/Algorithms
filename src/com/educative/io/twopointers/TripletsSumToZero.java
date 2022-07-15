package com.educative.io.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//working
// sort the array
// iterate over the array and try to find the pair that sums to the right value
// skip the element if it's already been processed/iterated

// also after finding the pair, keep continuing but skip the element if it's already processed (while narrowing start and end down)
//and the start is index+1 when you find the pair
public class TripletsSumToZero {

	public static void main(String[] args) {
		int arr[] = { -5, 2, -1, -2, 3 };
		// System.out.println(getTripletsSumToZero(arr, 0));
		tripletsSumToZero(arr, 0);

	}

	public static void tripletsSumToZero(int[] arr, int targetSum) {
		Arrays.sort(arr);
		List<List<Integer>> output = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			// i>0 check for null pointer
			// check the prev element and the current and that it's not equal
			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;

			}
			search(arr, targetSum - arr[i], i, output);
		}

		for (List<Integer> ind : output) {
			System.out.println(ind);
		}

	}

	public static void search(int[] arr, int targetSum, int indexElement, List<List<Integer>> output) {

		int start = indexElement + 1;
		int end = arr.length - 1;

		while (start < end) {
			// since the start is from the index+1th element of the parent/base iteration
			/*
			 * if (start == indexElement) { start++; continue; }
			 * 
			 * if (end == indexElement) { end--; continue; }
			 */

			if ((arr[start] + arr[end]) > targetSum) {
				end = end - 1;
			} else if ((arr[start] + arr[end]) < targetSum) {
				start = start + 1;
			} else {
				List<Integer> ans = new ArrayList<Integer>();
				ans.add(arr[start]);
				ans.add(arr[end]);
				ans.add(arr[indexElement]);
				output.add(ans);

				start++;
				end--;

				while (start < end && arr[start] == arr[start - 1]) {
					start++;
				}

				while (start < end && arr[end] == arr[end + 1]) {
					end--;
				}
			}

		}
	}

}
