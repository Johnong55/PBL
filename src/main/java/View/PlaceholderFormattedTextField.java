package View;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.GradientPaint;
import java.awt.geom.RoundRectangle2D;

public class PlaceholderFormattedTextField extends JFormattedTextField {
    private String placeholder;
    private Color placeholderColor;
    private Color borderColor;
    private Color gradientColor1;
    private Color gradientColor2;
    private int cornerRadius;

    public PlaceholderFormattedTextField(String placeholder) {
        this.placeholder = placeholder;
        placeholderColor = Color.GRAY;
        borderColor = Color.BLACK;
        gradientColor1 = Color.WHITE;
        gradientColor2 = Color.GRAY;
        cornerRadius = 10; // Giá trị mặc định cho bán kính bo góc
    }
    public PlaceholderFormattedTextField(MaskFormatter m) {
        super(m);
        this.placeholder = "";
        placeholderColor = Color.GRAY;
        borderColor = Color.BLACK;
        gradientColor1 = Color.WHITE;
        gradientColor2 = Color.GRAY;
        cornerRadius = 10; // Giá trị mặc định cho bán kính bo góc
    }

    public void setPlaceholderText(String text) {
        this.placeholder = text;
    }

    public void setPlaceholderColor(Color color) {
        this.placeholderColor = color;
    }

    public void setBorderColor(Color color) {
        this.borderColor = color;
    }

    public void setGradientColors(Color color1, Color color2) {
        this.gradientColor1 = color1;
        this.gradientColor2 = color2;
    }

    public void setCornerRadius(int radius) {
        this.cornerRadius = radius;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ gradient border với góc bo tròn
        GradientPaint borderGradient = new GradientPaint(0, 0, gradientColor1, getWidth(), getHeight(), gradientColor2);
        g2d.setPaint(borderGradient);
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

        // Vẽ placeholder
        if (getText().isEmpty()) {
            g2d.setColor(placeholderColor);
            g2d.drawString(placeholder, getInsets().left,
                    (getHeight() - g.getFontMetrics().getHeight()) / 2 + g.getFontMetrics().getAscent());
        }

        g2d.dispose();
    }
}

