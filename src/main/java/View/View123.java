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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		setLocationRelativeTo(null);
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

		MyButton btnNewButton1 = new MyButton("Lớp");
		btnNewButton1.setForeground(new Color(255, 255, 255));
		btnNewButton1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton1.setBounds(10, 90, 137, 37);
		btnNewButton1.setBackground(new Color(45, 51, 63));
		btnNewButton1.setColorClick(new Color(45, 51, 63));
		btnNewButton1.setColorOver(new Color(86, 98, 120));
		btnNewButton1.setRadius(10);
		btnNewButton1.setBorderColor(new Color(45, 51, 63));
		btnNewButton1.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-class-20.png"))));
		panel.add(btnNewButton1);

		MyButton btnNewButton2 = new MyButton("Giáo viên");
		btnNewButton2.setForeground(new Color(255, 255, 255));
		btnNewButton2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton2.setBounds(10, 138, 137, 37);
		btnNewButton2.setBackground(new Color(45, 51, 63));
		btnNewButton2.setColorClick(new Color(45, 51, 63));
		btnNewButton2.setColorOver(new Color(86, 98, 120));
		btnNewButton2.setRadius(10);
		btnNewButton2.setBorderColor(new Color(45, 51, 63));
		btnNewButton2.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-result-20.png"))));
		panel.add(btnNewButton2);

		 MyButton btnNewButton3_1 = new MyButton("Học sinh");
		btnNewButton3_1.setRadius(10);
		btnNewButton3_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton3_1.setForeground(Color.WHITE);
		btnNewButton3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton3_1.setColorOver(new Color(86, 98, 120));
		btnNewButton3_1.setColorClick(new Color(45, 51, 63));
		btnNewButton3_1.setBorderColor(new Color(45, 51, 63));
		btnNewButton3_1.setBackground(new Color(45, 51, 63));
		btnNewButton3_1.setBounds(10, 186, 137, 37);
		btnNewButton3_1.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-student-20.png"))));
		panel.add(btnNewButton3_1);

		MyButton btnNewButton5 = new MyButton("Đăng xuất");
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
		
		MyButton btnNewButton3_1_1 = new MyButton("Kì thi");
		btnNewButton3_1_1.setRadius(10);
		btnNewButton3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton3_1_1.setForeground(Color.WHITE);
		btnNewButton3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton3_1_1.setColorOver(new Color(86, 98, 120));
		btnNewButton3_1_1.setColorClick(new Color(45, 51, 63));
		btnNewButton3_1_1.setBorderColor(new Color(45, 51, 63));
		btnNewButton3_1_1.setBackground(new Color(45, 51, 63));
		btnNewButton3_1_1.setBounds(10, 234, 137, 37);
		btnNewButton3_1_1.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-result-20.png"))));
		panel.add(btnNewButton3_1_1);
		
		MyButton btnNewButton3_1_1_1 = new MyButton("Bài thi");
		btnNewButton3_1_1_1.setRadius(10);
		btnNewButton3_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton3_1_1_1.setForeground(Color.WHITE);
		btnNewButton3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton3_1_1_1.setColorOver(new Color(86, 98, 120));
		btnNewButton3_1_1_1.setColorClick(new Color(45, 51, 63));
		btnNewButton3_1_1_1.setBorderColor(new Color(45, 51, 63));
		btnNewButton3_1_1_1.setBackground(new Color(45, 51, 63));
		btnNewButton3_1_1_1.setBounds(10, 282, 137, 37);
		btnNewButton3_1_1_1.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-test-20.png"))));
		panel.add(btnNewButton3_1_1_1);
		
		MyButton btnNewButton3_1_1_2 = new MyButton("Kho câu hỏi");
		btnNewButton3_1_1_2.setRadius(10);
		btnNewButton3_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton3_1_1_2.setForeground(Color.WHITE);
		btnNewButton3_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton3_1_1_2.setColorOver(new Color(86, 98, 120));
		btnNewButton3_1_1_2.setColorClick(new Color(45, 51, 63));
		btnNewButton3_1_1_2.setBorderColor(new Color(45, 51, 63));
		btnNewButton3_1_1_2.setBackground(new Color(45, 51, 63));
		btnNewButton3_1_1_2.setBounds(10, 330, 137, 37);
		btnNewButton3_1_1_2.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-question-20.png"))));
		panel.add(btnNewButton3_1_1_2);

		//////////////////////////////////////////////////

		pView = new JPanel();
		pView.setBorder(null);
		pView.setBackground(Color.WHITE);
		pView.setBounds(170, 0, 714, 661);
		contentPane.add(pView);
		pView.setLayout(null);
		
		setVisible(true);
		
				
        //////////////////////////////////////////////////

	}
}
