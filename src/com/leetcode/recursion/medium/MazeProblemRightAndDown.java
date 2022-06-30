package com.leetcode.recursion.medium;

public class MazeProblemRightAndDown {

	public static void main(String[] args) {
		differentWaysToReach(3, 3);
		System.out.println(countNoOfWays("", 2, 2));
		easyDifferentWaysToReach("", 3, 3);
	}

	public static void differentWaysToReach(int row, int column) {
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
		}
		return count;

	}

	public static Integer easyCountNoOfWays(String p, int row, int column) {
		if (row == 1 || column == 1) {
			return 1;
		}

		int left = countNoOfWays(p + "R", row, column - 1);
		int right = countNoOfWays(p + "D", row - 1, column);
		return left + right;
	}

	public static void easyDifferentWaysToReach(String p, int row, int column) {
		if (row == 1 && column == 1) {
			System.out.println(p);
		}

		if (row > 1) {
			easyDifferentWaysToReach(p + "R", row-1, column);
		}

		if (column > 1) {
			easyDifferentWaysToReach(p + "D", row, column-1);
		}

	}
	
	public static void easyDifferentWaysToReach2(String p, int row, int column) {
		if (row == 1 && column == 1) {
			System.out.println(p);
		}

		if (row > 1) {
			easyDifferentWaysToReach(p + "R", row-1, column);
		}

		if (column > 1) {
			easyDifferentWaysToReach(p + "D", row, column-1);
		}
		
		if (row>1 && column > 1) {
			easyDifferentWaysToReach(p + "S", row-1, column-1);
		}

	}

}
