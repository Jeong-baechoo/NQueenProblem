package NQueenProblem;

import javax.swing.*;
import java.awt.*;
public class GUIAnimation extends JFrame{
    final static int M = 13;
    static JLabel [][] jLabel = new JLabel[M][M];
    
    public GUIAnimation() throws InterruptedException{
        JFrame jFrame = new JFrame("NQueen GUI");
        
        jFrame.setLayout(new GridLayout(M, M));
        jFrame.setSize(M*50, M*50);
 
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
 
        int color = 0;
        //String num;
        String queen = "★";
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
        
        for(int i = 0; i < M; ++i) {
            for (int j = 0; j < M; ++j) {
                jLabel[i][j].setText(queen);
                Thread.sleep(50);
            }
        }
        
        for(int i = 0; i < M; ++i) {
            for (int j = 0; j < M; ++j) {
                jLabel[i][j].setText("");
                Thread.sleep(50);
            }
        }
    }
    
    
    static public void main(String[] arg) throws InterruptedException {
        new GUIAnimation();
    }
}
