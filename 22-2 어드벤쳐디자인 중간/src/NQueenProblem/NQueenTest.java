package NQueenProblem;

import java.util.Scanner;

public class NQueenTest {
	static int boardSize;
	public static void main(String[] args) throws InterruptedException {
        
        Scanner scan = new Scanner(System.in);
        while (true) {
            boardSize = SolveNQUtill.CheckInput(scan, "배열의 크기를 입력하세요: ");
            if(boardSize>3 & boardSize <14)
                break;
            else if(boardSize<4 || boardSize>13)
                System.out.println("3과 13사이의 정수를 입력하세요.");
        }
        
        SolveNQ.solve(boardSize);
        AllSolution.solve(boardSize);
		
	}
	
}
