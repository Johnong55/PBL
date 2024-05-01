package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.Sv_dao;
import model.Cauhoi;
import model.DeThi;
import model.KiThi;
import model.Sv;

public class CompleteTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Color Blue = new Color(17, 49, 123);
	Color Gray = new Color(122, 122, 129);
	Color Green = new Color(44, 173, 167);
	Color purple = new Color(221, 0, 221);
	MyButton btnNewButton;
	public Sv v;
	public KiThi ktOngoing;
	public String[] checkAnswer;
	public List<Cauhoi> listCauhoi = new ArrayList<Cauhoi>();
	public DeThi dethi;

	public CompleteTest(Sv sv, KiThi onl, DeThi dt, List<Cauhoi> ls, String[] answer) {
		this.v = sv;
		this.ktOngoing = Sv_dao.Instance().findKithiOnl(v);
		this.dethi = dt;
		this.listCauhoi = ls;
		this.checkAnswer = answer;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 1000, 700);
		CompleteTest1();
		setVisible(true);
	}

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { CompleteTest frame = new
	 * CompleteTest(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 */
	public void CompleteTest1() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Blue);
		panel.setBounds(0, 0, 984, 122);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên bài kiểm tra");
		lblNewLabel.setText(ktOngoing.getMota());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(37, 68, 275, 43);
		panel.add(lblNewLabel);

		JLabel lblH = new JLabel("1 tiếng 46 phút");
		int hour = ktOngoing.getThoigianlambai() / 60;
		int minute = ktOngoing.getThoigianlambai() % 60;
		if (hour != 0)
			lblH.setText(String.valueOf(hour) + " tiếng " + String.valueOf(minute) + " phút");
		else
			lblH.setText(String.valueOf(minute) + " phút");
		lblH.setForeground(Color.WHITE);
		lblH.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblH.setBounds(730, 68, 227, 43);
		panel.add(lblH);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(399, 184, 214, 200);
		lblNewLabel_1.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/CompleteExam.png"))
						.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(lblNewLabel_1);

		JLabel lblBtuLm = new JLabel("Bạn đã hoàn thành bài thi");
		lblBtuLm.setForeground(new Color(0, 0, 0));
		lblBtuLm.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBtuLm.setBounds(347, 399, 354, 43);
		contentPane.add(lblBtuLm);

		btnNewButton = new MyButton("Bắt Đầu");
		btnNewButton.setText("Kết quả ");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewResult frame = new ViewResult(v,ktOngoing,dethi,listCauhoi,checkAnswer);
				frame.setVisible(true);
	        	dispose();
			}
		});

		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setColorOver(purple);
		btnNewButton.setBorderColor(Blue);
		btnNewButton.setColor(Blue);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setRadius(20);
		btnNewButton.setBounds(452, 453, 115, 43);
		contentPane.add(btnNewButton);

	}

}
