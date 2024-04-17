package View;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controller.Controller_Student;

public class ViewStudent extends JFrame {
	
	Controller_Student cl = new Controller_Student(this);
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Color Blue=  new Color(17, 49, 123);
	Color Gray = new Color(122, 122, 129);
	Color Green = new Color(44, 173, 167);
	public JPanel panel_4 = new JPanel();
	public MyButton BtnHome, btnTests,btnProfile, btnChangePer, BtnChangeImagePer;
	public MyButton mbtnSetReminder, mbtnBtuLm;

	PanelRound panel_1;
	public JTextField textField;
	public JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStudent frame = new ViewStudent();
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
	public void view_home() {
		
		PanelRound panel_1 = new PanelRound(15);
		panel_1.setBorderColor(Gray);
		panel_1.setBounds(10, 11, 694, 123);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hello ,");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 11, 96, 26);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Hôm nay,");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(511, 11, 96, 26);
		panel_1.add(lblNewLabel_1);
		
		LocalDate date = LocalDate.now();
		String formatdate = date.format(DateTimeFormatter.ofPattern("dd 'tháng' M, yyyy"));
		JLabel lblNewLabel_2 = new JLabel(formatdate);
		lblNewLabel_2.setBounds(511, 38, 96, 14);
		panel_1.add(lblNewLabel_2);
		
		PanelRound panel_2 = new PanelRound(15);
		panel_2.setBorderColor(Gray);
		panel_2.setBounds(10, 145, 694, 267);
		panel_2.setLayout(null);
		
