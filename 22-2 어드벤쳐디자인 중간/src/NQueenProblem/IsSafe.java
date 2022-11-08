package NQueenProblem;

public class IsSafe {
    static boolean checkSafe(int[][] board, int row, int col) { // 현재까지 완성된 체스판을 입력받아 새롭게 놓일 퀸의 위치가 안전한지 체크
    	int i; 
		int j;
		for (i = 0; i < col; i++)
			if (board[row][i] == 1)
				return false;
	
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
		{
			if (board[i][j] == 1)
				return false;
		}
		

		for (i = row, j = col; j >= 0 && i < NQueenTest.boardSize; i++, j--)
		{
			if (board[i][j] == 1)
				return false;
		}
		return true;
    }
}
