package NQueenProblem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class GUI extends JFrame {

    private JPanel contentPane;
    private JTextField boardsize;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI frame = new GUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    
    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 535, 287);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(12, 10, 498, 84);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("체스판의 크기를 입력해주세요");
        lblNewLabel.setBounds(12, 28, 263, 19);
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
        
        boardsize = new JTextField();
        boardsize.setBounds(287, 25, 96, 27);
        panel.add(boardsize);
        boardsize.setColumns(10);
        
        JButton btnInput = new JButton("입력");
        
        btnInput.setBounds(395, 25, 91, 27);
        panel.add(btnInput);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(12, 172, 497, 62);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lballsol = new JLabel();
        btnInput.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int n=Integer.parseInt(boardsize.getText());
                JOptionPane errormessage=new JOptionPane();
               int b=0;
               if(n<4||n>12) {
               errormessage.showMessageDialog(null, "잘못된 값을 입력하였습니다.");
               return;
               }
               NQueenTest.boardSize=n;
                try {
                    SolveNQ.solve(n);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                try {
                    new GUIAnimation();
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                lballsol.setText("총 해답의 개수는 "+AllSolution.solve(n)+"입니다.");
               
            }
        });
        lballsol.setFont(new Font("굴림", Font.BOLD, 18));
        lballsol.setBounds(12, 10, 290, 42);
        panel_1.add(lballsol);
    }
}