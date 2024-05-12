package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class View123 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane3;
	private JTextField textNameGv;
	private JTextField textIdGv;
	private JTextField textUser;
	private JTextField textPass;
	public JFrame l;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View123 frame = new View123();
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
	public View123() {
		
		l = new JFrame();
		l.setBounds(100, 100, 407, 391);
		l.setLocationRelativeTo(null);
		contentPane3 = new JPanel();
		contentPane3.setBackground(new Color(255, 255, 255));
		contentPane3.setBorder(new EmptyBorder(5, 5, 5, 5));

		l.setContentPane(contentPane3);
		contentPane3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã giáo viên :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(45, 90, 95, 41);
		contentPane3.add(lblNewLabel);
		
		JLabel lblTnTiKhon = new JLabel("Tên tài khoản :");
		lblTnTiKhon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnTiKhon.setBounds(45, 140, 95, 41);
		contentPane3.add(lblTnTiKhon);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu :");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMtKhu.setBounds(45, 190, 95, 41);
		contentPane3.add(lblMtKhu);
		
		JLabel lblNewLabel_1 = new JLabel("Tên giáo viên :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(45, 40, 95, 41);
		contentPane3.add(lblNewLabel_1);
		
		textNameGv = new JTextField();
		textNameGv.setBounds(168, 52, 86, 20);
		contentPane3.add(textNameGv);
		textNameGv.setColumns(10);
		
		textIdGv = new JTextField();
		textIdGv.setBounds(168, 102, 86, 20);
		contentPane3.add(textIdGv);
		textIdGv.setColumns(10);
		
		textUser = new JTextField();
		textUser.setBounds(168, 152, 86, 20);
		contentPane3.add(textUser);
		textUser.setColumns(10);
		
		textPass = new JTextField();
		textPass.setBounds(168, 202, 86, 20);
		contentPane3.add(textPass);
		textPass.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(132, 267, 89, 23);
		contentPane3.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(293, 51, 65, 22);
		contentPane3.add(comboBox);
		
		l.setVisible(true);
		


	}
}
