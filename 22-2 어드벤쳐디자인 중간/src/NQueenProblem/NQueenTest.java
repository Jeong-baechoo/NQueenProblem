package NQueenProblem;

import java.util.Scanner;

public class NQueenTest {
	static int boardSize;
	public static void main(String[] args) {
		System.out.print("배열의 크기를 입력하세요: ");
		Scanner scan = new Scanner(System.in);
		boardSize = scan.nextInt();
		while(!SolveNQUtill.CheckInput()){
			boardSize = scan.nextInt();
		}
		SolveNQ.solve();
		AllSolution.solve();
		
	}
	
}
