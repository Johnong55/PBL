package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.KiThi_dao;
import DAO.Sv_dao;
import model.Cauhoi;
import model.DeThi;
import model.KiThi;
import model.Sv;

import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewResultwithStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Color Blue=  new Color(17, 49, 123);
	Color Gray = new Color(122, 122, 129);
	Color Green = new Color(44, 173, 167);
	public MyButton btnNewButton;
	public Sv v;
	public KiThi ktOngoing;
	public String[] checkAnswer;
	public List<Cauhoi> listCauhoi = new ArrayList<Cauhoi>();
	public DeThi dethi;
	 public int socaudung = 0 , socausai = 0 ; public double diem;
	 public String dapan(int i) {
			String q = "";
			if(this.checkAnswer[i] == "A") q= this.listCauhoi.get(i).getDapAnA();
			if(this.checkAnswer[i] == "B") q= this.listCauhoi.get(i).getDapAnB();
			if(this.checkAnswer[i] == "C") q= this.listCauhoi.get(i).getDapAnC();
			if(this.checkAnswer[i] == "D") q= this.listCauhoi.get(i).getDapAnD();
			return q;

		}
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ViewResultwithStudent frame = new
	 * ViewResultwithStudent(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 */
	public ViewResultwithStudent(Sv sv, KiThi onl, DeThi dt, List<Cauhoi> ls, String[] answer) {	
		this.v = sv;
		this.ktOngoing = onl;
		this.dethi = dt;
		this.listCauhoi = ls;
		this.checkAnswer = answer;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 900, 700);
		ViewResult();
		setVisible(true);
	
	
	}
	public void ViewResult() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		panel.setBackground(Blue);
		panel.setBounds(0, 0, 884, 119);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(32, 22, 76, 75);
		lblNewLabel.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/logo.png"))
						.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH)));

		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Kết quả");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 40));
		lblNewLabel_1.setBounds(145, 36, 241, 60);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CHÚC MỪNG BẠN ĐÃ HOÀN THÀNH KÌ THI");
		lblNewLabel_1_1.setForeground(new Color(255, 0, 128));
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(160, 165, 553, 60);
		contentPane.add(lblNewLabel_1_1);
		
		PanelRound panel_3 = new PanelRound();
		panel_3.setRadius(160);
		panel_3.setBorderWidth(2);
		panel_3.setBorderColor(new Color(44, 173, 167));
		panel_3.setBounds(553, 279, 160, 160);
		contentPane.add(panel_3);
		panel_3.setLayout(new BorderLayout());
		
		double socau1 = listCauhoi.size();
		socau1 = 10/socau1;
		for(int i = 0 ; i < this.listCauhoi.size() ; i++) 
		{
			if(dapan(i).equals( this.listCauhoi.get(i).getDapan())) {this.socaudung++; this.diem+=socau1;}
			else this.socausai++;
		}
		JLabel lblNewLabel_4 = new JLabel(this.socaudung + "/" + this.listCauhoi.size());
		lblNewLabel_4.setVerticalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(44, 173, 167));
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 40));
		panel_3.add(lblNewLabel_4, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Kì thi :");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_2.setForeground(Gray);
		lblNewLabel_2.setBounds(160, 279, 82, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Thời gian :");
		lblNewLabel_2_1.setForeground(new Color(122, 122, 129));
		lblNewLabel_2_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(160, 365, 97, 35);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel(this.ktOngoing.getMota());
		lblNewLabel_2_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_2.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(204, 319, 309, 35);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("thoigian :");
		int hour = ktOngoing.getThoigianlambai() / 60;
		int minute = ktOngoing.getThoigianlambai() % 60;
		if(hour != 0) lblNewLabel_2_2_1.setText(String.valueOf(hour) + " tiếng " + String.valueOf(minute) + " phút") ;
		else lblNewLabel_2_2_1.setText(String.valueOf(minute) + " phút");
		lblNewLabel_2_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_2_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_2_2_1.setBounds(204, 404, 309, 35);
		contentPane.add(lblNewLabel_2_2_1);
		
		 btnNewButton = new MyButton("Thoát");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		ViewStudent frame = new ViewStudent(v);
		 		dispose();
		 		frame.setVisible(true);
		 		frame.view_home();
		 		frame.panel_4.removeAll();
				frame.panel_4.revalidate();
				frame.panel_4.repaint();		
				frame.cl.s.modeltb.setRowCount(0);
				frame.cl.setPanel_4();
				frame.cl.hienthi();
				frame.view_test();

		 	}
		 });
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setRadius(20);
		btnNewButton.setColorOver(new Color(44, 173, 167));
		btnNewButton.setBounds(586, 510, 127, 34);
		contentPane.add(btnNewButton);
	}
}
