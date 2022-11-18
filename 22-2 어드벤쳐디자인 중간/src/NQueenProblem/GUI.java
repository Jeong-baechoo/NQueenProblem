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
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;



public class GUI extends JFrame{

    private JPanel contentPane;
    private JTextField boardsize;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        GUI frame = new GUI();
    }

    /**
     * Create the frame.
     */
    
    public GUI()  {
        setTitle("NQueenGUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 714, 431);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(12, 10, 592, 68);
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
        panel_1.setBounds(12, 311, 675, 62);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lballsol = new JLabel();
        lballsol.setBounds(12, 10, 651, 42);
        panel_1.add(lballsol);
        lballsol.setFont(new Font("굴림", Font.BOLD, 18));
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(12, 88, 675, 119);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        setVisible(true);
        
        JLabel lblNewLabel_1 = new JLabel("총 해답의 갯수는 16까지만 계산을 합니다. 보드의 생성은 27까지 가능합니다.");
        lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 14));
        lblNewLabel_1.setBounds(12, 10, 606, 23);
        panel_2.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("체스판의 크기가 16일 경우는 약 5분정도의 시간이 소요되며 15의 경우 2분정도 소요됩니다.");
        lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 14));
        lblNewLabel_2.setBounds(12, 43, 639, 31);
        panel_2.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("위 소요시간은 사용자의 PC환경에 따라 변동이 있을 수 있습니다.");
        lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 14));
        lblNewLabel_3.setBounds(12, 77, 606, 32);
        panel_2.add(lblNewLabel_3);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(12, 214, 676, 87);
        contentPane.add(panel_3);
        panel_3.setLayout(null);
        
        JSlider slider = new JSlider();
        slider.setValue(150);
        slider.setSnapToTicks(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMinorTickSpacing(10);
        slider.setMajorTickSpacing(100);
        slider.setMaximum(300);
        slider.setBounds(12, 10, 652, 67);
        panel_3.add(slider);
        
        btnInput.addMouseListener(new MouseAdapter() {
            int n = 0;
            JOptionPane errormessage=new JOptionPane();
            public void mouseClicked(MouseEvent e) {
                try {
                    n = Integer.parseInt(boardsize.getText());                    
                }
                catch (NumberFormatException n) {
                    errormessage.showMessageDialog(null, "잘못된 값을 입력하였습니다.");
                    return;
               }
                if(n<4||n>27) {
                errormessage.showMessageDialog(null, "잘못된 값을 입력하였습니다.");
                return;
                }
                else if (n>16 && n<28) {
                    lballsol.setText("총 해답의 개수는 보드판의 크기가 16이하일때 작동합니다");
                }
                NQueenTest.boardSize = n;
               
               
                try {
                    new GUIAnimation(); // 애니메이션 실
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                if (n>4 && n<17) {
                    GuiThread thd = new GuiThread(lballsol);
                    thd.start();
                }
            }
        });
        
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int sleep = slider.getValue();
                GUIAnimation.time = sleep;
            }
        });
        
    }
}
class GuiThread extends Thread{
    int n = NQueenTest.boardSize;
    JLabel jlb;
    public GuiThread(JLabel lballsol) {
        jlb = lballsol;
    }
    public void run() {
        jlb.setText("총 해답의 개수는 "+AllSolution.solve(n)+"입니다.");
        super.run();
    }
}