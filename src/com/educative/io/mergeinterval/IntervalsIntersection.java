package com.educative.io.mergeinterval;

import java.util.ArrayList;
import java.util.List;

public class IntervalsIntersection {

	public static void main(String[] args) {
		List<Interval> list1 = new ArrayList<>();
		Interval interval1 = new Interval(1, 3);
		Interval interval2 = new Interval(5, 7);
		Interval interval3 = new Interval(9, 12);
		list1.add(interval1);
		list1.add(interval2);
		list1.add(interval3);

		List<Interval> list2 = new ArrayList<>();
		// Interval interval4 = new Interval(2, 3);
		Interval interval5 = new Interval(5, 10);
		// list2.add(interval4);
		list2.add(interval5);

		System.out.println(getIntervalsIntersection(list1, list2));

	}

	public static List<Interval> getIntervalsIntersection(List<Interval> list1, List<Interval> list2) {
		List<Interval> intervalIntersectionList = new ArrayList<>();
		if (list1 == null || list2 == null) {
			return intervalIntersectionList;
		}

		int windowStartList1 = 0;
		int windowStartList2 = 0;

		int start = 0;
		int end = 0;

		while (windowStartList1 < list1.size() && windowStartList2 < list2.size()) {
			if ((list1.get(windowStartList1).start >= list2.get(windowStartList2).start
					&& list1.get(windowStartList1).start <= list2.get(windowStartList2).end)
					|| (list2.get(windowStartList2).start >= list1.get(windowStartList1).start
							&& list2.get(windowStartList2).start <= list1.get(windowStartList1).end)) {
				start = Math.max(list1.get(windowStartList1).start, list2.get(windowStartList2).start);
				end = Math.min(list1.get(windowStartList1).end, list2.get(windowStartList2).end);
				Interval intersectedInterval = new Interval(start, end);
				intervalIntersectionList.add(intersectedInterval);

			}

			if (list1.get(windowStartList1).end > list2.get(windowStartList2).end) {
				windowStartList2++;
			} else {
				windowStartList1++;
			}

		}

		return intervalIntersectionList;
	}

}
