package NQueenProblem;

public class IsSafe {
    static boolean checkSafe(int board[][], int row, int col) {
    	int i, j;

		for (i = 0; i < col; i++)
			if (board[row][i] == 1)
				return false;

		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		for (i = row, j = col; j >= 0 && i < NQueenTest.boardSize; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
    }
}
