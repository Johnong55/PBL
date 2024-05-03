package View;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import Controller.Controller_Login;
import DAO.Account_dao;
import DAO.Gv_dao;
import DAO.Sv_dao;
import model.Account;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import Controller.Controller_Login;

public class viewLogin extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JPasswordField textField_1;
	private Controller_Login lg = new Controller_Login(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewLogin frame = new viewLogin();
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
	public viewLogin() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1141, 713);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		PanelRound panel = new PanelRound(40);
		panel.setBground(new Color(0, 128, 255));
		panel.setBorderWidth(1);
		panel.setBounds(68, 70, 992, 516);
		panel.setBorderGradientColor(new Color(0, 128, 255), new Color(0, 128, 255));
		panel.setGradientColor(new Color(0, 128, 255), new Color(0, 128, 255));
		contentPane.add(panel);
		panel.setLayout(null);

		PanelRound panel_1 = new PanelRound(20);
		panel_1.setBorder(null);
		panel_1.setBground(new Color(0, 128, 255));
		panel_1.setBounds(10, 10, 508, 477);
		panel_1.setGradientColor(new Color(0, 128, 255), new Color(0, 128, 255));
		panel.add(panel_1);
		panel_1.setLayout(null); 

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(71, 101, 329, 227);
		lblNewLabel.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/login.png"))
						.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH)));

		panel_1.add(lblNewLabel);

		PanelRound panel_dangnhap = new PanelRound(20);
		panel_dangnhap.setBackground(new Color(255, 255, 255));
		panel_dangnhap.setBounds(533, 20, 426, 465);
		panel.add(panel_dangnhap);
		panel_dangnhap.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("HỆ THỐNG KIỂM TRA TRỰC TUYẾN");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_1.setBounds(20, 13, 406, 66);
		panel_dangnhap.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("ĐĂNG NHẬP");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_2.setBounds(126, 92, 191, 31);
		panel_dangnhap.add(lblNewLabel_2);

		PanelRound Panel_email = new PanelRound(20);
		Panel_email.setBorderColor(new Color(0, 128, 192));
		Panel_email.setBorderWidth(1);
		Panel_email.setBounds(10, 154, 381, 50);
		panel_dangnhap.add(Panel_email);
		Panel_email.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 11, 27, 31);
		lblNewLabel_3.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/email.png"))
						.getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH)));
		Panel_email.add(lblNewLabel_3);

		MatteBorder border = new MatteBorder(0, 0, 1, 0, Color.BLACK);

		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setBounds(52, 11, 308, 31);
		textField.setBorder(border);
		textField.setColumns(10);
		textField.addMouseListener(lg);
		MatteBorder border1 = new MatteBorder(0,0,2,0,Color.BLUE);
		textField.setBorder(border1);
		
		Panel_email.add(textField);

		PanelRound panel_password = new PanelRound(20);
		panel_password.setBorderColor(new Color(0, 128, 192));
		panel_password.setBorderWidth(1);
		panel_password.setLayout(null);
		panel_password.setBounds(10, 228, 381, 50);
		panel_dangnhap.add(panel_password);

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(10, 10, 30, 30);

		lblNewLabel_3_1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.createImage(getClass().getResource("/view/image/password.png"))
				.getScaledInstance(lblNewLabel_3_1.getWidth(), lblNewLabel_3_1.getHeight(), Image.SCALE_SMOOTH)));
		panel_password.add(lblNewLabel_3_1);

		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_1.setBounds(52, 11, 308, 31);
		textField_1.addMouseListener(lg);
		textField_1.setBorder(border);
		textField_1.setColumns(10);
		textField_1.requestFocus(false);

		panel_password.add(textField_1);
		
		PanelRound panel_3 = new PanelRound(20);
		panel_3.setBorderWidth(0);
		panel_3.setBground(new Color(0, 128, 192));
		panel_3.setGradientColor(new Color(0, 128, 192), new Color(0, 128, 192));
		panel_3.setBounds(49, 322, 326, 66);
		panel_dangnhap.add(panel_3);
		panel_3.setLayout(null);

		JButton btnNewButton = new JButton("Đăng Nhập");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBounds(0, 10, 326, 46);
		btnNewButton.setBorder(null);
		btnNewButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnNewButton.setBackground(new Color(0,128,192));
				panel_3.setGradientColor(new Color(0,128,192), new Color(0,128,192));
				panel_3.setBground(new Color(0,128,192));	
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnNewButton.setBackground(new Color(0,125,255));
				panel_3.setGradientColor(new Color(0,125,255), new Color(0,125,255));
				panel_3.setBground(new Color(0,125,255));	
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String user = textField.getText(); 
				char[] k = textField_1.getPassword();
				String pass = new String(k);

				if( user.isEmpty()  ||  pass.isEmpty()) 
					JOptionPane.showMessageDialog(null, "Nhập thêm thông tin !.", "Thông báo", JOptionPane.ERROR_MESSAGE);
				else {
				for(Account q : Account_dao.Instance().selectall())
				{
					System.out.println(user);
					System.out.println(pass);
					System.out.println(q.username);
					System.out.println(q.password);
					if(q.username.equals(user) && q.password.equals(pass))
					{
						System.out.println("cc");
						if(q.getMaquyen() == 2) {
							
							ViewStudent v = new ViewStudent(Sv_dao.Instance().selectbyid(q));
							//System.out.println(Sv_dao.Instance().selectbyid(q).getTen());
							
							dispose();
						}if(q.getMaquyen() == 1) {
							System.out.println("cl");
							ViewTeacher v = new ViewTeacher(Gv_dao.Instance().selectbyid(q));
							dispose();
						}
						return;
					}
				}
				
				JOptionPane.showMessageDialog(null, "Thông tin nhập không chính xác ! Vui lòng thử lại.", "Thông báo", JOptionPane.ERROR_MESSAGE);
				}
				// TODO Auto-generated method stub
				
			}
		});
		panel_3.add(btnNewButton);

	}
}