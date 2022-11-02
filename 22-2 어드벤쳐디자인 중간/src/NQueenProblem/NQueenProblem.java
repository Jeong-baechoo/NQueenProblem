package NQueenProblem;
import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {
	final int N = 8;
	int count=0;

	void printSolution(int board[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(" " + board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("count : "+count);
	}

	boolean isSafe(int board[][], int row, int col) {
		int i, j;

		for (i = 0; i < col; i++)
			if (board[row][i] == 1)
				return false;

		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		for (i = row, j = col; j >= 0 && i < N; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}

	boolean solveNQUtil(int[][] board, int col) {
		
		if (col >= N)
			return true;

		for (int i = 0; i < N; i++) {
			if (isSafe(board, i, col)) {
				board[i][col] = 1;

				if (solveNQUtil(board, col + 1) == true)
					return true;
				
				board[i][col] = 0;
			}
		}

		return false;
	}

	boolean solveNQ() {
		int n = 8;
		 
        int board[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
		
		if (solveNQUtil(board, 0) == false) {
			System.out.println("Solution does not exist");
			return false;
		}

		printSolution(board);
		return true;
	}

	public static void main(String args[]) throws InterruptedException {
		NQueenProblem Queen = new NQueenProblem();
		Queen.solveNQ();
		// TimeUnit.SECONDS.sleep(1);
	}

}
