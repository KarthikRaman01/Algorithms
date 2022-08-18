package com.educative.io.mergeinterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeInterval {

	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 5));
		input.add(new Interval(7, 9));
		List<Interval> ans = mergeInterval(input);
		System.out.println(ans);

	}

	public static List<Interval> mergeInterval(List<Interval> input) {
		List<Interval> mergedOutput = new ArrayList<>();
		Collections.sort(input, (a, b) -> Integer.compare(a.start, b.start));
		for (Interval currentInterval : input) {
			if (mergedOutput.isEmpty()) {
				mergedOutput.add(currentInterval);
			} else {
				Interval lastInterval = mergedOutput.get(mergedOutput.size() - 1);
				if (isMerging(lastInterval, currentInterval)) {
					lastInterval.end = Integer.max(lastInterval.end, currentInterval.end);

				} else {
					mergedOutput.add(currentInterval);
				}

			}

		}

		return mergedOutput;

	}

	public static boolean isMerging(Interval first, Interval second) {
		if (second.start <= first.end) {
			return true;
		}
		return false;
	}

}

class Interval {
	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}

	int start;
	int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}
