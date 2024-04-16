package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ViewTeacher {

	private JFrame frame;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTeacher window = new ViewTeacher();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewTeacher() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1058, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		PanelRound panel = new PanelRound(20);
		panel.setBounds(0, 0, 1042, 61);
		frame.getContentPane().add(panel);
		
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trường THPT Vinh");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 240, 35);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Exam");
		btnNewButton.setBounds(339, 21, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Question Library");
		btnNewButton_1.setBounds(444, 21, 124, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cài Đặt");
		btnNewButton_2.setBounds(759, 18, 68, 29);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(849, 25, 46, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_4 = new JButton("Lớp học");
		btnNewButton_4.setBounds(594, 21, 89, 23);
		panel.add(btnNewButton_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 86, 1042, 61);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Thêm bài kiểm tra");
		btnNewButton_3.setBounds(680, 11, 123, 23);
		panel_1.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(25, 0, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(81, 0, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Lop a  lop c"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(10, 173, 1032, 48);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(0, 165, 1032, 241);
		frame.getContentPane().add(scrollPane);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setBounds(32, 437, 121, 23);
		frame.getContentPane().add(tglbtnNewToggleButton);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(243, 438, 187, 23);
		frame.getContentPane().add(formattedTextField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(514, 438, 274, 22);
		frame.getContentPane().add(passwordField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"sds", "s", "s", "s", "s", "s", "", "s"}));
		comboBox.setBounds(821, 437, 211, 53);
		frame.getContentPane().add(comboBox);
	}
}
