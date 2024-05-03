package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class MyTable extends JTable {
	private static final long serialVersionUID = 1L;
	private static final Color RIGHT_COLOR = Color.WHITE;
	private static final Color LEFT_COLOR = Color.WHITE;
	private TableDarkHeader header;
	private TableDarkCell cell;

	public MyTable() {
		setBackground(new Color(0, 0, 0, 0));
		color1 = RIGHT_COLOR;
		color2 = LEFT_COLOR;
		header = new TableDarkHeader();
		cell = new TableDarkCell();
		getTableHeader().setDefaultRenderer(header);
		getTableHeader().setPreferredSize(new Dimension(0, 35));
		setDefaultRenderer(Object.class, cell);
		setRowHeight(30);
	}
//	public MyTable() {
//		setBackground(new Color(0, 0, 0, 0));
//		color1 = RIGHT_COLOR;
//		color2 = LEFT_COLOR;
//	}

	public void setColumnAlignment(int column, int align) {
		header.setAlignment(column, align);
	}

	public void setCellAlignment(int column, int align) {
		cell.setAlignment(column, align);
	}

	public void setPreferredWidth(int column, int width) {
		super.getColumnModel().getColumn(column).setPreferredWidth(width);
		resizeAndRepaint();
	}

	public void resizeAndRepaint() {
		revalidate();
		repaint();
	}

	private class TableDarkHeader extends DefaultTableCellRenderer {

		private Map<Integer, Integer> alignment = new HashMap<>();

		public void setAlignment(int column, int align) {
			alignment.put(column, align);
		}

		@Override
		public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i,
				int i1) {
			Component com = super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
			com.setFont(com.getFont().deriveFont(Font.BOLD, 12));
			if (alignment.containsKey(i1)) {
				setHorizontalAlignment(alignment.get(i1));
			} else {
				setHorizontalAlignment(JLabel.LEFT);
			}
			return com;
		}
	}

	private class TableDarkCell extends DefaultTableCellRenderer {

		private Map<Integer, Integer> alignment = new HashMap<>();

		public void setAlignment(int column, int align) {
			alignment.put(column, align);
		}

		@Override
		public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int row,
				int column) {
			Component com = super.getTableCellRendererComponent(jtable, o, bln, bln1, row, column);
//			if (isCellSelected(row, column)) {
//				if (row % 2 == 0) {
//					com.setBackground(new Color(33, 103, 153));
//				} else {
//					com.setBackground(new Color(29, 86, 127));
//				}
//			} else {
//				if (row % 2 == 0) {
//					com.setBackground(new Color(50, 50, 50));
//				} else {
//					com.setBackground(new Color(30, 30, 30));
//				}
//			}
//			com.setForeground(new Color(200, 200, 200));
			setBorder(new EmptyBorder(0, 5, 0, 5));
			if (alignment.containsKey(column)) {
				setHorizontalAlignment(alignment.get(column));
			} else {
				setHorizontalAlignment(JLabel.LEFT);
			}
			return com;
		}
	}

	private Color color1;
	private Color color2;

	public Color getColor1() {
		return color1;
	}

	public void setColor1(Color color1) {
		this.color1 = color1;
	}

	public Color getColor2() {
		return color2;
	}

	public void setColor2(Color color2) {
		this.color2 = color2;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setPaint(new GradientPaint(0, getHeight(), color1, getWidth(), getHeight(), color2));
		g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
		super.paintComponent(g);
	}
}