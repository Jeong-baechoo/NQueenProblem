package NQueenProblem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
public class GUIAnimation extends JFrame {    
        static int M  = NQueenTest.boardSize;
        static JLabel [][] jLabel = new JLabel[M][M];
        static String queen = "★";
        Font font = new Font("굴림", Font.PLAIN, 40);
        Font fontS = new Font("굴림", Font.PLAIN, 20);
        static int time = 150;
        
    public GUIAnimation() throws InterruptedException{
        JFrame jFrame = new JFrame("NQueen GUI");
        jFrame.setLayout(new GridLayout(M, M)); // 체스판 그
        if(M>6 && M<13) {
            jFrame.setSize(M*60, M*60);            
        }
        else if (M<7) {
            jFrame.setSize(M*80, M*80);
        }
        else if (M>12) {
            jFrame.setSize(M*30, M*30);
        }
 
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
 
        int color = 0;
        //String num;
        for(int i = 0; i < M; ++i) {
            if ((M%2) == 0 & (i%2) == 1)
                color=1;
            else if(M%2 == 0) 
                color = 0;
            for (int j = 0; j < M; ++j) {
                //num = Integer.toString(color);
                jLabel[i][j] = new JLabel( "" );
                if (M>12) {
                    jLabel[i][j].setFont(fontS);                    
                }
                else if (M<13) {
                    jLabel[i][j].setFont(font);
                }
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
        MyThread myThread = new MyThread();
        myThread.start();
    }

    

    
    static boolean check(int[][] board, int col) throws InterruptedException {

        if (col >= M) {
            return true;
        }
    
      
        for (int i = 0; i < M; i++) { //SolveNq로 뺴기
            jLabel[i][col].setText(queen);
            if(time != 0) {
                for(int k=0; k<=time; k++) {
                    Thread.sleep(1);                    
                }
            }
            if(!IsSafe.checkSafe(board, i, col)){
                jLabel[i][col].setText("");
                
            }
            if (IsSafe.checkSafe(board, i, col)) {  // 퀸이 위치할수 있는 위치를 체크
                board[i][col] = 1;
                    //위치가 가능하면 1로 셋팅
                
               // Thread.sleep(800);
                if (GUIAnimation.check(board, col + 1) == true)
                {
                    
                    return true;
                }
                else{ // 위치
                    board[i][col]=0;
                    jLabel[i][col].setText("");
                    
                }
            }
        }   
        return false;
    }
   



    static boolean solve() throws InterruptedException {
        int n = NQueenTest.boardSize;
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
class MyThread extends Thread{
    @Override
    public void run() {
        try {
            GUIAnimation.solve();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        super.run();
    }
}
