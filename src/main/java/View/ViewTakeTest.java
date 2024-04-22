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
import model.BaiLam;
import model.Cauhoi;
import model.DeThi;
import model.KiThi;
import model.Sv;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.GroupLayout.Group;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

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
	public JTextArea Cauhoi;public BaiLam bailam1;

	public PanelRound panel_1;
	public MyButton btnCau1, btnExit, btnNext, mbtnCuTrc,btnTL,btnCTL,btnCX;
	public JLabel lblNewLabel_1,lblNewLabel,lblH,soCauTraLoi;
	public ButtonGroup group = new ButtonGroup();
	public RadioButtonCustom btnDapAn_D = new RadioButtonCustom(), btnDapAn_A = new RadioButtonCustom(),
			btnDapAn_B = new RadioButtonCustom(), btnDapAn_C = new RadioButtonCustom();
	public String cauhoi, dapanA, dapanB, dapanC, dapanD, dapan;
	public JScrollPane scrollPane;
	public JPanel panel_3 = new JPanel();
	public List<MyButton> listBtnCauhoi = new ArrayList<MyButton>();
	public int[] checkView;
	public String[] checkAnswer;
	public ButtonModel[] selectButton;
	public Sv v;
	public KiThi ktOngoing;
	public DeThi dethi;
	public List<Cauhoi> listCauhoi = new ArrayList<Cauhoi>();
	
	public int vitriCauhoi = 0 , soCauDaXem = 0;

	public void setMau(int mau, MyButton btn) {

		if (mau == 1) {
			btn.setRadius(20);
			btn.setForeground(Black);
			btn.setFont(new Font("Calibri", Font.BOLD, 17));
			btn.setColor(BgBlack);
			btn.setBorderColor(BgBlack);
			btn.setPreferredSize(new Dimension(40, 40));

		} else if (mau == 2) {
			btn.setColor(BgGreen);
			btn.setForeground(Green);
			btn.setBorderColor(Green);
		} else if (mau == 3) {
			btn.setForeground(Purple);
			btn.setColor(BgPurple);
			btn.setBorderColor(Purple);
		} else if (mau == 4) {
			btn.setForeground(Blue);
			btn.setColor(BgBlue);
		}

	}

	public ViewTakeTest(Sv sv, KiThi onl) {
		
		this.v = sv;
		bailam1 = new BaiLam();
	 	bailam1.setSv(this.v);
		bailam1.setKiThi(onl);
		bailam1.createbailam();
		this.ktOngoing = onl;
		this.dethi = bailam1.getDethi();
		listCauhoi = this.dethi.getList();/* DeThi_dao.Instance().Hienthicauhoi(dethi); */
		for(int i = 1 ; i <= listCauhoi.size();i++) {
			listBtnCauhoi.add(new MyButton(String.valueOf(i))); setMau(1, listBtnCauhoi.get(i-1));
			panel_3.add(listBtnCauhoi.get(i - 1));
			listBtnCauhoi.get(i-1).addActionListener(cl);
		}
		panel_3.setPreferredSize(new Dimension(359, (48+40) * (listBtnCauhoi.size() / 5) + 30)); //(48 + 40 ) * n + 30; 
		checkAnswer = new String[listCauhoi.size()]; Arrays.fill(checkAnswer,"0");
		checkView = new int[checkAnswer.length]; Arrays.fill(checkView,0);
		selectButton = new ButtonModel[checkAnswer.length];
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

		lblNewLabel = new JLabel("Tên kì thi");
		lblNewLabel.setText(ktOngoing.getMota());
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 32));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(38, 73, 274, 45);
		panel.add(lblNewLabel);

		lblH = new JLabel("1 tiếng 46 phút");
		int hour = ktOngoing.getThoigianlambai() / 60;
		int minute = ktOngoing.getThoigianlambai() % 60;
		if(hour != 0) lblH.setText(String.valueOf(hour) + " tiếng " + String.valueOf(minute) + " phút") ;
		else lblH.setText(String.valueOf(minute) + " phút");
		lblH.setForeground(Color.WHITE);
		lblH.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblH.setBounds(1013, 68, 227, 43);
		panel.add(lblH);

		panel_1 = new PanelRound();
		panel_1.setRadius(20);
		panel_1.setBounds(47, 158, 819, 505);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel_1 = new JLabel("Câu hỏi 1");
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

		double socau1 = listCauhoi.size();
		socau1 = 10/socau1;
		JLabel labelDiem = new JLabel( String.format("%.3f", socau1) + " điểm");
		labelDiem.setForeground(Green);
		labelDiem.setFont(new Font("Calibri", Font.BOLD, 22));
		labelDiem.setBounds(702, 15, 107, 28);
		panel_1.add(labelDiem);

		PanelRound panel_1_1 = new PanelRound();
		panel_1_1.setRadius(20);
		panel_1_1.setBounds(896, 158, 379, 643);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);

		btnExit = new MyButton("New button");
		btnExit.setColorClick(new Color(149, 159, 253));
		btnExit.addActionListener(cl);
		btnExit.setText("Lưu và thoát");
		btnExit.setBounds(93, 590, 204, 43);
		btnExit.setColor(Color.WHITE);
		btnExit.setForeground(Blue);
		panel_1_1.add(btnExit);
		btnExit.setRadius(20);
		btnExit.setFont(new Font("Verdana", Font.PLAIN, 19));

		JLabel Question_bank = new JLabel("Mục lục câu hỏi");
		Question_bank.setForeground(new Color(17, 49, 123));
		Question_bank.setFont(new Font("Calibri", Font.BOLD, 26));
		Question_bank.setBounds(108, 10, 171, 37);
		panel_1_1.add(Question_bank);

		panel_3.setForeground(new Color(255, 255, 255));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 26, 24));
		
		int socau = listCauhoi.size()  % 5; 
		if(socau != 0) socau = listCauhoi.size() / 5 + 1; else socau = listCauhoi.size() / 5;
		
		panel_3.setPreferredSize(new Dimension(359, (48 + 40) * socau + 30)); //(48 + 40 ) * n + 30;
		  
		panel_3.setBorder(null);

		scrollPane = new JScrollPane(panel_3);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 50, 359, 324);
		scrollPane.addMouseWheelListener(cl);
		scrollPane.setBorder(null);

		panel_1_1.add(scrollPane);
