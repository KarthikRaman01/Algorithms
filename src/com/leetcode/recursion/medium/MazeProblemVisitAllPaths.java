package com.leetcode.recursion.medium;

public class MazeProblemVisitAllPaths {

	public static void main(String[] args) {
		boolean maze[][] = { { true, true, true }, { true, true, true }, { true, true, true }, };
		visitAllPaths(maze, "", 0, 0);
	}

	public static void visitAllPaths(boolean maze[][], String p, int row, int column) {
		if (row == maze.length - 1 && column == maze[0].length - 1) {
			System.out.println(p);
			return;
		}

		//keep track of the change when one of the path is traversed
		if (!maze[row][column]) {
			return;
		}

		maze[row][column] = false;
		if (column < maze.length - 1) {
			visitAllPaths(maze, p + "R", row, column + 1);

		}

		if (row < maze[0].length - 1) {
			visitAllPaths(maze, p + "D", row + 1, column);

		}

		if (row > 0) {
			visitAllPaths(maze, p + "U", row - 1, column);

		}

		if (column > 0) {
			visitAllPaths(maze, p + "L", row, column - 1);

		}

		//revert the changes made for the path so the next path will have a fresh start
		maze[row][column] = true;

	}

}
