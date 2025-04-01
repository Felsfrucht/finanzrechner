package Finanzrechner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class Zinsview extends JFrame {

    private JPanel contentPane;
    private JTextField tfBetrag;
    private JTextField tfZinssatz;
    private JTextField tfLaufzeit;
    private JComboBox<String> cbZinsart;
    private String selectedOption;
    private JTextArea taEndkapital;
    private JTextArea taAusgabe2;
    
    // Instanzen der Fachklassen
    private Zinsrechner Zinsrechner;
    private Diagramm diagrammPanel;
    
    // Verwende das gleiche GradientPanel wie im Kreditrechner
    GradientPanel gradientPanel = new GradientPanel();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Zinsview frame = new Zinsview();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public Zinsview() {
        setTitle("Zinsrechner");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1084, 600);
        setLocationRelativeTo(null);

        // Setze das GradientPanel als ContentPane und verwende BorderLayout
        contentPane = new GradientPanel();
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);
        
                // Center-Panel: Diagramm
        		diagrammPanel = new Diagramm();
                diagrammPanel.setOpaque(false);
                diagrammPanel.setVisible(true);
                contentPane.add(diagrammPanel, BorderLayout.CENTER);
               

        // North-Panel: Überschrift und Eingabefelder
        JPanel north = new JPanel(new BorderLayout());
        north.setOpaque(false);
        contentPane.add(north, BorderLayout.NORTH);

        // Überschrift
        JLabel headerLabel = new JLabel("Zinsrechner", SwingConstants.LEFT);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 40));
        headerLabel.setForeground(new Color(0x10, 0x2A, 0x43));
        north.add(headerLabel, BorderLayout.NORTH);

        // Eingabe-Panel mit TitledBorder
        JPanel eingabePanel = new JPanel();
        eingabePanel.setOpaque(false);
        eingabePanel.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), "Eingabe"));
        north.add(eingabePanel, BorderLayout.CENTER);
        eingabePanel.setLayout(new BorderLayout(0, 0));

        // Panel für die Eingabefelder (GridLayout: 3 Reihen, 2 Spalten)
        JPanel inputFieldsPanel = new JPanel(new BorderLayout(10, 10));
        inputFieldsPanel.setOpaque(false);
        eingabePanel.add(inputFieldsPanel, BorderLayout.CENTER);

        JPanel gridPanel = new JPanel(new java.awt.GridLayout(3, 2, 10, 10));
        gridPanel.setOpaque(false);
        inputFieldsPanel.add(gridPanel, BorderLayout.CENTER);

        // Betrag
        JLabel lblBetrag = new JLabel("Betrag (€):");
        lblBetrag.setFont(new Font("Arial", Font.BOLD, 20));
        lblBetrag.setForeground(new Color(0x10, 0x2A, 0x43));
        gridPanel.add(lblBetrag);

        tfBetrag = new JTextField("65000.00");
        tfBetrag.setFont(new Font("Arial", Font.PLAIN, 20));
        tfBetrag.setBackground(new Color(0xE0, 0xEA, 0xFC));
        tfBetrag.setForeground(new Color(0x10, 0x2A, 0x43));
        gridPanel.add(tfBetrag);

        // Zinssatz
        JLabel lblZinssatz = new JLabel("Zinssatz (%):");
        lblZinssatz.setFont(new Font("Arial", Font.BOLD, 20));
        lblZinssatz.setForeground(new Color(0x10, 0x2A, 0x43));
        gridPanel.add(lblZinssatz);

        tfZinssatz = new JTextField("2.5");
        tfZinssatz.setFont(new Font("Arial", Font.PLAIN, 20));
        tfZinssatz.setBackground(new Color(0xE0, 0xEA, 0xFC));
        tfZinssatz.setForeground(new Color(0x10, 0x2A, 0x43));
        gridPanel.add(tfZinssatz);

        // Laufzeit
        JLabel lblLaufzeit = new JLabel("Laufzeit (Jahre):");
        lblLaufzeit.setFont(new Font("Arial", Font.BOLD, 20));
        lblLaufzeit.setForeground(new Color(0x10, 0x2A, 0x43));
        gridPanel.add(lblLaufzeit);

        tfLaufzeit = new JTextField("7");
        tfLaufzeit.setFont(new Font("Arial", Font.PLAIN, 20));
        tfLaufzeit.setBackground(new Color(0xE0, 0xEA, 0xFC));
        tfLaufzeit.setForeground(new Color(0x10, 0x2A, 0x43));
        gridPanel.add(tfLaufzeit);
        
                // Delete-Buttons 
                JPanel deletePanel = new JPanel(new java.awt.GridLayout(0, 1, 5, 5));
                inputFieldsPanel.add(deletePanel, BorderLayout.EAST);
                deletePanel.setOpaque(false);
                JButton btDeleteBetrag = new JButton(new ImageIcon(Zinsview.class.getResource("/Bilder/entfernen.png")));
                btDeleteBetrag.setOpaque(false);
                btDeleteBetrag.setFocusPainted(false);
                btDeleteBetrag.setContentAreaFilled(false);
                btDeleteBetrag.setBorderPainted(false);
                btDeleteBetrag.addActionListener(e -> tfBetrag.setText(""));
                deletePanel.add(btDeleteBetrag);
                
                        JButton btDeleteZinssatz = new JButton(new ImageIcon(Zinsview.class.getResource("/Bilder/entfernen.png")));
                        btDeleteZinssatz.setOpaque(false);
                        btDeleteZinssatz.setFocusPainted(false);
                        btDeleteZinssatz.setContentAreaFilled(false);
                        btDeleteZinssatz.setBorderPainted(false);
                        btDeleteZinssatz.addActionListener(e -> tfZinssatz.setText(""));
                        deletePanel.add(btDeleteZinssatz);
                        
                                JButton btDeleteLaufzeit = new JButton(new ImageIcon(Zinsview.class.getResource("/Bilder/entfernen.png")));
                                btDeleteLaufzeit.setOpaque(false);
                                btDeleteLaufzeit.setFocusPainted(false);
                                btDeleteLaufzeit.setContentAreaFilled(false);
                                btDeleteLaufzeit.setBorderPainted(false);
                                btDeleteLaufzeit.addActionListener(e -> tfLaufzeit.setText(""));
                                deletePanel.add(btDeleteLaufzeit);

        // West-Panel: Berechnungs-Button
        JPanel west = new JPanel();
        west.setOpaque(false);
        contentPane.add(west, BorderLayout.WEST);

        JButton btBerechnen = new JButton("Berechnen");
        btBerechnen.setFont(new Font("Arial", Font.BOLD, 28));
        btBerechnen.setBackground(new Color(0x3D, 0x84, 0xA8));
        btBerechnen.setForeground(Color.WHITE);
        btBerechnen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Zinsrechner = new Zinsrechner();
                leseBetrag();
                leseZinssatz();
                leseLaufzeit();
                leseZinsart();
                VerarbeiteZinsart();
                schreibeEndkapital();
                
            }
        });
        // Hover-Effekt
        btBerechnen.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btBerechnen.setBackground(new Color(0x2A, 0x64, 0x78));
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btBerechnen.setBackground(new Color(0x3D, 0x84, 0xA8));
            }
        });
        west.setLayout(new BorderLayout(0, 0));
        
                // ComboBox für Zinsart
                cbZinsart = new JComboBox<>();
                west.add(cbZinsart, BorderLayout.NORTH);
                cbZinsart.setModel(new DefaultComboBoxModel<>(new String[] {"Zinsberechnung", "Zinseszinsberechnung"}));
                cbZinsart.setFont(new Font("Arial", Font.PLAIN, 20));
                cbZinsart.setBackground(new Color(0x3D, 0x84, 0xA8));
                cbZinsart.setForeground(Color.WHITE);
        west.add(btBerechnen, BorderLayout.CENTER);
                
                JPanel East = new JPanel();                
                East.setOpaque(false);
                East.setLayout(new GridLayout(0, 1, 0, 0));
                contentPane.add(East, BorderLayout.EAST);
                
                        // East-Panel: Ausgabe
                        taEndkapital = new JTextArea();
                        East.add(taEndkapital);
                        taEndkapital.setFont(new Font("Arial", Font.PLAIN, 20));
                        taEndkapital.setForeground(new Color(0x10, 0x2A, 0x43));
                        taEndkapital.setOpaque(false);
                        
                        taAusgabe2 = new JTextArea();
                        taAusgabe2.setOpaque(false);
                        taAusgabe2.setForeground(new Color(16, 42, 67));
                        taAusgabe2.setFont(new Font("SansSerif", Font.PLAIN, 15));
                        East.add(taAusgabe2);
    }
    
    // Hilfsmethoden
    public void leseBetrag(){
		String betrag = (tfBetrag.getText());
		betrag = betrag.replace(",", ".");
	    try {
	        // Versuche, den String in eine double-Zahl umzuwandeln
	        double value = Double.parseDouble(betrag);
	        
	        // Überprüfe, ob der Wert größer als 0 ist
	        if (value <= 0) {
	        	JOptionPane.showMessageDialog(null, Zinsrechner.fehlercode_1());
	        	Zinsrechner.setBetrag(120000.00);
	        } else {
	        	// Nur wenn alles passt, den Wert setzen
	        	Zinsrechner.setBetrag(value);
	        }
	    } catch (NumberFormatException e) {
	        // Diese Exception fängt ungültige Eingaben (wie Buchstaben) ab
	    	JOptionPane.showMessageDialog(null, Zinsrechner.fehlercode_4());
	    	Zinsrechner.setBetrag(120000.00);
	    }
		
		}
		public void leseZinssatz() {
			String zinssatz = tfZinssatz.getText();
			zinssatz = zinssatz.replace(",", ".");
		    try {
		        // Versuche, den String in eine double-Zahl umzuwandeln
		        double value = Double.parseDouble(zinssatz);
		        value = value/100;
		        // Überprüfe, ob der Wert größer als 0 ist
		        if (value <= 0) {
		        	JOptionPane.showMessageDialog(null, Zinsrechner.fehlercode_2());
		        	Zinsrechner.setZinssatz(4.5);
		        } else {
		        	// Nur wenn alles passt, den Wert setzen
		        	Zinsrechner.setZinssatz(value);
		        }
		    } catch (NumberFormatException e) {
		        // Diese Exception fängt ungültige Eingaben (wie Buchstaben) ab
		    	JOptionPane.showMessageDialog(null, Zinsrechner.fehlercode_4());
		    	Zinsrechner.setZinssatz(4.5);
		    }
		}
		public void leseLaufzeit() {
		String laufzeit = tfLaufzeit.getText();
		laufzeit = laufzeit.replace(",", ".");
	    try {
	        // Versuche, den String in eine double-Zahl umzuwandeln
	        Integer value = Integer.parseInt(laufzeit);
	        // Überprüfe, ob der Wert größer als 0 ist
	        if (value <= 0) {
	        	JOptionPane.showMessageDialog(null, Zinsrechner.fehlercode_3());
	        	Zinsrechner.setLaufzeit(7);
	        } else {
	        	// Nur wenn alles passt, den Wert setzen
	        	Zinsrechner.setLaufzeit(value);
	        }
	    } catch (NumberFormatException e) {
	        // Diese Exception fängt ungültige Eingaben (wie Buchstaben) ab
	    	JOptionPane.showMessageDialog(null, Zinsrechner.fehlercode_4());
	    	Zinsrechner.setLaufzeit(7);
	    	}
		}
    
    public void leseZinsart() {
        this.selectedOption = (String) cbZinsart.getSelectedItem();
    }
    
    public void VerarbeiteZinsart() {
        if ("Zinsberechnung".equals(selectedOption)) {
            Zinsrechner.berechneZinssatzlinear();
        } else {
            Zinsrechner.berechneZinssatzexponentiell();
        }
    }
    
    public void schreibeEndkapital() {
        String ergebnis = Zinsrechner.schreibeKredit1und2undZins();
        taEndkapital.setText(ergebnis);
        taAusgabe2.setText(Zinsrechner.toString());
        diagrammPanel.setJaehrlicheZahlungen(Zinsrechner.getJaehrlicheZahlungen());
        diagrammPanel.repaint();
    }
}
