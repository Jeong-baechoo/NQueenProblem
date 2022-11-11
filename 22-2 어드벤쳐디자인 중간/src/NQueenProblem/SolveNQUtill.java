package NQueenProblem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SolveNQUtill 
{
    static int CheckInputcheckInputInteger(Scanner s, String msg) {
        int n=0;
        boolean valid; // 유효한 값 입력 확인
        do {
            valid = true;
            System.out.print(msg);

            try {
                n = s.nextInt(); // 정수 입력
            }
            catch(InputMismatchException e) { // 정수 입력 확인
                System.out.println("3과 13사이의 정수를 입력하세요.");
                s.next(); // 입력 스트림에 있는 정수가 아닌 토큰을 버린다.
                valid = false;
            }
        } while(!valid);
        
        
        return n;
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