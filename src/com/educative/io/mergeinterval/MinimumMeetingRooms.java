package com.educative.io.mergeinterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MinimumMeetingRooms {

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		Interval interval1 = new Interval(4, 5);
		Interval interval2 = new Interval(2, 3);
		Interval interval3 = new Interval(3, 5);
		Interval interval4 = new Interval(2, 4);
		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);
		intervals.add(interval4);
		System.out.println(findMinMeetingRooms(intervals));

	}

	public static int findMinMeetingRooms(List<Interval> intervals) {
		if (intervals == null || intervals.size() < 1) {
			return 0;
		}
		Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
		int count = 0;

		HashSet<Integer> indexesAlreadyAdded = new HashSet<>();

		for (int i = 0; i < intervals.size(); i++) {
			if (indexesAlreadyAdded.contains(i)) {
				continue;
			}
			int start = intervals.get(i).start;
			int end = intervals.get(i).end;
			indexesAlreadyAdded.add(i);
			for (int j = i + 1; j < intervals.size(); j++) {
				if (indexesAlreadyAdded.contains(j)) {
					continue;
				}
				if (intervals.get(j).start < end) {
					continue;
				}
				indexesAlreadyAdded.add(j);
				start = intervals.get(j).start;
				end = intervals.get(j).end;
			}
			count = count + 1;
		}
		return count;
	}

	public static int findMinMeetingRooms(int[][] intervals) {
		if (intervals.length < 1) {
			return 0;
		}
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		int count = 0;

		HashSet<Integer> indexesAlreadyAdded = new HashSet<>();

		for (int i = 0; i < intervals.length; i++) {
			if (indexesAlreadyAdded.contains(i)) {
				continue;
			}
			int start = intervals[i][0];
			int end = intervals[i][1];
			indexesAlreadyAdded.add(i);
			for (int j = i + 1; j < intervals.length; j++) {
				if (indexesAlreadyAdded.contains(j)) {
					continue;
				}
				if (intervals[j][0] < end) {
					continue;
				}
				indexesAlreadyAdded.add(j);
				start = intervals[j][0];
				end = intervals[j][1];
			}
			count = count + 1;
		}
		return count;
	}

}
