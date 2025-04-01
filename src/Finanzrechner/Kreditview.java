package Finanzrechner;
import java.awt.BorderLayout;





import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
public class Kreditview extends JFrame{
	
	private JFrame frame;
	private JPanel contentPane;
	
	
	/*Erzeuge ein Objekt der Fachklasse um die Eigenschaften und Verhaltensweisen des Objektes nutzen zu können
	 * Assoziation*/
	private Kreditrechner Kreditrechner;
	private GradientPanel panelMitFarbverlauf = new GradientPanel();
     // Größe anpassen

	private JTextField tfBetrag;
	private JTextField tfZinssatz;
	private JTextField tfLaufzeit;
	private JTextArea taAusgabe;
	private JTextArea taAusgabe2;
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					Kreditview Kredit = new Kreditview();
					
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	} 
	/**
	 * Create the frame.
	 */
	public Kreditview() {
		frame = new JFrame("Kreditrechner");
		frame.setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1084, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
		contentPane = new GradientPanel();
		contentPane.setToolTipText("");
		contentPane.setForeground(SystemColor.desktop);
		contentPane.add(panelMitFarbverlauf, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setOpaque(true);
		frame.setContentPane(contentPane);
		
	
		
		Diagramm diagrammPanel = new Diagramm();
		diagrammPanel.setOpaque(false); // Hintergrund ausblenden
		diagrammPanel.setVisible(true);
		contentPane.add(diagrammPanel, BorderLayout.CENTER);
		
		
		
		JPanel north = new JPanel();
		north.setBackground(new Color(255, 255, 255));
		north.setForeground(Color.WHITE);
		contentPane.add(north, BorderLayout.NORTH);
		north.setLayout(new GridLayout(0, 1, 0, 0));
		north.setOpaque(false);
														
														JPanel eingabePanel = new JPanel();
														eingabePanel.setBackground(Color.WHITE);
														north.add(eingabePanel);
														eingabePanel.setLayout(new BorderLayout(0, 0));
														eingabePanel.setOpaque(false);
														
														JLabel lblNewLabel = new JLabel("Kreditrechner");
														eingabePanel.add(lblNewLabel, BorderLayout.NORTH);
														lblNewLabel.setBackground(Color.WHITE);
														lblNewLabel.setForeground(new Color(0x10, 0x2A, 0x43));
														lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
														lblNewLabel.setOpaque(false);
														
														JPanel Eingabe = new JPanel();
														eingabePanel.add(Eingabe, BorderLayout.CENTER);
														Eingabe.setForeground(Color.WHITE);
														Eingabe.setLayout(new GridLayout(0, 2, 10, 10)); // 6 Reihen für bessere Struktur
														Eingabe.setBorder(new TitledBorder("Eingabe")); // Rahmen mit Titel
														Eingabe.setBackground(Color.WHITE);
														Eingabe.setOpaque(false);
														
																// Betrag
																JLabel lblBetrag = new JLabel("Betrag (€):");
																lblBetrag.setBackground(Color.WHITE);
																lblBetrag.setForeground(new Color(0x10, 0x2A, 0x43));
																lblBetrag.setFont(new Font("Arial", Font.BOLD, 20));
																Eingabe.add(lblBetrag);
																lblBetrag.setOpaque(false);
																
																		tfBetrag = new JTextField();
																		tfBetrag.setBackground(new Color(0xE0, 0xEA, 0xFC));
																		tfBetrag.setForeground(new Color(0x10, 0x2A, 0x43));
																		tfBetrag.setFont(new Font("Arial", Font.PLAIN, 20));
																		tfBetrag.setText("120000.00");
																		tfBetrag.setOpaque(false);
																		Eingabe.add(tfBetrag);
																		tfBetrag.setColumns(10);
																		
																				// Zinssatz
																				JLabel lblZinssatz = new JLabel("Zinssatz (%):");
																				lblZinssatz.setForeground(new Color(0x10, 0x2A, 0x43));
																				lblZinssatz.setFont(new Font("Arial", Font.BOLD, 20));
																				lblZinssatz.setOpaque(false);
																				Eingabe.add(lblZinssatz);
																				
																				
																						tfZinssatz = new JTextField();
																						tfZinssatz.setForeground(new Color(0x10, 0x2A, 0x43));
																						tfZinssatz.setBackground(new Color(0xE0, 0xEA, 0xFC));
																						tfZinssatz.setFont(new Font("Arial", Font.PLAIN, 20));
																						tfZinssatz.setText("4.5");
																						tfZinssatz.setOpaque(false);
																						Eingabe.add(tfZinssatz);
																						tfZinssatz.setColumns(10);
																						
																								// Laufzeit
																								JLabel lblLaufzeit = new JLabel("Laufzeit (Jahre):");
																								lblLaufzeit.setForeground(new Color(0x10, 0x2A, 0x43));
																								lblLaufzeit.setFont(new Font("Arial", Font.BOLD, 20));
																								lblLaufzeit.setOpaque(false);
																								Eingabe.add(lblLaufzeit);
																								
																										tfLaufzeit = new JTextField();
																										tfLaufzeit.setForeground(new Color(0x10, 0x2A, 0x43));
																										tfLaufzeit.setBackground(new Color(0xE0, 0xEA, 0xFC));
																										tfLaufzeit.setFont(new Font("Arial", Font.PLAIN, 20));
																										tfLaufzeit.setText("7");
																										tfLaufzeit.setOpaque(false);
																										Eingabe.add(tfLaufzeit);
																										tfLaufzeit.setColumns(10);
																										
																										JPanel Löschen = new JPanel();
																										Löschen.setBackground(Color.WHITE);
																										Löschen.setOpaque(false);
																										eingabePanel.add(Löschen, BorderLayout.EAST);
																										Löschen.setLayout(new GridLayout(0, 1, 0, 0));
																										
																										JButton btLöschen_1 = new JButton("");
																										btLöschen_1.addActionListener(new ActionListener() {
																											@Override
																											public void actionPerformed(ActionEvent e) {
																												tfBetrag.setText("");
																											}
																										});
																										btLöschen_1.setIcon(new ImageIcon(Kreditview.class.getResource("/Bilder/entfernen.png")));
																										Löschen.add(btLöschen_1);
																										btLöschen_1.setPreferredSize(new Dimension(20, 10));
																										btLöschen_1.setOpaque(false);
																										btLöschen_1.setFocusPainted(false);
																										btLöschen_1.setContentAreaFilled(false);
																										btLöschen_1.setBorderPainted(false);
																										btLöschen_1.setContentAreaFilled(false); 
																										btLöschen_1.setBackground(Color.WHITE);
																										
																							           																							         
																										JButton btLöschen_2 = new JButton("");
																										btLöschen_2.setIcon(new ImageIcon(Kreditview.class.getResource("/Bilder/entfernen.png")));
																										Löschen.add(btLöschen_2);
																										btLöschen_2.setBackground(Color.WHITE);
																										btLöschen_2.setPreferredSize(new Dimension(60, 40));																									
																										btLöschen_2.setFocusPainted(false);  // Entfernt den Fokus-Rahmen
																										btLöschen_2.setBorderPainted(false); // Entfernt den Rand (optional)
																										btLöschen_2.setContentAreaFilled(false); // Deaktiviert den Klick-Effekt
																										btLöschen_2.setOpaque(false);
																										
																										btLöschen_2.addActionListener(new ActionListener() {
																											@Override
																											public void actionPerformed(ActionEvent e) {
																												tfZinssatz.setText("");
																											}
																										});
																										
																										JButton btLöschen_3 = new JButton("");
																										btLöschen_3.setForeground(Color.BLACK);																										
																										btLöschen_3.setIcon(new ImageIcon(Kreditview.class.getResource("/Bilder/entfernen.png")));
																										btLöschen_3.addActionListener(new ActionListener() {
																											@Override
																											public void actionPerformed(ActionEvent e) {
																												tfLaufzeit.setText("");
																											}
																										});
																										btLöschen_3.setPreferredSize(new Dimension(60, 40));
																										btLöschen_3.setOpaque(false);
																										btLöschen_3.setFocusPainted(false);
																										btLöschen_3.setBorderPainted(false);
																										btLöschen_3.setContentAreaFilled(false);
																										
																										Löschen.add(btLöschen_3);
																										
																									
														
														JPanel west = new JPanel();
														contentPane.add(west, BorderLayout.WEST);
														west.setLayout(new GridLayout(0, 1, 10, 1));
														
														JButton btFälligkeitsdarlehen = new JButton("F\u00E4lligkeitsdarlehen");
														btFälligkeitsdarlehen.setBackground(new Color(0x3D, 0x84, 0xA8));
														btFälligkeitsdarlehen.setForeground(Color.WHITE);
														btFälligkeitsdarlehen.setFont(new Font("Arial", Font.BOLD, 28));
														btFälligkeitsdarlehen.addActionListener(new ActionListener() {
															@Override
															public void actionPerformed(ActionEvent e) {
																Kreditrechner = new Kreditrechner();
																//Eingabe
																leseBetrag();
																leseZinssatz();
																leseLaufzeit();
																//Verarbeitung
																Kreditrechner.berechneFaelligkeitsdarlehen();
																//Ausgabe
																schreibeErgebnis1und2();
																 diagrammPanel.setJaehrlicheZahlungen(Kreditrechner.getJaehrlicheZahlungen());
																
															}
														});
														west.add(btFälligkeitsdarlehen);
														
														JButton btRatendarlehen = new JButton("Ratendarlehen");
														btRatendarlehen.setFont(new Font("Arial", Font.BOLD, 28));
														btRatendarlehen.setForeground(Color.WHITE);
														btRatendarlehen.setBackground(new Color(0x3D, 0x84, 0xA8));
														btRatendarlehen.addActionListener(new ActionListener() {
															@Override
															public void actionPerformed(ActionEvent e) {
																Kreditrechner = new Kreditrechner();
																//Eingabe
																leseBetrag();
																leseZinssatz();
																leseLaufzeit();
																//Verarbeitung
																Kreditrechner.berechneRatendarlehen();
																Kreditrechner.berechneRatendarlehenJaerlicheZahlungen();
																//Ausgabe
																schreibeErgebnis1und2();
																 diagrammPanel.setJaehrlicheZahlungen(Kreditrechner.getJaehrlicheZahlungen());
																
															}
														});
														west.add(btRatendarlehen);
														
														JButton btAnnuitaetendarlehen = new JButton("Annuitaetendarlehen");
														btAnnuitaetendarlehen.setFont(new Font("Arial", Font.BOLD, 28));
														btAnnuitaetendarlehen.setBackground(new Color(0x3D, 0x84, 0xA8));
														btAnnuitaetendarlehen.setForeground(Color.WHITE);
														btAnnuitaetendarlehen.addActionListener(new ActionListener() {
															@Override
															public void actionPerformed(ActionEvent e) {
																Kreditrechner = new Kreditrechner();
																leseBetrag();
																leseZinssatz();
																leseLaufzeit();
																//Verarbeitung
																Kreditrechner.berechneAnnuitaetenfaktor();
																Kreditrechner.berechneAnnuitaetendarlehen();
																setKreditrechner(Kreditrechner);
																//Ausgabe
																schreibeErgebnisAnnutitaet();
																diagrammPanel.setJaehrlicheZahlungen(Kreditrechner.getJaehrlicheZahlungen());
															}
														});
														west.add(btAnnuitaetendarlehen);
														
														JPanel east = new JPanel();
														contentPane.add(east, BorderLayout.EAST);
														east.setOpaque(false);
														east.setLayout(new GridLayout(0, 1, 0, 0));
														
														taAusgabe = new JTextArea();
														taAusgabe.setEditable(false);
														east.add(taAusgabe);
														taAusgabe.setTabSize(3);
														taAusgabe.setFont(new Font("SansSerif", Font.PLAIN, 20));
														taAusgabe.setRows(5);
														taAusgabe.setColumns(5);
														taAusgabe.setForeground(new Color(0x10, 0x2A, 0x43));
														taAusgabe.setBackground(Color.WHITE);
														taAusgabe.setOpaque(false);
														taAusgabe2 = new JTextArea();
														taAusgabe2.setFont(new Font("SansSerif", Font.PLAIN, 15));
														taAusgabe2.setEditable(false);
														taAusgabe2.setOpaque(false);
														east.add(taAusgabe2);
														
														 // Hover-Effekt für den Button
														btAnnuitaetendarlehen.addMouseListener(new java.awt.event.MouseAdapter() {
												            @Override
															public void mouseEntered(java.awt.event.MouseEvent evt) {
												            	btAnnuitaetendarlehen.setBackground(new Color(0x2A, 0x64, 0x78)); // Dunkleres Blau
												            }

												            @Override
															public void mouseExited(java.awt.event.MouseEvent evt) {
												            	btAnnuitaetendarlehen.setBackground(new Color(0x3D, 0x84, 0xA8)); // Normalfarbe
												            }
												        });
														
														btRatendarlehen.addMouseListener(new java.awt.event.MouseAdapter() {
												            @Override
															public void mouseEntered(java.awt.event.MouseEvent evt) {
												            	btRatendarlehen.setBackground(new Color(0x2A, 0x64, 0x78)); // Dunkleres Blau
												            }

												            @Override
															public void mouseExited(java.awt.event.MouseEvent evt) {
												            	btRatendarlehen.setBackground(new Color(0x3D, 0x84, 0xA8)); // Normalfarbe
												            }
												        });
														
														btFälligkeitsdarlehen.addMouseListener(new java.awt.event.MouseAdapter() {
												            @Override
															public void mouseEntered(java.awt.event.MouseEvent evt) {
												            	btFälligkeitsdarlehen.setBackground(new Color(0x2A, 0x64, 0x78)); // Dunkleres Blau
												            }

												            @Override
															public void mouseExited(java.awt.event.MouseEvent evt) {
												            	btFälligkeitsdarlehen.setBackground(new Color(0x3D, 0x84, 0xA8)); // Normalfarbe
												            }
												        });
		
														}
	
	public void setKreditrechner(Kreditrechner pKreditrechner){
		this.Kreditrechner = pKreditrechner;
	}
	public Kreditrechner getKreditrechner(){
		return this.Kreditrechner;
	}

	//Hilfsmethoden
		/*Deklariere und Implementiere die Lesemethoden*/
		public void leseBetrag(){
		String betrag = (tfBetrag.getText());
		betrag = betrag.replace(",", ".");
	    try {
	        // Versuche, den String in eine double-Zahl umzuwandeln
	        double value = Double.parseDouble(betrag);
	        
	        // Überprüfe, ob der Wert größer als 0 ist
	        if (value <= 0) {
	        	JOptionPane.showMessageDialog(null, Kreditrechner.fehlercode_1());
	        	Kreditrechner.setBetrag(120000.00);
	        } else {
	        	// Nur wenn alles passt, den Wert setzen
	            Kreditrechner.setBetrag(value);
	        }
	    } catch (NumberFormatException e) {
	        // Diese Exception fängt ungültige Eingaben (wie Buchstaben) ab
	    	JOptionPane.showMessageDialog(null, Kreditrechner.fehlercode_4());
	    	Kreditrechner.setBetrag(120000.00);
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
		        	JOptionPane.showMessageDialog(null, Kreditrechner.fehlercode_2());
		        	Kreditrechner.setZinssatz(4.5);
		        } else {
		        	// Nur wenn alles passt, den Wert setzen
		            Kreditrechner.setZinssatz(value);
		        }
		    } catch (NumberFormatException e) {
		        // Diese Exception fängt ungültige Eingaben (wie Buchstaben) ab
		    	JOptionPane.showMessageDialog(null, Kreditrechner.fehlercode_4());
		    	Kreditrechner.setZinssatz(4.5);
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
	        	JOptionPane.showMessageDialog(null, Kreditrechner.fehlercode_3());
	        	Kreditrechner.setLaufzeit(7);
	        } else {
	        	// Nur wenn alles passt, den Wert setzen
	            Kreditrechner.setLaufzeit(value);
	        }
	    } catch (NumberFormatException e) {
	        // Diese Exception fängt ungültige Eingaben (wie Buchstaben) ab
	    	JOptionPane.showMessageDialog(null, Kreditrechner.fehlercode_4());
	    	Kreditrechner.setLaufzeit(7);
	    	}
		}
		
	//SchreibeMethoden
		public void schreibeErgebnis1und2(){
			String ergebnis = Kreditrechner.schreibeKredit1und2undZins();
			taAusgabe.setText(ergebnis);
			taAusgabe2.setText(Kreditrechner.toString());
			}
		public void schreibeErgebnisAnnutitaet() {
			String ergebnis = Kreditrechner.schreibeAnuitaet();
			taAusgabe.setText(ergebnis);	
			taAusgabe2.setText(Kreditrechner.toString());
			}

		
}
	
		
