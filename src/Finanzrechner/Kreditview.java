package Finanzrechner;
import java.awt.BorderLayout;





import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import javax.swing.border.TitledBorder;
import javax.swing.JSlider;
public class Kreditview extends JFrame{
	private JFrame frame;
	private JPanel contentPane;
	private JTextField tfBetrag;
	private JTextField tfZinssatz;
	private JTextField tfLaufzeit;
	private JTextArea taAusgabe;
	
	
	/*Erzeuge ein Objekt der Fachklasse um die Eigenschaften und Verhaltensweisen des Objektes nutzen zu kˆnnen
	 * Assoziation*/
	Kreditrechner Kreditrechner;
	Diagramm diagrammPanel;
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(960, 684);
        frame.setVisible(true);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(SystemColor.menu);
		contentPane.setForeground(SystemColor.desktop);
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(new JLabel("Willkommen auf der neuen Seite!"));
		
	    // Diagramm-Panel hinzuf¸gen
	    diagrammPanel = new Diagramm();
	    diagrammPanel.setBounds(500, 500, 400, 300);
	    diagrammPanel.setBackground(Color.WHITE);
	    contentPane.add(diagrammPanel);

		
		JLabel lb‹berschrift = new JLabel("Finanzrechner");
		lb‹berschrift.setForeground(Color.WHITE);
		lb‹berschrift.setBackground(SystemColor.textHighlight);
		lb‹berschrift.setOpaque(true);
		lb‹berschrift.setFont(new Font("Impact", Font.PLAIN, 22));
		lb‹berschrift.setBounds(10, 11, 711, 48);
		contentPane.add(lb‹berschrift);
		
		JLabel lbBetrag = new JLabel("Betrag");
		lbBetrag.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lbBetrag.setBounds(82, 89, 111, 28);
		contentPane.add(lbBetrag);
		
		JLabel lbZinssatz = new JLabel("Zinssatz");
		lbZinssatz.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lbZinssatz.setBounds(82, 173, 91, 29);
		contentPane.add(lbZinssatz);
		
		JLabel lbLaufzeit = new JLabel("Laufzeit");
		lbLaufzeit.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lbLaufzeit.setBounds(82, 266, 91, 28);
		contentPane.add(lbLaufzeit);
		
		tfBetrag = new JTextField();
		tfBetrag.setFont(new Font("SansSerif", Font.PLAIN, 15));
		tfBetrag.setText("120000.00");
		tfBetrag.setToolTipText("");
		tfBetrag.setBounds(82, 118, 589, 28);
		contentPane.add(tfBetrag);
		tfBetrag.setColumns(10);
		
		JLabel lbEuro = new JLabel("\u20AC");
		lbEuro.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbEuro.setBounds(681, 119, 29, 28);
		contentPane.add(lbEuro);
		
		tfZinssatz = new JTextField();
		tfZinssatz.setFont(new Font("SansSerif", Font.PLAIN, 15));
		tfZinssatz.setText("2.5");
		tfZinssatz.setBounds(82, 210, 589, 28);
		contentPane.add(tfZinssatz);
		tfZinssatz.setColumns(10);
		
		JLabel lbProzent = new JLabel("%");
		lbProzent.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbProzent.setBounds(681, 210, 29, 28);
		contentPane.add(lbProzent);
		
		tfLaufzeit = new JTextField();
		tfLaufzeit.setFont(new Font("SansSerif", Font.PLAIN, 15));
		tfLaufzeit.setText("6");
		tfLaufzeit.setBounds(82, 305, 589, 28);
		contentPane.add(tfLaufzeit);
		tfLaufzeit.setColumns(10);
		
		JLabel lbJahre = new JLabel("Jahre");
		lbJahre.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbJahre.setBounds(681, 305, 40, 28);
		contentPane.add(lbJahre);
		
