package com.recursion.strings.subsetandsubsequence;

public class NQueens {

	public static void main(String[] args) {
		boolean[][] board = new boolean[4][4];
		// nQueens(board, 0);
		nQueens1(board, 0, 0, 4);
	}

	public static void nQueens(boolean[][] board, int row) {
		if (row == board.length) {
			printBoard(board);
			return;
		}

		for (int col = 0; col < board.length; col++) {
			if (isSafe(board, row, col)) {
				board[row][col] = true;
				nQueens(board, row + 1);
				board[row][col] = false;
			}

		}

	}

	public static void nQueens1(boolean[][] board, int row, int col, int queens) {
		if (queens == 0) {
			printBoard(board);
			return;
		}

		if (col == board[0].length) {
			return;
		}

		if (isSafe(board, row, col)) {
			board[row][col] = true;
			nQueens1(board, row + 1, 0, queens - 1);
			board[row][col] = false;
		}
		nQueens1(board, row, col + 1, queens);

	}

	public static boolean isSafe(boolean[][] board, int row, int col) {

		// check the rows up for the same column
		for (int start = row - 1; start >= 0; start--) {
			if (board[start][col] == true) {
				return false;
			}
		}

		int tempRow = row - 1;
		int tempCol = col - 1;
		while (tempRow >= 0 && tempCol >= 0) {
			if (board[tempRow][tempCol] == true) {
				return false;
			}
			tempRow--;
			tempCol--;
		}

		tempRow = row - 1;
		tempCol = col + 1;
		while (tempRow >= 0 && tempCol <= board.length - 1) {
			if (board[tempRow][tempCol] == true) {
				return false;
			}
			tempRow++;
			tempCol++;
		}

		return true;
	}

	public static void printBoard(boolean[][] board) {
		for (boolean[] row : board) {
			for (boolean val : row) {
				if (val) {
					System.out.print("Q");
				} else {
					System.out.print("X");
				}
			}
			System.out.println();
		}
		System.out.println();

	}

}
