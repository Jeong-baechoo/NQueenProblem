package NQueenProblem;

public class SolveNQUtill 
{
	static boolean CheckInput(){ //입력받은 값이 유효한 값인지 체크
		if(NQueenTest.boardSize < 4 || NQueenTest.boardSize > 20)
		{
			System.out.print("다시 입력해주십시오: ");
			return false;
		}
		return true;
		
	}

	static boolean CheckFinsh(int stackSize)
	{
		if(stackSize == NQueenTest.boardSize){
			return true;
		}
		return false;
	}

}

// 인풋체크
// 보드판 완성이 됐는지 확인하는 기능