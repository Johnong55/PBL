package View;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;

import org.hibernate.loader.plan.spi.LoadPlan.Disposition;

public class PanelRound extends JPanel {
	
	public PanelRound() {
		setOpaque(false);
	}
	
	public PanelRound(int radius) {
		setOpaque(false);
		this.radius = radius;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public int getRadius() {
		return this.radius;
	}

	public Color getBackground() {
		return background;
	}

	public void setBground(Color background) {
		this.background = background;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public int getBorderWidth() {
		return borderWidth;
	}
	
	public void setBorderWidth(int borderWidth) {
		this.borderWidth = borderWidth;
	}
	

	private int borderWidth = 0;
	private int radius = 0;
	private Color background = Color.white;
	private Color borderColor = Color.black;
    private Color gradientColorStart = Color.white;
    private Color gradientColorEnd = Color.white;
    private Color borderGradientColorStart = Color.black;
    private Color borderGradientColorEnd = Color.black;

    public void setGradientColor(Color startColor, Color endColor) {
        this.gradientColorStart = startColor;
        this.gradientColorEnd = endColor;
    }
    public void setBorderGradientColor(Color startColor, Color endColor) {
        this.borderGradientColorStart = startColor;
        this.borderGradientColorEnd = endColor;
    }
    
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setColor(background);
		g2.fillRoundRect(borderWidth, borderWidth, getWidth() - 2 * borderWidth, getHeight() - 2 * borderWidth, radius, radius);
		
		GradientPaint gradient = new GradientPaint(0, 0, gradientColorStart, 0, getHeight(), gradientColorEnd);
        g2.setPaint(gradient);
        g2.fillRoundRect(borderWidth, borderWidth, getWidth() - 2 * borderWidth, getHeight() - 2 * borderWidth, radius, radius);
        
        GradientPaint borderGradient = new GradientPaint(0, 0, borderGradientColorStart, getWidth(), getHeight(), borderGradientColorEnd);
        g2.setPaint(borderGradient);
        g2.setStroke(new BasicStroke(borderWidth));
        g2.draw(new RoundRectangle2D.Double(borderWidth / 2.0, borderWidth / 2.0, getWidth() - borderWidth, getHeight() - borderWidth, radius, radius));
        g2.dispose();
		
		
	}
}
