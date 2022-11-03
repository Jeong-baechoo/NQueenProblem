package NQueenProblem;

public class SolveNQUtill 
{
	static boolean check(int[][] board, int col) {
		
		if (col >= NQueenTest.boardSize)  // 행이 
			return true;

		for (int i = 0; i < NQueenTest.boardSize; i++) {
			if (IsSafe.checkSafe(board, i, col)) {
				board[i][col] = 1;

				if (SolveNQUtill.check(board, col + 1) == true)
					return true;
				
				board[i][col] = 0;
			}
		}

		return false;
	}

}