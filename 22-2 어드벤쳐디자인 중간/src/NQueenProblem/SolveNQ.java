package NQueenProblem;

import java.util.Scanner;

public class SolveNQ {

	static boolean solve() {
		int n = NQueenTest.boardSize;
		int board[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
        if (SolveNQUtill.check(board, 0) == false) { // 에러처리
    		System.out.println("Solution does not exist");
    		return false;
    	}

    	DisplaySolution.display(board);   //출력
    	return true;
    }
}
// static은 컴파일시 바로 메모리에 생성되기 때문에 static이 아닌 메서드안에 작성시
// 생성되지않은 객체안에 존재할 수가 없다.