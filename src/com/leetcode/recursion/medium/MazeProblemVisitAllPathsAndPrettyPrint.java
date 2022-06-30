package com.leetcode.recursion.medium;

import java.util.Arrays;

public class MazeProblemVisitAllPathsAndPrettyPrint {

	public static void main(String[] args) {

		boolean maze[][] = { { true, true, true }, { true, true, true }, { true, true, true }, };
		int ans[][] = new int[maze.length][maze[0].length];
		visitAllPaths(maze, "", 0, 0, ans, 1);
	}

	public static void visitAllPaths(boolean maze[][], String p, int row, int column, int[][] ans, int step) {
		if (row == maze.length - 1 && column == maze[0].length - 1) {
			ans[row][column] = step;
			System.out.println(p);
			for (int[] a : ans) {
				System.out.println(Arrays.toString(a));
			}
			return;
		}

		// keep track of the change when one of the path is traversed
		if (!maze[row][column]) {
			return;
		}

		maze[row][column] = false;
		ans[row][column] = step;
		if (column < maze.length - 1) {
			visitAllPaths(maze, p + "R", row, column + 1, ans, step + 1);

		}

		if (row < maze[0].length - 1) {
			visitAllPaths(maze, p + "D", row + 1, column, ans, step + 1);

		}

		if (row > 0) {
			visitAllPaths(maze, p + "U", row - 1, column, ans, step + 1);

		}

		if (column > 0) {
			visitAllPaths(maze, p + "L", row, column - 1, ans, step + 1);

		}

		// revert the changes made for the path so the next path will have a fresh start
		maze[row][column] = true;
		ans[row][column] = 0;

	}

}
