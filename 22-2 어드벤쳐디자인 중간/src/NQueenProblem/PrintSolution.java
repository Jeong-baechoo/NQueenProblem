package NQueenProblem;

public class PrintSolution {
	static void print(int [][]board) {
		for (int i = 0; i < NQueenTest.boardSize; i++) { 
			for (int j = 0; j < NQueenTest.boardSize; j++) { //열출력
				System.out.print(" " + board[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
