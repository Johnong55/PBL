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
import javax.swing.JList;
import javax.swing.AbstractListModel;

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
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 185, 185));
		panel.setBounds(0, 0, 170, 661);
		contentPane.add(panel);
		panel.setLayout(null);
		
		MyButton btnNewButton = new MyButton("Home");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBounds(10, 90, 137, 37);
		btnNewButton.setBackground(new Color(50, 185, 185));
		btnNewButton.setColorClick(new Color(50, 185, 185));
		btnNewButton.setColorOver(new Color(100, 241, 241));
		btnNewButton.setRadius(10);
		btnNewButton.setBorderColor(new Color(50, 185, 185));
		btnNewButton.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-home-20.png"))));
		panel.add(btnNewButton);

		MyButton btnNewButton1 = new MyButton("Classes");
		btnNewButton1.setForeground(new Color(255, 255, 255));
		btnNewButton1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton1.setBounds(10, 138, 137, 37);
		btnNewButton1.setBackground(new Color(50, 185, 185));
		btnNewButton1.setColorClick(new Color(50, 185, 185));
		btnNewButton1.setColorOver(new Color(100, 241, 241));
		btnNewButton1.setRadius(10);
		btnNewButton1.setBorderColor(new Color(50, 185, 185));
		btnNewButton1.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-class-20.png"))));
		panel.add(btnNewButton1);

		MyButton btnNewButton2 = new MyButton("Results");
		btnNewButton2.setForeground(new Color(255, 255, 255));
		btnNewButton2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton2.setBounds(10, 186, 137, 37);
		btnNewButton2.setBackground(new Color(50, 185, 185));
		btnNewButton2.setColorClick(new Color(50, 185, 185));
		btnNewButton2.setColorOver(new Color(100, 241, 241));
		btnNewButton2.setRadius(10);
		btnNewButton2.setBorderColor(new Color(50, 185, 185));
		btnNewButton2.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-result-20.png"))));
		panel.add(btnNewButton2);

		MyButton btnNewButton3 = new MyButton("Profile");
		btnNewButton3.setForeground(new Color(255, 255, 255));
		btnNewButton3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton3.setBounds(10, 234, 137, 37);
		btnNewButton3.setBackground(new Color(50, 185, 185));
		btnNewButton3.setColorClick(new Color(50, 185, 185));
		btnNewButton3.setColorOver(new Color(100, 241, 241));
		btnNewButton3.setRadius(10);
		btnNewButton3.setBorderColor(new Color(50, 185, 185));
		btnNewButton3.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.createImage(getClass().getResource("/view/image/icons8-male-user-20.png"))));
		panel.add(btnNewButton3);

		MyButton btnNewButton4 = new MyButton("Create new");
		btnNewButton4.setForeground(new Color(255, 255, 255));
		btnNewButton4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton4.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton4.setBounds(10, 282, 137, 37);
		btnNewButton4.setBackground(new Color(50, 185, 185));
		btnNewButton4.setColorClick(new Color(50, 185, 185));
		btnNewButton4.setColorOver(new Color(100, 241, 241));
		btnNewButton4.setRadius(10);
		btnNewButton4.setBorderColor(new Color(50, 185, 185));
		btnNewButton4.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/icons8-add-new-20.png"))));
		panel.add(btnNewButton4);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(45, 11, 75, 70);
		
		lblNewLabel.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(getClass().getResource("/view/image/logo.png"))	
				.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH)));
		
		panel.add(lblNewLabel);
	
		//////////////////////////////////////////////////
		
		pView = new JPanel();
		pView.setBorder(null);
		pView.setBackground(Color.WHITE);
		pView.setBounds(170, 0, 714, 661);
		contentPane.add(pView);
		pView.setLayout(null);
		
				
        //////////////////////////////////////////////////

	}
}
