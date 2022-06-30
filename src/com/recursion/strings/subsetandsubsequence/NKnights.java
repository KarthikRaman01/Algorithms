package com.recursion.strings.subsetandsubsequence;

public class NKnights {

	private static Integer count = 0;

	public static void main(String[] args) {
		boolean[][] board = new boolean[4][4];
		nKnights(board, 0, 0, 4);
		System.out.println("count: " + count);

	}

	public static void nKnights(boolean[][] board, int row, int col, int count) {
		//base condition
		if (row == board.length - 1 && col == board[0].length) {
			return;
		}

		// Display the board
		if (count == 0) {
			printBoard(board);
			return;
		}

		if (col == board.length) {
			nKnights(board, row + 1, 0, count);
			return;
		}

		if (isSafe(board, row, col)) {
			board[row][col] = true;
			nKnights(board, row, col + 1, count - 1);
			board[row][col] = false;

		}

		nKnights(board, row, col + 1, count);

	}

	public static boolean isSafe(boolean[][] board, int row, int col) {

		if (row < 0 || col < 0 || row >= board.length || col > board[0].length) {
			return false;
		}

		int tempRow = row - 2;
		int tempCol = col - 1;

		if (tempRow >= 0 && tempCol >= 0) {
			if (board[tempRow][tempCol] == true) {
				return false;
			}
		}

		tempRow = row - 1;
		tempCol = col - 2;
		if (tempRow >= 0 && tempCol >= 0) {
			if (board[tempRow][tempCol] == true) {
				return false;
			}
		}

		tempRow = row - 2;
		tempCol = col + 1;

		if (tempRow >= 0 && tempCol >= 0 && tempCol <= board.length - 1) {
			if (board[tempRow][tempCol] == true) {
				return false;
			}
		}

		tempRow = row - 1;
		tempCol = col + 2;

		if (tempRow >= 0 && tempCol >= 0 && tempCol <= board.length - 1) {
			if (board[tempRow][tempCol] == true) {
				return false;
			}
		}

		return true;
	}

	public static void printBoard(boolean[][] board) {
		count = count + 1;
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
