package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JButton;

public class GoingTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Color Blue=  new Color(17, 49, 123);
	Color Gray = new Color(122, 122, 129);
	Color Green = new Color(44, 173, 167);
	Color purple = new Color(221, 0, 221);
	MyButton btnNewButton;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GoingTest frame = new GoingTest();
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
	public GoingTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 1000, 700);
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
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(37, 68, 275, 43);
		panel.add(lblNewLabel);
		
		JLabel lblH = new JLabel("1 tiếng 46 phút");
		lblH.setForeground(Color.WHITE);
		lblH.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblH.setBounds(730, 68, 227, 43);
		panel.add(lblH);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(333, 180, 312, 210);
		lblNewLabel_1.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/Goingexam.png"))
						.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblBtuLm = new JLabel("Bắt đầu làm bài thi");
		lblBtuLm.setForeground(new Color(0, 0, 0));
		lblBtuLm.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBtuLm.setBounds(387, 388, 242, 43);
		contentPane.add(lblBtuLm);
		
		btnNewButton = new MyButton("Bắt Đầu");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setColorOver(purple);
		btnNewButton.setBorderColor(Blue);
		btnNewButton.setColor(Blue);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setRadius(20);
		btnNewButton.setBounds(452, 442, 115, 43);
		contentPane.add(btnNewButton);
	}
}
