package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class ViewTakeTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Color Blue=  new Color(17, 49, 123);
	Color Gray = new Color(122, 122, 129);
	Color Green = new Color(44, 173, 167);
	Color purple = new Color(221, 0, 221);
	PanelRound panel_1;
	MyButton btnprevious;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTakeTest frame = new ViewTakeTest();
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
	public ViewTakeTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1300, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Blue);
		panel.setBounds(0, 0, 1284, 122);
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
		lblH.setBounds(1009, 68, 227, 43);
		panel.add(lblH);
		
		panel_1 = new PanelRound();
		panel_1.setRadius(20);
		panel_1.setBounds(47, 158, 821, 520);
		contentPane.add(panel_1);
		
		PanelRound panel_1_1 = new PanelRound();
		panel_1_1.setRadius(20);
		panel_1_1.setBounds(919, 158, 319, 674);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		MyButton btnprevious_2 = new MyButton("New button");
		btnprevious_2.setBounds(60, 620, 204, 43);
		panel_1_1.add(btnprevious_2);
		btnprevious_2.setRadius(20);
		btnprevious_2.setFont(new Font("Verdana", Font.PLAIN, 19));
		
		btnprevious = new MyButton("New button");
		btnprevious.setFont(new Font("Verdana", Font.PLAIN, 19));
		btnprevious.setRadius(20);
		btnprevious.setBounds(47, 712, 204, 43);
		contentPane.add(btnprevious);
		
		MyButton btnprevious_1 = new MyButton("New button");
		btnprevious_1.setRadius(20);
		btnprevious_1.setFont(new Font("Verdana", Font.PLAIN, 19));
		btnprevious_1.setBounds(275, 712, 204, 43);
		contentPane.add(btnprevious_1);
	}
}
