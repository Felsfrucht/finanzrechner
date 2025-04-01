package Finanzrechner;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GradientPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // 🌈 Sanfter Farbverlauf von sehr hellem Blau nach Grau-Blau
        GradientPaint gradient = new GradientPaint(
                0, 0, new Color(235, 240, 250), // Sehr helles Blau (#EBF0FA)
                0, getHeight(), new Color(225, 230, 245) // Sehr helles Grau-Blau (#E1E6F5)
        );
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Dezente Wellen für eine sanfte Textur
        drawSubtleWave(g2d, 60, 15, new Color(200, 210, 230, 30));
        drawSubtleWave(g2d, 150, 20, new Color(190, 200, 220, 25));
    }

    private void drawSubtleWave(Graphics2D g2d, int yStart, int amplitude, Color color) {
        int width = getWidth();
        int height = getHeight();
        g2d.setColor(color);

        int steps = 20;
        int[] xPoints = new int[steps + 2];
        int[] yPoints = new int[steps + 2];

        for (int i = 0; i <= steps; i++) {
            xPoints[i] = i * width / steps;
            yPoints[i] = yStart + (int) (Math.sin(i * Math.PI / steps) * amplitude);
        }

        // Schließt die Welle unten
        xPoints[steps + 1] = width;
        yPoints[steps + 1] = height;

        g2d.fillPolygon(xPoints, yPoints, steps + 2);
    }
}
