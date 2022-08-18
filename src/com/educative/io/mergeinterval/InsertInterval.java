package com.educative.io.mergeinterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : InsertInterval.insert1(input, new Interval(4, 6)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : InsertInterval.insert1(input, new Interval(4, 10)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input = new ArrayList<Interval>();
		input.add(new Interval(2, 3));
		input.add(new Interval(5, 7));
		System.out.print("Intervals after inserting the new interval: ");
		for (Interval interval : InsertInterval.insert1(input, new Interval(1, 4)))
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();
	}

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> mergedIntervals = new ArrayList<>();
		Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

		for (Interval currentInt : intervals) {
			if (currentInt.end < newInterval.start) {
				mergedIntervals.add(currentInt);
			} else {
				break;
			}
		}

		// This is to merge the new Interval and the first interval that comes from the
		// input list
		int toMergeIndex = mergedIntervals.size();
		int start = Math.min(intervals.get(toMergeIndex).start, newInterval.start);
		int end = Math.max(intervals.get(toMergeIndex).end, newInterval.end);

		// no merge
		if (end < intervals.get(toMergeIndex).start) {
			mergedIntervals.add(new Interval(start, end));
			start = intervals.get(toMergeIndex).start;
			end = intervals.get(toMergeIndex).end;
		}

		toMergeIndex = toMergeIndex + 1;

		for (int i = toMergeIndex; i < intervals.size(); i++) {
			if (intervals.get(i).start <= end) {
				// merge
				end = Math.max(end, intervals.get(i).end);
			} else {
				mergedIntervals.add(new Interval(start, end));
				start = intervals.get(toMergeIndex).start;
				end = intervals.get(toMergeIndex).end;
			}

		}

		mergedIntervals.add(new Interval(start, end));

		return mergedIntervals;
	}

	public static List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
		List<Interval> output = new ArrayList<>();
		int index = 0;

		// check if the interval.size has to be +1 --> because the insert
		// may not have any merges/intersections
		while (index < intervals.size()) {
			if (newInterval.start > intervals.get(index).end) {
				output.add(intervals.get(index));
			} else {
				break;
			}

			index++;
		}

		int start = newInterval.start;
		int end = newInterval.end;
		while (index < intervals.size() && intervals.get(index).start <= end) {
			start = Math.min(intervals.get(index).start, start);
			end = Math.max(intervals.get(index).end, end);
			index++;
		}
		output.add(new Interval(start, end));

		while (index < intervals.size()) {
			output.add(intervals.get(index));
			index++;
		}
		return output;

	}

}
