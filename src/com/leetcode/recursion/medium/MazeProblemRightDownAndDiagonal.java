package com.leetcode.recursion.medium;

public class MazeProblemRightDownAndDiagonal {

	public static void main(String[] args) {
		path(3, 3);
		System.out.println(countNoOfWays("", 3, 3));
	}

	public static void path(int row, int column) {
		helper("", row, column);
	}

	public static void helper(String p, int row, int column) {

		if (row == 1 && column == 1) {
			System.out.println(p);
			return;
		}

		if (row == 1) {
			helper(p + "R", row, column - 1);
		} else if (column == 1) {
			helper(p + "D", row - 1, column);
		} else {
			helper(p + "R", row, column - 1);
			helper(p + "D", row - 1, column);
			helper(p + "S", row - 1, column - 1);

		}

	}
	
	public static Integer countNoOfWays(String p, int row, int column) {
		if (row == 1 & column == 1) {
			return 1;
		}

		int count = 0;
		if (row == 1) {
			count = count + countNoOfWays(p + "R", row, column - 1);
		} else if (column == 1) {
			count = count + countNoOfWays(p + "D", row - 1, column);
		} else {
			count = count + countNoOfWays(p + "R", row, column - 1);
			count = count + countNoOfWays(p + "D", row - 1, column);
			count = count + countNoOfWays(p + "S", row - 1, column-1);
		}
		return count;

	}
}
