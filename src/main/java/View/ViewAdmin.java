package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import javax.swing.text.View;

import Controller.Controller_Admin;

import javax.swing.JButton;

public class ViewAdmin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane,pView;
	private MyTable table;
	public MyButton btnNewButton, btnNewButton1, btnNewButton2, btnNewButton3_1;
	public Controller_Admin controAdmin = new Controller_Admin();

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
	public ViewAdmin() {
		
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
		btnNewButton.addActionListener(this);
		
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
		btnNewButton1.addActionListener(this);

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
		btnNewButton2.addActionListener(this);
		
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
		btnNewButton3_1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.createImage(getClass().getResource("/view/image/icons8-student-20.png"))));
		panel.add(btnNewButton3_1);
		btnNewButton3_1.addActionListener(this);
	
		//////////////////////////////////////////////////
		
		pView = new JPanel();
		pView.setBorder(null);
		pView.setBackground(Color.WHITE);
		pView.setBounds(170, 0, 714, 661);
		contentPane.add(pView);
		pView.setLayout(null);
		
				
        //////////////////////////////////////////////////

	}
	
	public void ViewHome() {
		pView.removeAll();
		pView.repaint();
		pView.revalidate();
		
	}
	
	public void ViewClass() {
		pView.removeAll();
		pView.repaint();
		pView.revalidate();
		
		JLabel lblNewLabel = new JLabel("LỚP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth()+1 , (int) size.getHeight()+1);
		
		pView.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 700, 668);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(201,201,201)));
		
		pView.add(scrollPane);
		
		table = new MyTable();
		table.setRowHeight(30);
		table.setColor1(Color.WHITE);
		table.setColor2(Color.WHITE);
		table.setGridColor(new Color(201,201,201));
	//	table.setShowGrid(false);
		table.setColumnAlignment(0, JLabel.LEFT);
		table.setCellAlignment(0, JLabel.LEFT);
		
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            private static final long serialVersionUID = 1L;

            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                        column);
                comp.setBackground(new Color(45, 51, 63));
                comp.setForeground(Color.WHITE);
                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(201,201,201)));
               
                return comp;
            }
        });
		table.getTableHeader().setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"  Tên lớp", "  Số học sinh"
			}
		));
		
        table.setModel(controAdmin.getModelClasses(table));

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	int i = table.getSelectedRow();
            	String m = table.getValueAt(i, 0).toString();
            	ViewListSVinClass(m);
            }
        });
		
		scrollPane.setViewportView(table);
		

	}
	public void ViewListSVinClass(String m) {
		System.out.println(m);
		pView.removeAll();
		pView.repaint();
		pView.revalidate();
		
		JLabel lblNewLabel = new JLabel("LỚP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth()+1 , (int) size.getHeight()+1);
		
		pView.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBounds(10, 89, pView.getWidth()- 15, pView.getHeight() - 89);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(201,201,201)));
		pView.add(scrollPane);
		
		table = new MyTable();
		table.setRowHeight(30);
		table.setColor1(Color.WHITE);
		table.setColor2(Color.WHITE);
		table.setGridColor(new Color(201,201,201));
	//	table.setShowGrid(false);
		table.setColumnAlignment(0, JLabel.LEFT);
		table.setCellAlignment(0, JLabel.LEFT);
		
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            private static final long serialVersionUID = 1L;

            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                        column);
                comp.setBackground(new Color(45, 51, 63));
                comp.setForeground(Color.WHITE);
                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(201,201,201)));
               
                return comp;
            }
        });
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"  Tên học sinh"
			}
		));
		table.setModel(controAdmin.getModelSVinClass(m,table));
		scrollPane.setViewportView(table);
	}
	public void ViewTeacher() {
		pView.removeAll();
		pView.repaint();
		pView.revalidate();
		
		JLabel lblNewLabel = new JLabel("GIÁO VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth()+1 , (int) size.getHeight()+1);
		
		pView.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, pView.getWidth()-15, pView.getHeight() - 89);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(201,201,201)));
		scrollPane.getViewport().setBackground(Color.WHITE);

		DefaultTableModel model = new DefaultTableModel(
		    new Object[][] {},
		    new String[] {"  Tên giáo viên"}
		);
		table = new MyTable();
		table.setModel(model);
		table.setBackground(new Color(255, 255, 255));
		table.setRowHeight(30);
		table.setColor1(Color.WHITE);
		table.setColor2(Color.WHITE);
		table.setGridColor(new Color(201,201,201));
	//	table.setShowGrid(false);
		table.setColumnAlignment(0, JLabel.LEFT);
		table.setCellAlignment(0, JLabel.LEFT);
		
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            private static final long serialVersionUID = 1L;

            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                        column);
                comp.setBackground(new Color(45, 51, 63));
                comp.setForeground(Color.WHITE);
                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(201,201,201)));
               
                return comp;
            }
        });
		table.setModel(controAdmin.getModelTeacher(table));

		scrollPane.setViewportView(table);
		pView.add(scrollPane);
		
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	int i = table.getSelectedRow();
            	String m = table.getValueAt(i, 0).toString();
            	ViewClassOfTeacher(m);
            }
        });

	}
	public void ViewClassOfTeacher(String m) {
		System.out.println(m);
		pView.removeAll();
		pView.repaint();
		pView.revalidate();
		
		JLabel lblNewLabel = new JLabel("GIÁO VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth()+1 , (int) size.getHeight()+1);
		
		pView.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBounds(10, 89, pView.getWidth()-15, pView.getHeight() - 89);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(201,201,201)));
		pView.add(scrollPane);
		
		table = new MyTable();
		table.setRowHeight(30);
		table.setColor1(Color.WHITE);
		table.setColor2(Color.WHITE);
		table.setGridColor(new Color(201,201,201));
	//	table.setShowGrid(false);
		table.setColumnAlignment(0, JLabel.LEFT);
		table.setCellAlignment(0, JLabel.LEFT);
		
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            private static final long serialVersionUID = 1L;

            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                        column);
                comp.setBackground(new Color(45, 51, 63));
                comp.setForeground(Color.WHITE);
                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(201,201,201)));
               
                return comp;
            }
        });
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"  Tên lớp"
			}
		));
		table.setModel(controAdmin.getModelNameClassOfGv(m,table));
		scrollPane.setViewportView(table);
	}
	public void ViewStudent() {
		pView.removeAll();
		pView.repaint();
		pView.revalidate();
		
		JLabel lblNewLabel = new JLabel("HỌC SINH");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dimension size = lblNewLabel.getPreferredSize();
		lblNewLabel.setBounds(10, 10, (int) size.getWidth()+1 , (int) size.getHeight()+1);
		
		pView.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, pView.getWidth() - 15, pView.getHeight() - 89);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(201,201,201)));

		DefaultTableModel model = new DefaultTableModel(
		    new Object[][] {},
		    new String[] {"  Tên học sinh", "  Lớp"}
		);
		table = new MyTable();
		table.setModel(model);
		table.setRowHeight(30);
		table.setColor1(Color.WHITE);
		table.setColor2(Color.WHITE);
		table.setGridColor(new Color(201,201,201));
	//	table.setShowGrid(false);
		table.setColumnAlignment(0, JLabel.LEFT);
		table.setCellAlignment(0, JLabel.LEFT);
		
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            private static final long serialVersionUID = 1L;

            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                        column);
                comp.setBackground(new Color(45, 51, 63));
                comp.setForeground(Color.WHITE);
                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(201,201,201)));
               
                return comp;
            }
        });

		table.setModel(controAdmin.getModelStudent(table));

		scrollPane.setViewportView(table);
		pView.add(scrollPane);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==btnNewButton1) {
			ViewClass();
		}else if(e.getSource()== btnNewButton) {
			ViewHome();
		}else if(e.getSource()== btnNewButton2) {
			ViewTeacher();
		}else if(e.getSource()==btnNewButton3_1) {
			ViewStudent();
		}
	}
	
}
