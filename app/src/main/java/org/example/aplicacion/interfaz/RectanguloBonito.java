package org.example.aplicacion.interfaz;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RectanguloBonito extends JPanel {

    private int cornerRadius = 30;

    public RectanguloBonito() {
        setPreferredSize(new Dimension(300, 200));
        setBackground(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLUE);
        g2d.fillRoundRect(50,  105, getWidth() - 100, getHeight() - 100, cornerRadius, cornerRadius);
        g2d.dispose();

        Graphics2D g2d1 = (Graphics2D) g.create();
        g2d1.setColor(Color.white);
        g2d1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d1.fillRoundRect( 55 , 110, getWidth() - 110, getHeight() - 110, cornerRadius - 10, cornerRadius - 10);
        g2d1.dispose();
    }
}