		JLabel clock_image = new JLabel("");
		clock_image.setBounds(10, 0, 245, 245);
		clock_image.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/clock.png"))
						.getScaledInstance(clock_image.getWidth(), clock_image.getHeight(), Image.SCALE_SMOOTH)));
		
		panel_2.add(clock_image);
		
		JLabel lblNewLabel_3 = new JLabel("Bài kiểm tra sắp diễn ra !!");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_3.setBounds(361, 11, 263, 41);
		lblNewLabel_3.setForeground(Blue);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(10, 264, 46, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Test :");
		lblNewLabel_5.setForeground(Gray);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5.setBounds(361, 63, 46, 20);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Day :");
		lblNewLabel_5_1.setForeground(Gray);
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5_1.setBounds(361, 105, 46, 20);
		panel_2.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Time :");
		lblNewLabel_5_2.setForeground(Gray);
		lblNewLabel_5_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5_2.setBounds(361, 152, 46, 20);
		panel_2.add(lblNewLabel_5_2);
		
		//----- can thon tin thoi gian cb thi
		JLabel lblNewLabel_6 = new JLabel("Name");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(433, 62, 158, 20);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Name");
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_6_1.setBounds(433, 104, 158, 20);
		panel_2.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Name");
		lblNewLabel_6_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_6_2.setBounds(433, 151, 158, 20);
		panel_2.add(lblNewLabel_6_2);
		
		//--------------
		
		mbtnSetReminder = new MyButton("");
		mbtnSetReminder.setText("Cài đặt nhắc nhở");
		mbtnSetReminder.setRadius(15);
		mbtnSetReminder.setForeground(Color.WHITE);
		mbtnSetReminder.setFont(new Font("Tahoma", Font.BOLD, 15));
		mbtnSetReminder.setColorOver(new Color(88, 141, 220));
		mbtnSetReminder.setColorClick(new Color(150, 207, 250));
		mbtnSetReminder.setColor(Green);
		mbtnSetReminder.setBorderColor(Green);
		mbtnSetReminder.setBounds(396, 208, 195, 37);
		panel_2.add(mbtnSetReminder);
		
		PanelRound panel_3 = new PanelRound(15);
		panel_3.setBorderColor(Gray);
		panel_3.setBounds(10, 445, 694, 184);
		panel_3.setLayout(null);
		
		JLabel clock_image_1 = new JLabel("");
		clock_image_1.setBounds(10, 11, 167, 162);
		clock_image_1.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/exam.png"))
						.getScaledInstance(clock_image_1.getWidth(), clock_image_1.getHeight(), Image.SCALE_SMOOTH)));
		panel_3.add(clock_image_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Bài kiểm tra đang diễn ra !");
		lblNewLabel_3_1.setForeground(new Color(17, 49, 123));
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_3_1.setBounds(286, 11, 254, 35);
		panel_3.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_6_3 = new JLabel("Name");
		lblNewLabel_6_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_6_3.setForeground(Gray);
		lblNewLabel_6_3.setBounds(286, 57, 158, 20);
		panel_3.add(lblNewLabel_6_3);
		
		JLabel lblNewLabel_6_4 = new JLabel("Name");
		lblNewLabel_6_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_6_4.setForeground(Gray);
		lblNewLabel_6_4.setBounds(357, 88, 158, 20);
		panel_3.add(lblNewLabel_6_4);
		
		JLabel lblNewLabel_6_5 = new JLabel("Name");
		lblNewLabel_6_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_6_5.setForeground(Gray);
		lblNewLabel_6_5.setBounds(511, 57, 158, 20);
		panel_3.add(lblNewLabel_6_5);
		
		mbtnBtuLm = new MyButton("");
		mbtnBtuLm.setText("Bắt đầu làm bài");
		mbtnBtuLm.setRadius(15);
		mbtnBtuLm.setForeground(Color.WHITE);
		mbtnBtuLm.setFont(new Font("Tahoma", Font.BOLD, 15));
		mbtnBtuLm.setColorOver(new Color(88, 141, 220));
		mbtnBtuLm.setColorClick(new Color(150, 207, 250));
		mbtnBtuLm.setColor(new Color(44, 173, 167));
		mbtnBtuLm.setBorderColor(new Color(44, 173, 167));
		mbtnBtuLm.setBounds(345, 136, 195, 37);
		panel_3.add(mbtnBtuLm);
		
		
		
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		panel_4.add(panel_1);		
		
		JLabel lblNewLabel_13 = new JLabel("User");
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblNewLabel_13.setBounds(20, 45, 85, 26);
		panel_1.add(lblNewLabel_13);panel_4.add(panel_2);
		panel_4.add(panel_3);
	}
	
	
	public void view_test() {
		JLabel lblNewLabel_7 = new JLabel("Bài kiểm tra");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_7.setBounds(10, 11, 134, 40);
		panel_4.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setBounds(10, 75, 340, 40);
		panel_4.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Kết quả tìm kiếm:");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_8.setForeground(Gray);
		lblNewLabel_8.setBounds(471, 90, 127, 30);
		panel_4.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("ALL");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9.setBounds(625, 95, 56, 20);
		panel_4.add(lblNewLabel_9);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 126, 693, 535);
		panel_4.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Chi tiết bài kiểm tra");
		lblNewLabel_10.setBounds(0, 11, 166, 30);
		panel_1.add(lblNewLabel_10);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 57, 693, 467);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"T\u00EAn k\u00EC thi", "Ng\u00E0y thi", "Th\u1EDDi gian", "C\u00E2u \u0111\u00FAng", "C\u00E2u sai", "\u0110i\u1EC3m"
			}
		));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
	}
	public void view_profile() {
		panel_4.setBounds(171, 0, 713, 661); 
		
		JLabel lblNewLabel_11 = new JLabel("Thông tin cá nhân");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_11.setBounds(10, 11, 189, 40);
		panel_4.add(lblNewLabel_11);
		
		PanelRound panel_2 = new PanelRound(15);
		panel_2.setBounds(10, 62, 505, 234);
		panel_4.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("Thông tin chi tiết");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_12.setBounds(10, 11, 165, 24);
		panel_2.add(lblNewLabel_12);
		
		JLabel TenSV = new JLabel("Tên :");
		TenSV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TenSV.setBounds(10, 131, 58, 24);
		panel_2.add(TenSV);
		
		JLabel MSSV = new JLabel("Mã số học sinh :");
		MSSV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		MSSV.setBounds(10, 67, 126, 29);
		panel_2.add(MSSV);
		
		JLabel LopSV = new JLabel("Lớp :");
		LopSV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LopSV.setBounds(10, 199, 58, 24);
		panel_2.add(LopSV);
		
		JLabel MSSV_text = new JLabel("Mã số học sinh :");
		MSSV_text.setFont(new Font("Tahoma", Font.PLAIN, 16));
		MSSV_text.setBounds(168, 67, 126, 29);
		panel_2.add(MSSV_text);
		
		JLabel NameSV_Text = new JLabel("Mã số học sinh :");
		NameSV_Text.setFont(new Font("Tahoma", Font.PLAIN, 16));
		NameSV_Text.setBounds(105, 129, 126, 29);
		panel_2.add(NameSV_Text);
		
		JLabel LopSV_Text = new JLabel("Mã số học sinh :");
		LopSV_Text.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LopSV_Text.setBounds(105, 197, 126, 29);
		panel_2.add(LopSV_Text);
		
		PanelRound panel_2_1 = new PanelRound(15);
		panel_2_1.setBounds(525, 62, 178, 182);
		panel_4.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setBounds(34, 11, 119, 117);
		panel_2_1.add(lblNewLabel_14);
		
		BtnChangeImagePer = new MyButton("Thay đổi hình ảnh");
		BtnChangeImagePer.setBounds(34, 148, 119, 23);
		BtnChangeImagePer.addActionListener(cl);
		panel_2_1.add(BtnChangeImagePer);
		
		PanelRound panel_2_2_1 = new PanelRound(15);
		panel_2_2_1.setBounds(524, 261, 179, 81);
		panel_4.add(panel_2_2_1);
		panel_2_2_1.setLayout(null);
		
		JLabel lblNewLabel_12_1 = new JLabel("");
		lblNewLabel_12_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_12_1.setBounds(10, 11, 165, 24);
		panel_2_2_1.add(lblNewLabel_12_1);
		
		btnChangePer = new MyButton("");
		btnChangePer.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnChangePer.setColor(Green);
		btnChangePer.setBorderColor(Green);
		btnChangePer.setColorOver(Blue);
		btnChangePer.setForeground(new Color(255,255,255));
		btnChangePer.setBounds(10, 326, 152, 42);
		btnChangePer.addActionListener(cl);
		panel_4.add(btnChangePer);
		
		btnChangePer.setText("Thay đổi mật khẩu");
		btnChangePer.setRadius(15);
	
	}
	public ViewStudent() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 900, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(235, 235, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel_4);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Blue);
		panel.setBounds(0, 0, 170, 661);
		contentPane.add(panel);
		panel.setLayout(null);
		
		BtnHome =    new MyButton("Home");
		BtnHome.setForeground(Color.WHITE);
		BtnHome.setColorOver(new Color(88, 141, 220));
		BtnHome.setColorClick(new Color(150, 207, 250));
		BtnHome.setRadius(10); 
		BtnHome.setColor(Blue); BtnHome.setBorderColor(Blue);
		BtnHome.setHorizontalAlignment(SwingConstants.LEFT);
		BtnHome.setFont(new Font("Tahoma", Font.BOLD, 15));
		BtnHome.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/home.png"))));
		BtnHome.addActionListener(cl);
		
		BtnHome.setBounds(10, 90, 137, 37);
		panel.add(BtnHome);
		
		btnTests = new MyButton("Tests");
	
		btnTests.setForeground(Color.WHITE);
		btnTests.addActionListener(cl);
		btnTests.setBackground(new Color(0, 0, 0));
		btnTests.setColorOver(new Color(88, 141, 220));
		btnTests.setColorClick(new Color(150, 207, 250));
		btnTests.setRadius(10);		btnTests.setColor(Blue); btnTests.setBorderColor(Blue);
		btnTests.setHorizontalAlignment(SwingConstants.LEFT);
		btnTests.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTests.setBounds(10, 138, 137, 37);
		btnTests.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/test.png"))));
		panel.add(btnTests);
		
		btnProfile = new MyButton("Profile");
		btnProfile.addActionListener(cl);
		btnProfile.setForeground(Color.WHITE);
		btnProfile.setBackground(new Color(0, 0, 0));
		btnProfile.setColorOver(new Color(88, 141, 220));
		btnProfile.setColorClick(new Color(150, 207, 250));
		btnProfile.setRadius(10);		btnProfile.setColor(Blue); btnProfile.setBorderColor(Blue);
		btnProfile.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnProfile.setHorizontalAlignment(SwingConstants.LEFT);
		btnProfile.setBounds(10, 186, 137, 37);
		btnProfile.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/profile.png"))));
		panel.add(btnProfile);
		panel_4.setBounds(171, 0, 713, 661); 
		view_home();
		//-----------------------------------
		
		//------------
		
}
}
