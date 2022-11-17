package NQueenProblem;

import javax.swing.*;
import java.awt.*;
public class GUIAnimation extends JFrame{
    
        static int M = 5;
        static JLabel [][] jLabel = new JLabel[M][M];
        static String queen = "★";
    public GUIAnimation() throws InterruptedException{
        
        JFrame jFrame = new JFrame("NQueen GUI");
        jFrame.setLayout(new GridLayout(M, M));
        if(M>6) {
            jFrame.setSize(M*60, M*60);            
        }
        else if (M<7) {
            jFrame.setSize(M*80, M*80);
        }
 
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
 
        int color = 0;
        //String num;
        Font font = new Font("굴림", Font.PLAIN, 40);
        for(int i = 0; i < M; ++i) {
            if ((M%2) == 0 & (i%2) == 1)
                color=1;
            else if(M%2 == 0) 
                color = 0;
            for (int j = 0; j < M; ++j) {
                //num = Integer.toString(color);
                jLabel[i][j] = new JLabel( "" );
                jLabel[i][j].setFont(font);
                jLabel[i][j].setForeground(Color.yellow);
                jLabel[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                jLabel[i][j].setSize(50, 50);
                jLabel[i][j].setOpaque(true);
 
                jFrame.add(jLabel[i][j]);
                if(color == 0) {
                    jLabel[i][j].setBackground(Color.black);
                    ++color;
                }
                else if(color == 1) {
                    jLabel[i][j].setBackground(Color.WHITE);
                    --color;
                }
            }
        }
 
 
        jFrame.setVisible(true);
        
        GUIAnimation.solve(5);
    }
    static boolean check(int[][] board, int col) throws InterruptedException {   
        
        if (col >= M) {
            return true;
        }
    
        
        for (int i = 0; i < 5; i++) { //SolveNq로 뺴기
            if (IsSafe.checkSafe(board, i, col)) {  // 퀸이 위치할수 있는 위치를 체크
                board[i][col] = 1;
                jLabel[i][col].setText(queen);;  //위치가 가능하면 1로 셋팅
                Thread.sleep(1000);
                
               // Thread.sleep(800);
                if (GUIAnimation.check(board, col + 1) == true)
                {
                    return true;
                }
                else{ // 위치
                    board[i][col]=0;
                    jLabel[i][col].setText("");
                    Thread.sleep(1000);
                }
            }           
        }   
        return false;
    }

    static boolean solve(int boardSize) throws InterruptedException {
        int n = 5;
        int[][] board = new int[n][n]; //체스판 생성

        for (int i = 0; i < n; i++) {  //체스판 초기화
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
        GUIAnimation.check(board, 0);
        return true;
    }
    
    static public void main(String[] arg) throws InterruptedException {
        new GUIAnimation();
    }
}