//////////---------------
//		btnCau1 = new MyButton("1");
//		btnCau1.setPreferredSize(new Dimension(40, 40));
//		btnCau1.setColor(BgGreen);
//		btnCau1.setForeground(Green);
//		btnCau1.setFont(new Font("Calibri", Font.BOLD, 15));
//		btnCau1.setRadius(20);
//		panel_3.add(btnCau1);

		JLabel lblCuTrLi = new JLabel("Câu trả lời:");
		lblCuTrLi.setForeground(new Color(0, 0, 0));
		lblCuTrLi.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCuTrLi.setBounds(192, 432, 98, 28);
		panel_1_1.add(lblCuTrLi);

		 soCauTraLoi = new JLabel("0/" + String.valueOf(listBtnCauhoi.size()));
		soCauTraLoi.setForeground(Blue);
		soCauTraLoi.setFont(new Font("Calibri", Font.BOLD, 20));
		soCauTraLoi.setBounds(304, 432, 51, 28);
		panel_1_1.add(soCauTraLoi);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 469, 359, 9);
		panel_1_1.add(separator);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(Color.WHITE);
		panel_4_1.setBounds(10, 470, 359, 110);
		panel_1_1.add(panel_4_1);
		panel_4_1.setLayout(null);

		btnTL = new MyButton("New button");
		btnTL.setEnabled(false);
		btnTL.setText("0");
		btnTL.setRadius(20);
		btnTL.setForeground(new Color(44, 173, 167));
		btnTL.setFont(new Font("Calibri", Font.BOLD, 18));
		btnTL.setColor(new Color(203, 248, 220));
		btnTL.setBounds(10, 10, 47, 47);
		panel_4_1.add(btnTL);

		/*
		 * MyButton btnCau2_2 = new MyButton("New button"); btnCau2_2.setText("1");
		 * btnCau2_2.setRadius(20); btnCau2_2.setForeground(new Color(17, 49, 123));
		 * btnCau2_2.setFont(new Font("Calibri", Font.BOLD, 18)); btnCau2_2.setColor(new
		 * Color(203, 219, 248)); btnCau2_2.setBounds(10, 63, 47, 47);
		 * panel_4_1.add(btnCau2_2);
		 */
		btnCTL = new MyButton("New button");
		btnCTL.setEnabled(false);
		btnCTL.setText("0");
		btnCTL.setRadius(20);
		btnCTL.setForeground(new Color(249, 87, 139));
		btnCTL.setFont(new Font("Calibri", Font.BOLD, 18));
		btnCTL.setColor(new Color(253, 219, 230));
		btnCTL.setBounds(190, 10, 47, 47);
		panel_4_1.add(btnCTL);

		btnCX = new MyButton("New button");
		btnCX.setEnabled(false);
		btnCX.setText(String.valueOf(listBtnCauhoi.size()));
		btnCX.setRadius(20);
		btnCX.setForeground(Color.BLACK);
		btnCX.setFont(new Font("Calibri", Font.BOLD, 18));
		btnCX.setColor(BgBlack);
		btnCX.setBorderColor(BgBlack);
		btnCX.setBounds(77, 60, 47, 47);
		panel_4_1.add(btnCX);

		JLabel lblNewLabel_2 = new JLabel("Đã trả lời");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_2.setBounds(67, 17, 80, 32);
		panel_4_1.add(lblNewLabel_2);

		/*
		 * JLabel lblNewLabel_2_1 = new JLabel("Đặt cờ"); lblNewLabel_2_1.setFont(new
		 * Font("Calibri", Font.BOLD, 20)); lblNewLabel_2_1.setBounds(67, 68, 107, 32);
		 * panel_4_1.add(lblNewLabel_2_1);
		 */

		JLabel lblNewLabel_2_2 = new JLabel("Chưa trả lời");
		lblNewLabel_2_2.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(247, 17, 102, 32);
		panel_4_1.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("Chưa xem");
		lblNewLabel_2_3.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_2_3.setBounds(134, 67, 102, 32);
		panel_4_1.add(lblNewLabel_2_3);

		btnNext = new MyButton("New button");
		btnNext.setColorOver(new Color(45, 49, 225));
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
