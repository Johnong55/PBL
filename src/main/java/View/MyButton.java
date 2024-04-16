package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class MyButton extends JButton {
	private static final long serialVersionUID = 1L;
	
	public MyButton(String test) {
		/*
		 * setColor(Color.white);
		 */		/*
		 * colorOver = new Color(179, 250, 160); colorClick = new Color(152, 184, 144);
		 * borderColor = new Color(30, 156, 36);
		 */
		setFocusPainted(false);
		setContentAreaFilled(false);
		this.setText(test);
		  setBorder(new EmptyBorder(0, 0, getWidth(), getHeight()));
		 
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(colorOver);
				over = true;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(color);
				over = false;
			}

			@Override
			public void mousePressed(MouseEvent e) {
				setBackground(colorClick);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (over) {
					setBackground(colorOver);
				} else {
					setBackground(color);
				}
			}
		});
	}

	public boolean isOver() {
		return over;
	}

	public void setOver(boolean over) {
		this.over = over;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		setBackground(color);
	}

	public Color getColorOver() {
		return colorOver;
	}

	public void setColorOver(Color colorOver) {
		this.colorOver = colorOver;
	}

	public Color getColorClick() {
		return colorClick;
	}

	public void setColorClick(Color colorClick) {
		this.colorClick = colorClick;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	private boolean over;
	private Color color;
	private Color colorOver;
	private Color colorClick;
	private Color borderColor;
	private int radius = 0;

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(borderColor);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

		g2.setColor(getBackground());
		g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
		super.paintComponent(g);
	}
}
