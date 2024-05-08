package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class View123 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane,pView;
	private JTable table;
	public MyButton btnNewButton, btnNewButton1, btnNewButton2, btnNewButton3_1, btnNewButton5;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAdmin frame = new ViewAdmin();
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(45, 51, 63));
		panel.setBounds(0, 0, 170, 661);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(45, 11, 75, 70);

		lblNewLabel.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/logo.png"))
						.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH)));

		panel.add(lblNewLabel);

		btnNewButton = new MyButton("Trang chủ");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBounds(10, 90, 137, 37);
		btnNewButton.setBackground(new Color(45, 51, 63));
		btnNewButton.setColorClick(new Color(45, 51, 63));
		btnNewButton.setColorOver(new Color(86, 98, 120));
		btnNewButton.setRadius(10);
		btnNewButton.setBorderColor(new Color(45, 51, 63));
		btnNewButton.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-home-20.png"))));
		panel.add(btnNewButton);

		btnNewButton1 = new MyButton("Lớp");
		btnNewButton1.setForeground(new Color(255, 255, 255));
		btnNewButton1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton1.setBounds(10, 138, 137, 37);
		btnNewButton1.setBackground(new Color(45, 51, 63));
		btnNewButton1.setColorClick(new Color(45, 51, 63));
		btnNewButton1.setColorOver(new Color(86, 98, 120));
		btnNewButton1.setRadius(10);
		btnNewButton1.setBorderColor(new Color(45, 51, 63));
		btnNewButton1.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-class-20.png"))));
		panel.add(btnNewButton1);

		btnNewButton2 = new MyButton("Giáo viên");
		btnNewButton2.setForeground(new Color(255, 255, 255));
		btnNewButton2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton2.setBounds(10, 186, 137, 37);
		btnNewButton2.setBackground(new Color(45, 51, 63));
		btnNewButton2.setColorClick(new Color(45, 51, 63));
		btnNewButton2.setColorOver(new Color(86, 98, 120));
		btnNewButton2.setRadius(10);
		btnNewButton2.setBorderColor(new Color(45, 51, 63));
		btnNewButton2.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-result-20.png"))));
		panel.add(btnNewButton2);

		btnNewButton3_1 = new MyButton("Học sinh");
		btnNewButton3_1.setRadius(10);
		btnNewButton3_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton3_1.setForeground(Color.WHITE);
		btnNewButton3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton3_1.setColorOver(new Color(86, 98, 120));
		btnNewButton3_1.setColorClick(new Color(45, 51, 63));
		btnNewButton3_1.setBorderColor(new Color(45, 51, 63));
		btnNewButton3_1.setBackground(new Color(45, 51, 63));
		btnNewButton3_1.setBounds(10, 234, 137, 37);
		btnNewButton3_1.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-student-20.png"))));
		panel.add(btnNewButton3_1);

		btnNewButton5 = new MyButton("Đăng xuất");
		btnNewButton5.setForeground(new Color(255, 255, 255));
		btnNewButton5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton5.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton5.setBounds(10, 550, 137, 37);
		btnNewButton5.setBackground(new Color(45, 51, 63));
		btnNewButton5.setColorClick(new Color(45, 51, 63));
		btnNewButton5.setColorOver(new Color(86, 98, 120));
		btnNewButton5.setRadius(10);
		btnNewButton5.setBorderColor(new Color(45, 51, 63));
		btnNewButton5.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-logout-20.png"))));
		panel.add(btnNewButton5);

		//////////////////////////////////////////////////

		pView = new JPanel();
		pView.setBorder(null);
		pView.setBackground(Color.WHITE);
		pView.setBounds(170, 0, 714, 661);
		contentPane.add(pView);
		pView.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 11, 694, 639);
		lblNewLabel_1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/homadmin.jpg"))));
		pView.add(lblNewLabel_1);

		//////////////////////////////////////////////////

	}
}
