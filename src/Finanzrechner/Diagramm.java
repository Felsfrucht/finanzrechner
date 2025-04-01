package Finanzrechner;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class Diagramm extends JPanel {
    private double[] jaehrlicheZahlungen;
    
    public void setJaehrlicheZahlungen(double[] jaehrlicheZahlungen) {
        this.jaehrlicheZahlungen = jaehrlicheZahlungen;
        repaint();
    }
  
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        if (jaehrlicheZahlungen == null || jaehrlicheZahlungen.length == 0) {
            return;
        }

        Graphics2D g2 = (Graphics2D) g;
        int yPos = 100;
        int xPos = 50;
        int maxHeight = 150;
        int maxWidth = getWidth() - 100;
        double max = 0;

        // Höchsten Wert im Array finden
        for (double value : jaehrlicheZahlungen) {
            if (value > max) max = value;
        }

        // Breite der Balken berechnen
        double balkenWidth = maxWidth / jaehrlicheZahlungen.length - 5;
        double balkenXPos = xPos;

        // x-Achse und y-Achse zeichnen
        g2.setColor(Color.BLACK);
        g2.drawLine(xPos - 10, yPos + maxHeight, xPos + (int) maxWidth, yPos + maxHeight);  // x-Achse
        g2.drawLine(xPos, yPos, xPos, yPos + maxHeight); // y-Achse

        // Achsenbeschriftung für y-Achse
        g2.setFont(new Font("Arial", Font.PLAIN, 12));
        g2.drawString("0", xPos - 25, yPos + maxHeight);
        g2.drawString(String.format("%.0f", max), xPos - 25, yPos);  // Höchster Wert auf der y-Achse

        // Balken zeichnen
        for (int i = 0; i < jaehrlicheZahlungen.length; i++) {
            double balkenHeight = (jaehrlicheZahlungen[i] / max) * maxHeight;
            double balkenYPos = yPos + (maxHeight - balkenHeight);

            // Balken zeichnen
            Rectangle2D.Double r = new Rectangle2D.Double(balkenXPos, balkenYPos, balkenWidth, balkenHeight);
            g2.setColor(new Color(0, 128, 255));  // Blau für den Balken
            g2.fill(r);
            g2.setColor(Color.BLACK);
            g2.draw(r);

            // Beschriftung der Balkenwerte
            g2.setFont(new Font("Arial", Font.PLAIN, 12));
            g2.drawString(String.format("%.2f", jaehrlicheZahlungen[i]), 
                          (int) (balkenXPos + balkenWidth / 3), (int) (balkenYPos - 5));

            // x-Achsen-Beschriftungen
            String xLabel = "" + (i + 1);
            g2.drawString(xLabel, (int) (balkenXPos + balkenWidth / 3), yPos + maxHeight + 15);

            balkenXPos += balkenWidth + 5;  // Abstand zwischen den Balken
        }

        // x-Achse-Beschriftung (Jahre)
        g2.setFont(new Font("Arial", Font.PLAIN, 14));
        g2.drawString("Jahre", getWidth() / 2 - 20, yPos + maxHeight + 35);  // Zentrale Platzierung für die Achse

        // y-Achse-Beschriftung (Betrag)
        g2.rotate(-Math.PI / 2); // Dreht die y-Achse-Beschriftung
        g2.drawString("Betrag (€)", -getHeight() / 2, 15);  // Position der y-Achse-Beschriftung
    }
}
