package NQueenProblem;

public class SolveNQ {
	static boolean check(int[][] board, int col) throws InterruptedException {   
				
	    if (col >= NQueenTest.boardSize) {
            return true;
        }
    
        
        for (int i = 0; i < NQueenTest.boardSize; i++) { //SolveNq로 뺴기
            if (IsSafe.checkSafe(board, i, col)) {  // 퀸이 위치할수 있는 위치를 체크
                board[i][col] = 1;  //위치가 가능하면 1로 셋팅
                PrintSolution.print(board);
                Thread.sleep(800);
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

    static boolean solve(int boardSize) throws InterruptedException {
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
// static int currentPositon = 0; //행
// 	static int queen = 0;
// if (SolveNQ.check(board, 0) == false) { // 에러처리
// 	System.out.println("Solution does not exist");
// 	return false;
// }

// static boolean backTracking(int[][] board, Stack<Integer> stack,int row,int col){
// 	currentPositon --;
// 	col ++;
// 	queen = stack.pop(); // pop을 하고 이전 퀸의 위치를 저장
// 	board[currentPositon][queen] = 0;
	
// if((int)stack.get(row) == NQueenTest.boardSize - 1){ //백트랙킹을 한 후 이전 행에서의 퀸의 위치또한 마지막 열일 경우
// 	backTracking(board, stack, row, col);
// 	return true;
// }
// return false;
// }
// PrintSolution.print(board);

// static boolean check(int[][] board, int col) {   재귀적인 방법
			
// 	if (col >= NQueenTest.boardSize)  // 행이 
// 		return true;
// 	for (int i = 0; i < NQueenTest.boardSize; i++) { //SolveNq로 뺴기
// 		if (IsSafe.checkSafe(board, i, col)) {  // 퀸이 위치할수 있는 위치를 체크
// 			board[i][col] = 1;  //위치가 가능하면 1로 셋팅

// 			if (SolveNQ.check(board, col + 1) == true)
// 				return true;
				
// 			else{ // 위치
// 				board[i][col] = 0;
// 			}
				
// 		}			
// 	}	
// 	return false;
// }

// 기본적인 아이디어 : 끝열까지 검사했을때 불가능하면 백트랙킹, 이전 퀸이 끝열에 위치했을때 앞에서 백트랙킹이 발생했으면 백트랙킹
// while(!SolveNQUtill.CheckFinsh(stack.size())){
// 	for (int col = 0; col < n; col++) { // 열 체크 
		
// 		if(IsSafe.checkSafe(board, currentPositon, col)){ //안전함
// 			board[currentPositon][col] = 1;
// 			stack.push(col); 
// 			currentPositon++; // 다음행으로 이동
// 		}
// 		else{ // 충돌발생
// 			if(col == n - 1){ //1. 끝 열까지 검사했을때 백트랙킹
// 					backTracking(board, stack, n, col);
// 			}
// 		}
// 	}
// }