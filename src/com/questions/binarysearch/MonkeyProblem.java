package com.questions.binarysearch;

import java.util.Arrays;

public class MonkeyProblem {

	public static void main(String[] args) {
		int[] piles = {30,11,23,4,20};
		int h = 6;
		System.out.println(minEatingSpeed(piles, h));

	}

	public static int minEatingSpeed(int[] piles, int h) {
		int output = 1;
		while (true) {
			int totalTimesEaten = 0;
			int[] temp = Arrays.copyOf(piles, piles.length);

			int start = 0;
			while (start < temp.length) {
				int firstPile = temp[start];
				int newAns = firstPile - output;
				totalTimesEaten = totalTimesEaten + 1;
				if (totalTimesEaten > h) {
					output++;
					break;
				}
				temp[start] = newAns;
				if (newAns <= 0) {
					temp[start] = 0;
					start++;
				}
			}

			if (temp[temp.length - 1] == 0) {
				return output;
			}
		}
	}
	
	public static int minEatingSpeedBS(int[] piles, int h) {
		int output = 1;
		while (true) {
			int totalTimesEaten = 0;
			int[] temp = Arrays.copyOf(piles, piles.length);

			int start = 0;
			while (start < temp.length) {
				int firstPile = temp[start];
				int newAns = firstPile - output;
				totalTimesEaten = totalTimesEaten + 1;
				if (totalTimesEaten > h) {
					output++;
					break;
				}
				temp[start] = newAns;
				if (newAns <= 0) {
					temp[start] = 0;
					start++;
				}
			}

			if (temp[temp.length - 1] == 0) {
				return output;
			}
		}
	}

}
