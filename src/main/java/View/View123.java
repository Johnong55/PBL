package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class View123 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane,pView;
	private JTable table;
	private JPlaceholderTextField textField,textField_1,textField_2,textField_3,textField_4;


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
	
		//////////////////////////////////////////////////
		
		pView = new JPanel();
		pView.setBorder(null);
		pView.setBackground(Color.WHITE);
		pView.setBounds(170, 0, 714, 661);
		contentPane.add(pView);
		pView.setLayout(null);
		
				
        //////////////////////////////////////////////////

		JLabel lblNewLabel = new JLabel("CREATE EXAM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 150 , 20);
		
		pView.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 41, 694, 609);
		panel_3.setBackground(Color.white);
		pView.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Class : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 30, 50 , 18);
		
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Subject :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(339, 30, 60 , 18);
		panel_3.add(lblNewLabel_1_1);
		
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(60, 30, 102, 22);
		panel_3.add(comboBox);
		
		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setBounds(402, 30, 102, 22);
		panel_3.add(comboBox_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Number of questions :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 90, 137 , 18);
		panel_3.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Number of easy questions :");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(10, 150, 169, 18);
		panel_3.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Number of medium questions :");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(10, 210, 190, 18);
		panel_3.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Number of hard questions :");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3.setBounds(10, 270, 169, 18);
		panel_3.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("Exm day :");
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3_1.setBounds(10, 330, 70, 18);
		panel_3.add(lblNewLabel_1_2_3_1);
		
		JLabel lblNewLabel_1_2_3_2 = new JLabel("Starting time :");
		lblNewLabel_1_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3_2.setBounds(10, 390, 88, 18);
		panel_3.add(lblNewLabel_1_2_3_2);
		
		JLabel lblNewLabel_1_2_3_3 = new JLabel("Exam duration :");
		lblNewLabel_1_2_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3_3.setBounds(10, 450, 100, 18);
		panel_3.add(lblNewLabel_1_2_3_3);
		
		textField = new JPlaceholderTextField("");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(210, 206, 100, 30);
		textField.setBorder(null);
		textField.setGradientColors(new Color(50,185,185), Color.white);
		textField.setCornerRadius(20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPlaceholderTextField("");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(210, 146, 100, 30);
		textField_1.setBorder(null);
		textField_1.setGradientColors(new Color(50,185,185), Color.white);
		textField_1.setCornerRadius(20);
		panel_3.add(textField_1);
		
		textField_2 = new JPlaceholderTextField("");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setGradientColors(new Color(50,185,185), Color.white);
		textField_2.setCornerRadius(20);
		textField_2.setBounds(210, 86, 100, 30);
		panel_3.add(textField_2);
		
		textField_3 = new JPlaceholderTextField("");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(210, 266, 100, 30);
		textField_3.setBorder(null);
		textField_3.setGradientColors(new Color(50,185,185), Color.white);
		textField_3.setCornerRadius(20);
		panel_3.add(textField_3);
		
		textField_4 = new JPlaceholderTextField("");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(210, 446, 100, 30);
		textField_4.setBorder(null);
		textField_4.setGradientColors(new Color(50,185,185), Color.white);
		textField_4.setCornerRadius(20);
		panel_3.add(textField_4);
		
        MaskFormatter dateformatter = null;
        MaskFormatter timeformatter = null;
        try {
            dateformatter = new MaskFormatter(" ####/##/## ");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            timeformatter = new MaskFormatter(" ##:##:## ");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        PlaceholderFormattedTextField dateField = new PlaceholderFormattedTextField(dateformatter);
        dateField.setHorizontalAlignment(SwingConstants.CENTER);
        dateField.setColumns(10);
        dateField.setBounds(210, 326, 100, 30);
        dateField.setBorder(null);
        dateField.setGradientColors(new Color(50,185,185), Color.white);
        dateField.setCornerRadius(20);
        PlaceholderFormattedTextField timeField = new PlaceholderFormattedTextField(timeformatter);
        timeField.setHorizontalAlignment(SwingConstants.CENTER);
        timeField.setColumns(10);
        timeField.setBounds(210, 386, 100, 30);
        timeField.setBorder(null);
        timeField.setGradientColors(new Color(50,185,185), Color.white);
		timeField.setCornerRadius(20);
        panel_3.add(dateField);
		panel_3.add(timeField);
		
		MyButton btnNewButton_1_1 = new MyButton("Create");
		btnNewButton_1_1.setRadius(10);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setColorOver(new Color(100, 241, 241));
		btnNewButton_1_1.setColorClick(new Color(50, 185, 185));
		btnNewButton_1_1.setColor(new Color(50, 185, 185));
		btnNewButton_1_1.setBorderColor(Color.WHITE);
		btnNewButton_1_1.setBackground(new Color(50, 185, 185));
		btnNewButton_1_1.setBounds(520, 530, 150, 30);
		
		panel_3.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1_2_3_3_1 = new JLabel("Describe :");
		lblNewLabel_1_2_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3_3_1.setBounds(10, 510, 100, 18);
		panel_3.add(lblNewLabel_1_2_3_3_1);
		
		JPlaceholderTextField textField_4_1 = new JPlaceholderTextField("");
		textField_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4_1.setCornerRadius(20);
		textField_4_1.setColumns(10);
		textField_4_1.setBorder(null);
		textField_4_1.setBounds(210, 511, 100, 30);
		panel_3.add(textField_4_1);
		
		JLabel lblNewLabel_2 = new JLabel("( VD: 2004/04/07)");
		lblNewLabel_2.setForeground(new Color(192, 192, 192));
		lblNewLabel_2.setBounds(320, 334, 102, 14);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("( VD: 09:00:00)");
		lblNewLabel_2_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2_1.setBounds(320, 394, 102, 14);
		panel_3.add(lblNewLabel_2_1);

	}
}
