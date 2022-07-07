package com.neetcode.io.intervals;

import java.util.Arrays;

/**
 * Leetcode - https://leetcode.com/problems/meeting-rooms/ Blind 75 problem for
 * Intervals - https://neetcode.io/
 * 
 * @author Karthik
 *
 */
public class MeetingRooms {

	public static void main(String[] args) {
		int[][] intervals = { { 60, 240 }, { 0, 30 }, { 90, 120 } };
		System.out.println(canAttendMeetings(intervals));
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		for (int i = 0; i < intervals.length; i++) {
			System.out.println(Arrays.toString(intervals[i]));
		}
		System.out.println(canAttendMeetings2(intervals));
	}

	/**
	 * Brute force solution
	 * 
	 * @param intervals
	 * @return
	 */
	public static boolean canAttendMeetings(int[][] intervals) {

		for (int start = 0; start < intervals.length; start++) {
			int[] interval = intervals[start];

			for (int j = 0; j < intervals.length; j++) {
				if (start != j) {
					int[] comparedInterval = intervals[j];

					if (interval[0] > comparedInterval[0] && interval[0] < comparedInterval[1]) {
						return false;
					}

					if (interval[1] > comparedInterval[0] && interval[1] < comparedInterval[1]) {
						return false;
					}

					// same time meeting
					if (interval[0] == comparedInterval[0] && interval[1] == comparedInterval[1]) {
						return false;
					}

					/*
					 * if ((comparedInterval[0] > interval[0] && comparedInterval[0] < interval[1])
					 * || (comparedInterval[1] > interval[0] && comparedInterval[1] < interval[1]))
					 * { return false; }
					 */
				}
			}
		}
		return true;
	}

	/**
	 * Sort the meetings by startTime 
	 * check whether the next meeting's start time is
	 * before the prev meeting's end time
	 * 
	 * @param intervals
	 * @return
	 */
	public static boolean canAttendMeetings2(int[][] intervals) {

		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		int start = 1;
		while (start < intervals.length) {
			int nextMeeting[] = intervals[start];
			int prevMeeting[] = intervals[start - 1];
			if (nextMeeting[0] < prevMeeting[1]) {
				return false;
			}
			start++;
		}

		return true;
	}

}
