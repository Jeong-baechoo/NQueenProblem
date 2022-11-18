package NQueenProblem;

public class SolveNQ {
	static boolean check(int[][] board, int col) {   
				
	    if (col >= NQueenTest.boardSize) {
            return true;
        }
    
        
        for (int i = 0; i < NQueenTest.boardSize; i++) { //SolveNq로 뺴기
            if (IsSafe.checkSafe(board, i, col)) {  // 퀸이 위치할수 있는 위치를 체크
                board[i][col] = 1;  //위치가 가능하면 1로 셋팅
                PrintSolution.print(board);
                
                System.out.println();
                System.out.println();
                if (SolveNQ.check(board, col + 1) == true)
                {
                    return true;
                }
                else{ // 위치
                    board[i][col] = 0;
                }
            }           
        }   
        return false;
    }

    static boolean solve(int boardSize) {
        int n = boardSize;
        int[][] board = new int[n][n]; //체스판 생성

        for (int i = 0; i < n; i++) {  //체스판 초기화
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
        SolveNQ.check(board, 0);
        PrintSolution.print(board);
        return true;
    }
	
}