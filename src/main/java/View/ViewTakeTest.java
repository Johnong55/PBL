package View;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller_TakeTest;
import DAO.DeThi_dao;
import DAO.Sv_dao;
import model.Cauhoi;
import model.DeThi;
import model.KiThi;
import model.Sv;

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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JToggleButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class ViewTakeTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Controller_TakeTest cl = new Controller_TakeTest(this);
	Color Blue = new Color(17, 49, 123);
	Color BgBlue = new Color(203, 219, 248);
	Color Gray = new Color(122, 122, 129);
	Color Green = new Color(44, 173, 167);
	Color BgGreen = new Color(203, 248, 220);
	Color Black = new Color(0, 0, 0);
	Color BgBlack = new Color(227, 227, 227);
	Color Purple = new Color(249, 87, 139);
	Color BgPurple = new Color(253, 219, 230);
	JTextArea Cauhoi;

	public PanelRound panel_1;
	public MyButton btnCau1, btnExit, btnNext, mbtnCuTrc;
	public JLabel lblNewLabel_1;
	public ButtonGroup group = new ButtonGroup();
	public RadioButtonCustom btnDapAn_D, btnDapAn_A, btnDapAn_B, btnDapAn_C;
	public String cauhoi,dapanA,dapanB,dapanC,dapanD; int dapan;

	

	public Sv v ; public KiThi  ktOngoing; public DeThi dethi;
	public List<Cauhoi> listCauhoi = new ArrayList<Cauhoi>();
	public int vitriCauhoi = 0;

	public ViewTakeTest(Sv sv, KiThi onl) {
		this.v = sv;
		this.ktOngoing = Sv_dao.Instance().findKithiOnl(v);
		this.dethi = DeThi_dao.Instance().getDethi();
		listCauhoi = DeThi_dao.Instance().Hienthicauhoi(dethi);
		cauhoi = listCauhoi.get(0).getNoidung();
		dapanA = listCauhoi.get(0).getDapAnA();
		dapanB = listCauhoi.get(0).getDapAnB();
		dapanC = listCauhoi.get(0).getDapAnC();
		dapanD = listCauhoi.get(0).getDapAnD();
		dapan = listCauhoi.get(0).getDapan();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1299, 858);
		ViewTakeTest1();
		setVisible(true);
	}
	/**
	 * Launch the application.
	 */

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ViewTakeTest frame = new
	 * ViewTakeTest(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 */
	public void ViewTakeTest1() {
		
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
		panel_1.setBounds(47, 158, 819, 505);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel_1 = new JLabel("Question 1");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNewLabel_1.setForeground(Blue);
		lblNewLabel_1.setBounds(20, 10, 153, 37);
		panel_1.add(lblNewLabel_1);

		Cauhoi = new JTextArea();
		Cauhoi.setEditable(false);
		Cauhoi.setText(cauhoi);
		Cauhoi.setFont(new Font("Calibri", Font.BOLD, 24));
		Cauhoi.setBounds(20, 57, 581, 119);
		panel_1.add(Cauhoi);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 214, 729, 281);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(4, 1, 0, 15));

		btnDapAn_A = new RadioButtonCustom();
		btnDapAn_A.setText(dapanA);
		btnDapAn_A.setFont(new Font("Calibri", Font.BOLD, 20));
		btnDapAn_A.setBackground(Color.BLUE);
		group.add(btnDapAn_A);
		panel_2.add(btnDapAn_A);

		btnDapAn_B = new RadioButtonCustom();
		btnDapAn_B.setText(dapanB);
		btnDapAn_B.setFont(new Font("Calibri", Font.BOLD, 20));
		btnDapAn_B.setBackground(Color.BLUE);
		group.add(btnDapAn_B);
		panel_2.add(btnDapAn_B);

		btnDapAn_C = new RadioButtonCustom();
		btnDapAn_C.setText(dapanC);
		btnDapAn_C.setFont(new Font("Calibri", Font.BOLD, 20));
		btnDapAn_C.setBackground(Color.BLUE);
		group.add(btnDapAn_C);
		panel_2.add(btnDapAn_C);

		btnDapAn_D = new RadioButtonCustom();
		panel_2.add(btnDapAn_D);
		btnDapAn_D.setText(dapanD);
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
		panel_1_1.setBounds(896, 158, 379, 643);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);

		btnExit = new MyButton("New button");
		btnExit.addActionListener(cl);
		btnExit.setText("Lưu và thoát");
		btnExit.setBounds(93, 590, 204, 43);
		btnExit.setColor(Color.WHITE);
		btnExit.setForeground(Blue);
		panel_1_1.add(btnExit);
		btnExit.setRadius(20);
		btnExit.setFont(new Font("Verdana", Font.PLAIN, 19));

		JLabel Question_bank = new JLabel("Question bank");
		Question_bank.setForeground(new Color(17, 49, 123));
		Question_bank.setFont(new Font("Calibri", Font.BOLD, 26));
		Question_bank.setBounds(108, 10, 171, 37);
		panel_1_1.add(Question_bank);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 79, 359, 324);
		panel_1_1.add(panel_3);
		panel_3.setLayout(new GridLayout(5, 5, 10, 10));

		btnCau1 = new MyButton("New button");
		btnCau1.setColor(BgGreen);
		btnCau1.setFont(new Font("Calibri", Font.BOLD, 15));
		btnCau1.setRadius(20);
		btnCau1.setForeground(Green);
		panel_3.add(btnCau1);

		MyButton btnCau2 = new MyButton("New button");
		btnCau2.setRadius(20);
		btnCau2.setForeground(Blue);
		btnCau2.setFont(new Font("Calibri", Font.BOLD, 15));
		btnCau2.setColor(BgBlue);
		panel_3.add(btnCau2);

		MyButton btnCau3 = new MyButton("New button");
		btnCau3.setRadius(20);
		btnCau3.setForeground(Black);
		btnCau3.setFont(new Font("Calibri", Font.BOLD, 15));
		btnCau3.setColor(BgBlack);
		btnCau3.setBorderColor(BgBlack);
		panel_3.add(btnCau3);

		MyButton btnCau2_1 = new MyButton("New button");
		btnCau2_1.setRadius(20);
		btnCau2_1.setForeground(Purple);
		btnCau2_1.setFont(new Font("Calibri", Font.BOLD, 15));
		btnCau2_1.setColor(BgPurple);
		panel_3.add(btnCau2_1);

		JLabel lblCuTrLi = new JLabel("Câu trả lời:");
		lblCuTrLi.setForeground(new Color(0, 0, 0));
		lblCuTrLi.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCuTrLi.setBounds(192, 432, 98, 28);
		panel_1_1.add(lblCuTrLi);

		JLabel lblCuTrLi_1 = new JLabel("15/25");
		lblCuTrLi_1.setForeground(Blue);
		lblCuTrLi_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCuTrLi_1.setBounds(304, 432, 51, 28);
		panel_1_1.add(lblCuTrLi_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 469, 359, 9);
		panel_1_1.add(separator);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(Color.WHITE);
		panel_4_1.setBounds(10, 470, 359, 110);
		panel_1_1.add(panel_4_1);
		panel_4_1.setLayout(null);

		MyButton btnCau1_1 = new MyButton("New button");
		btnCau1_1.setText("1");
		btnCau1_1.setRadius(20);
		btnCau1_1.setForeground(new Color(44, 173, 167));
		btnCau1_1.setFont(new Font("Calibri", Font.BOLD, 18));
		btnCau1_1.setColor(new Color(203, 248, 220));
		btnCau1_1.setBounds(10, 10, 47, 47);
		panel_4_1.add(btnCau1_1);

		MyButton btnCau2_2 = new MyButton("New button");
		btnCau2_2.setText("1");
		btnCau2_2.setRadius(20);
		btnCau2_2.setForeground(new Color(17, 49, 123));
		btnCau2_2.setFont(new Font("Calibri", Font.BOLD, 18));
		btnCau2_2.setColor(new Color(203, 219, 248));
		btnCau2_2.setBounds(10, 63, 47, 47);
		panel_4_1.add(btnCau2_2);

		MyButton btnCau2_1_1 = new MyButton("New button");
		btnCau2_1_1.setText("1");
		btnCau2_1_1.setRadius(20);
		btnCau2_1_1.setForeground(new Color(249, 87, 139));
		btnCau2_1_1.setFont(new Font("Calibri", Font.BOLD, 18));
		btnCau2_1_1.setColor(new Color(253, 219, 230));
		btnCau2_1_1.setBounds(190, 10, 47, 47);
		panel_4_1.add(btnCau2_1_1);

		MyButton btnCau3_1 = new MyButton("New button");
		btnCau3_1.setText("25");
		btnCau3_1.setRadius(20);
		btnCau3_1.setForeground(Color.BLACK);
		btnCau3_1.setFont(new Font("Calibri", Font.BOLD, 18));
		btnCau3_1.setColor(BgBlack);
		btnCau3_1.setBorderColor(BgBlack);
		btnCau3_1.setBounds(190, 63, 47, 47);
		panel_4_1.add(btnCau3_1);

		JLabel lblNewLabel_2 = new JLabel("Đã trả lời");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_2.setBounds(67, 17, 80, 32);
		panel_4_1.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Đặt cờ");
		lblNewLabel_2_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(67, 68, 107, 32);
		panel_4_1.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Chưa trả lời");
		lblNewLabel_2_2.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(247, 17, 102, 32);
		panel_4_1.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("Chưa xem");
		lblNewLabel_2_3.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_2_3.setBounds(247, 70, 102, 32);
		panel_4_1.add(lblNewLabel_2_3);

		btnNext = new MyButton("New button");
		btnNext.setColorOver(new Color(114, 120, 231));
		btnNext.addActionListener(cl);
		btnNext.setText("Câu tiếp theo");
		btnNext.setRadius(20);
		btnNext.setColor(Blue);
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("Verdana", Font.PLAIN, 19));
		btnNext.setBounds(277, 686, 213, 54);
		contentPane.add(btnNext);

		mbtnCuTrc = new MyButton("New button");
		mbtnCuTrc.setText("Câu trước");
		mbtnCuTrc.addActionListener(cl);
		mbtnCuTrc.setRadius(20);
		mbtnCuTrc.setForeground(Blue);
		mbtnCuTrc.setFont(new Font("Verdana", Font.PLAIN, 19));
		mbtnCuTrc.setColor(Color.WHITE);
		mbtnCuTrc.setBounds(47, 686, 213, 54);
		contentPane.add(mbtnCuTrc);
	}
}