		JButton btDelete = new JButton("");
		btDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfBetrag.setText("");
				tfZinssatz.setText("");
				tfLaufzeit.setText("");
				
			}
		});
		btDelete.setForeground(new Color(0, 0, 0));
		btDelete.setIcon(new ImageIcon(Hauptfenster.class.getResource("/Bilder/icons8-entfernen-60.png")));
		btDelete.setBackground(new Color(255, 255, 255));
		btDelete.setSelectedIcon(new ImageIcon(Hauptfenster.class.getResource("/Bilder/icons8-entfernen-60.png")));
		btDelete.setBounds(82, 344, 60, 60);
		contentPane.add(btDelete);
		
		// JScrollPane erstellen
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(421, 372, 250, 112);
		contentPane.add(scrollPane_1);
		scrollPane_1.setBorder(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		scrollPane.setBorder(null);
		
		// TextArea hinzuf¸gen
		taAusgabe = new JTextArea();
		taAusgabe.setFont(new Font("SansSerif", Font.PLAIN, 18));
		taAusgabe.setBackground(SystemColor.menu);
		scrollPane.setViewportView(taAusgabe);



		
		
		
		JButton btF‰lligkeitsdarlehen = new JButton("F\u00E4lligkeitsdarlehen");
		btF‰lligkeitsdarlehen.setToolTipText("Beschreibung eines Darlehens, bei dem die R\u00FCckzahlung am Ende der Laufzeit erfolgt.");
		btF‰lligkeitsdarlehen.setForeground(SystemColor.desktop);
		btF‰lligkeitsdarlehen.setBackground(SystemColor.menu);
		btF‰lligkeitsdarlehen.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btF‰lligkeitsdarlehen.addActionListener(new ActionListener() {
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
		btF‰lligkeitsdarlehen.setBounds(82, 511, 154, 37);
		contentPane.add(btF‰lligkeitsdarlehen);
		
		JButton btRatendarlehen = new JButton("Ratendarlehen");
		btRatendarlehen.setToolTipText("Ein Darlehen mit gleichbleibenden Tilgungsraten");
		btRatendarlehen.setForeground(SystemColor.desktop);
		btRatendarlehen.setBackground(SystemColor.menu);
		btRatendarlehen.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btRatendarlehen.addActionListener(new ActionListener() {
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
		btRatendarlehen.setBounds(82, 559, 154, 37);
		contentPane.add(btRatendarlehen);
		
		JButton btAnnuitaetendarlehen = new JButton("Annuit\u00E4tendarlehen");
		btAnnuitaetendarlehen.setToolTipText("Ein Darlehen mit konstanten j\u00E4hrlichen Annuit\u00E4ten (Zins- und Tilgungsanteile \u00E4ndern sich).");
		btAnnuitaetendarlehen.setForeground(SystemColor.desktop);
		btAnnuitaetendarlehen.setBackground(SystemColor.menu);
		btAnnuitaetendarlehen.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btAnnuitaetendarlehen.addActionListener(new ActionListener() {
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
		btAnnuitaetendarlehen.setBounds(82, 607, 154, 37);
		contentPane.add(btAnnuitaetendarlehen);
		
		
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
		double betrag = Double.valueOf(tfBetrag.getText());
		Kreditrechner.setBetrag(betrag);	
		}
		public void leseZinssatz() {
		double zinssatz = Double.valueOf(tfZinssatz.getText());
		zinssatz = zinssatz / 100;
		Kreditrechner.setZinssatz(zinssatz);
		}
		public void leseLaufzeit() {
		double laufzeit = Double.valueOf(tfLaufzeit.getText());
		Kreditrechner.setLaufzeit(laufzeit);
		}
		
	//SchreibeMethoden
		public void schreibeErgebnis1und2(){
			String ergebnis = Kreditrechner.schreibeKredit1und2();
			taAusgabe.setText(ergebnis);
			}
		public void schreibeErgebnisAnnutitaet() {
			String ergebnis = Kreditrechner.schreibeAnuitaet();
			taAusgabe.setText(ergebnis);	
			}
		
		
}
	
	
	
