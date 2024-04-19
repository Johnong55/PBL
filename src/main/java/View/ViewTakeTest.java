package View;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout.Group;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JToggleButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class ViewTakeTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Color Blue=  new Color(17, 49, 123);
	Color Gray = new Color(122, 122, 129);
	Color Green = new Color(44, 173, 167);
	Color purple = new Color(221, 0, 221);
	PanelRound panel_1;
	MyButton btnPrevious;
	JLabel lblNewLabel_1;
	ButtonGroup group = new ButtonGroup();
	RadioButtonCustom btnDapAn_D,btnDapAn_A,btnDapAn_B,btnDapAn_C;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTakeTest frame = new ViewTakeTest();
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
	public ViewTakeTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1300, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Blue);
		panel.setBounds(0, 0, 1286, 122);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên bài kiểm tra");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 32));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(38, 73, 274, 45);
		panel.add(lblNewLabel);
		
		JLabel lblH = new JLabel("1 tiếng 46 phút");
		lblH.setForeground(Color.WHITE);
		lblH.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblH.setBounds(1013, 68, 227, 43);
		panel.add(lblH);
		
		panel_1 = new PanelRound();
		panel_1.setRadius(20);
		panel_1.setBounds(47, 158, 821, 520);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Question 1");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNewLabel_1.setForeground(Blue);
		lblNewLabel_1.setBounds(20, 10, 153, 37);
		panel_1.add(lblNewLabel_1);
		
		JTextArea txtrChaoCacsBan = new JTextArea();
		txtrChaoCacsBan.setText("chào các bạn");
		txtrChaoCacsBan.setFont(new Font("Calibri", Font.BOLD, 22));
		txtrChaoCacsBan.setBounds(20, 57, 581, 119);
		panel_1.add(txtrChaoCacsBan);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 229, 729, 281);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(4,1,0,15));
		
		btnDapAn_A = new RadioButtonCustom();
		btnDapAn_A.setText("Dap an A");
		btnDapAn_A.setFont(new Font("Calibri", Font.BOLD, 20));
		btnDapAn_A.setBackground(Color.BLUE);
		group.add(btnDapAn_A);
		panel_2.add(btnDapAn_A);
		
		btnDapAn_B = new RadioButtonCustom();
		btnDapAn_B.setText("Dap an A");
		btnDapAn_B.setFont(new Font("Calibri", Font.BOLD, 20));
		btnDapAn_B.setBackground(Color.BLUE);
		group.add(btnDapAn_B);
		panel_2.add(btnDapAn_B);
		
		btnDapAn_C = new RadioButtonCustom();
		btnDapAn_C.setText("Dap an A");
		btnDapAn_C.setFont(new Font("Calibri", Font.BOLD, 20));
		btnDapAn_C.setBackground(Color.BLUE);
		group.add(btnDapAn_C);
		panel_2.add(btnDapAn_C);
		
		btnDapAn_D = new RadioButtonCustom();
		panel_2.add(btnDapAn_D);
		btnDapAn_D.setText("Dap an A");
		btnDapAn_D.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDapAn_D.setBackground(new Color(0, 0, 255));
		btnDapAn_D.setFont(new Font("Calibri", Font.BOLD, 20));
		group.add(btnDapAn_D);
		
		JLabel labelDiem = new JLabel("3 điểm");
		labelDiem.setForeground(Green);
		labelDiem.setFont(new Font("Calibri", Font.BOLD, 22));
		labelDiem.setBounds(720, 15, 91, 28);
		panel_1.add(labelDiem);
		
		PanelRound panel_1_1 = new PanelRound();
		panel_1_1.setRadius(20);
		panel_1_1.setBounds(904, 158, 349, 674);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		MyButton btnprevious_2 = new MyButton("New button");
		btnprevious_2.setBounds(60, 620, 204, 43);
		panel_1_1.add(btnprevious_2);
		btnprevious_2.setRadius(20);
		btnprevious_2.setFont(new Font("Verdana", Font.PLAIN, 19));
		
		JLabel Question_bank = new JLabel("Question bank");
		Question_bank.setForeground(new Color(17, 49, 123));
		Question_bank.setFont(new Font("Calibri", Font.BOLD, 26));
		Question_bank.setBounds(80, 10, 171, 37);
		panel_1_1.add(Question_bank);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 79, 329, 324);
		panel_1_1.add(panel_3);
		panel_3.setLayout(new GridLayout(5, 5, 10,10));
		
		JLabel lblCuTrLi = new JLabel("Câu trả lời:");
		lblCuTrLi.setForeground(new Color(0, 0, 0));
		lblCuTrLi.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCuTrLi.setBounds(182, 413, 98, 28);
		panel_1_1.add(lblCuTrLi);
		
		JLabel lblCuTrLi_1 = new JLabel("15/25");
		lblCuTrLi_1.setForeground(Blue);
		lblCuTrLi_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCuTrLi_1.setBounds(288, 413, 51, 28);
		panel_1_1.add(lblCuTrLi_1);
		
		btnPrevious = new MyButton("New button");
		btnPrevious.setText("Câu trước");
		btnPrevious.setFont(new Font("Verdana", Font.PLAIN, 19));
		btnPrevious.setRadius(20);
		btnPrevious.setBounds(47, 712, 204, 43);
		contentPane.add(btnPrevious);
		
		MyButton btnNext = new MyButton("New button");
		btnNext.setText("Câu tiếp theo");
		btnNext.setRadius(20);
		btnNext.setFont(new Font("Verdana", Font.PLAIN, 19));
		btnNext.setBounds(275, 712, 204, 43);
		contentPane.add(btnNext);
	}
}
