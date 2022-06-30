package com.leetcode.recursion.medium;

public class MazeProblemWithObstacles {

	public static void main(String[] args) {
		path(3, 3);

	}

	public static void path(int row, int column) {
		helper("", row, column);
	}

	public static void helper(String p, int row, int column) {

		if(row == 2 && column ==2) {
			return;
		}
		
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

}
