package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassword extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public  JPasswordField textField, textField_1;
	public JLabel lblNewLabel_1_1;
	public MyButton btnNewButton;
	public  boolean isDisposed = false;
	public String password;
	Color Blue=  new Color(17, 49, 123);
	Color Gray = new Color(122, 122, 129);
	Color Green = new Color(44, 173, 167);

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChangePassword frame = new ChangePassword();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ChangePassword(String mk) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 350, 514, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Blue);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thay Đổi Mật Khẩu");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(130, 11, 217, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu cũ :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(37, 69, 109, 32);
		contentPane.add(lblNewLabel_1);
		
		 lblNewLabel_1_1 = new JLabel("Mật khẩu mới :");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(37, 138, 122, 32);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JPasswordField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 17));
		textField.setBounds(172, 69, 208, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		textField_1.setColumns(10);
		textField_1.setBounds(172, 138, 208, 28);
		contentPane.add(textField_1);
		
		MyButton btnNewButton = new MyButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 password = new String(textField.getPassword());

			
				
				if(!password.equals(mk)) 				JOptionPane.showMessageDialog(null, "Thông tin nhập không chính xác ! Vui lòng thử lại.", "Thông báo", JOptionPane.ERROR_MESSAGE);
				else {
				 int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thay đổi mật khẩu không?", "Xác nhận thay đổi mật khẩu", JOptionPane.YES_NO_OPTION);
			        
			        if (choice == JOptionPane.YES_OPTION) {
			        	
			            // Xử lý khi người dùng chọn "Yes"
			        	isDisposed = true;
			        	dispose();
			        }
				}
			}
		});
		btnNewButton.setRadius(20);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setText("Xác nhận");
		btnNewButton.setColor(new Color(255, 255, 255));
		btnNewButton.setBorderColor(Green);
		btnNewButton.setColorOver(Green);
		btnNewButton.setBounds(272, 191, 103, 32);
		contentPane.add(btnNewButton);
		
		MyButton mbtnHuB = new MyButton("");
		mbtnHuB.setRadius(20);
		mbtnHuB.setFont(new Font("Tahoma", Font.BOLD, 14));
		mbtnHuB.setText("Huỷ bỏ");
		mbtnHuB.setColor(new Color(255, 255, 255));
		mbtnHuB.setBorderColor(Green);
		mbtnHuB.setColorOver(Green);
		mbtnHuB.setBounds(385, 191, 103, 32);
		contentPane.add(mbtnHuB);
	}
}
