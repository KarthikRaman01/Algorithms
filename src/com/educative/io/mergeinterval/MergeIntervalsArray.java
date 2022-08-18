package com.educative.io.mergeinterval;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervalsArray {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

		int[][] ans = merge(intervals);
		for (int[] list : ans) {
			System.out.println(Arrays.toString(list));
		}
		
		List<int[]> ans1 = merge1(intervals);
		for (int[] list : ans1) {
			System.out.println(Arrays.toString(list));
		}

	}

	public static int[][] merge(int[][] intervals) {
		int[][] output = new int[intervals.length][intervals[0].length];
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		int count = 0;
		output[count] = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			int[] prevInterval = output[count];
			int[] currentInterval = intervals[i];

			// if merge --> replace the array for the old count with the correct value
			if (isMerge(output[count], currentInterval)) {
				prevInterval[1] = Integer.max(prevInterval[1], currentInterval[1]);
				output[count] = prevInterval;
			}
			// else add the current interval to the ans, increment the count and move on
			else {
				count = count + 1;
				output[count] = intervals[i];
			}

		}

		return output;
	}

	public static List<int[]> merge1(int[][] intervals) {
		List<int[]> output = new ArrayList<>();
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		int count = 0;

		output.add(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			int[] prevInterval = output.get(count);
			int[] currentInterval = intervals[i];

			// if merge --> replace the array for the old count with the correct value
			if (isMerge(output.get(count), currentInterval)) {
				prevInterval[1] = Integer.max(prevInterval[1], currentInterval[1]);
			}
			// else add the current interval to the ans, increment the count and move on
			else {
				count = count + 1;
				output.add(intervals[i]);

			}
		}
		return output;
	}

	public static boolean isMerge(int[] first, int[] second) {
		if (second[0] <= first[1]) {
			return true;
		}
		return false;

	}

}
