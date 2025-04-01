package Finanzrechner;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class Zinsview extends JFrame
{
	private JPanel contentPane;
	private JTextField tfBetrag;
	private JTextField tfZinssatz;
	private JTextField tfLaufzeit;
	private JComboBox cbZinsart;
	private String selectedOption;
	private JTextArea taEndkapital;
	Color hellblau = new Color(77,107,221);
	
	/*Erzeuge ein Objekt der Fachklasse um die Eigenschaften und Verhaltensweisen des Objektes nutzen zu kˆnnen
	 * Assoziation*/
	private Rechner finanzrechner = new Rechner();
	Hauptfenster frame = new Hauptfenster();
	private Zinsrechner Zinsrechner;
	Diagramm diagrammPanel;
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Zinsview Zins = new Zinsview();
					Zins.setVisible(true);
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
	public Zinsview()
	{
		setTitle("Zinsrechner");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 700);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(SystemColor.menu);
		contentPane.setForeground(SystemColor.desktop);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(new JLabel("Willkommen auf der neuen Seite!"));
		
		 // Diagramm-Panel hinzuf¸gen
	    diagrammPanel = new Diagramm();
	    diagrammPanel.setBounds(500, 500, 400, 300);
	    diagrammPanel.setBackground(Color.WHITE);
	    contentPane.add(diagrammPanel);
		
		JLabel lb‹berschrift = new JLabel("Finanzrechner");
		lb‹berschrift.setForeground(Color.WHITE);
		lb‹berschrift.setBackground(hellblau);
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
		tfBetrag.setBounds(82, 119, 555, 28);
		contentPane.add(tfBetrag);
		tfBetrag.setColumns(10);
		
		JLabel lbEuro = new JLabel("\u20AC");
		lbEuro.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbEuro.setBounds(649, 119, 22, 28);
		contentPane.add(lbEuro);
		
		tfZinssatz = new JTextField();
		tfZinssatz.setFont(new Font("SansSerif", Font.PLAIN, 15));
		tfZinssatz.setText("2.5");
		tfZinssatz.setBounds(82, 210, 555, 28);
		contentPane.add(tfZinssatz);
		tfZinssatz.setColumns(10);
		
		JLabel lbProzent = new JLabel("%");
		lbProzent.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbProzent.setBounds(649, 210, 22, 28);
		contentPane.add(lbProzent);
		
		tfLaufzeit = new JTextField();
		tfLaufzeit.setFont(new Font("SansSerif", Font.PLAIN, 15));
		tfLaufzeit.setText("6");
		tfLaufzeit.setBounds(82, 305, 539, 28);
		contentPane.add(tfLaufzeit);
		tfLaufzeit.setColumns(10);
		
		JLabel lbJahre = new JLabel("Jahre");
		lbJahre.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbJahre.setBounds(631, 305, 40, 28);
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
		
		cbZinsart = new JComboBox();
		cbZinsart.setForeground(Color.WHITE);
		cbZinsart.setBackground(hellblau);
		cbZinsart.setModel(new DefaultComboBoxModel(new String[] {"Zinsberechnung", "Zinseszinsberechnung"}));
		cbZinsart.setFont(new Font("SansSerif", Font.PLAIN, 20));
		cbZinsart.setToolTipText("");
		cbZinsart.setBounds(152, 344, 519, 60);
		contentPane.add(cbZinsart);
		
		JButton btBerechnen = new JButton("Berechnen");
		btBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Zinsrechner = new Zinsrechner();
				leseBetrag();
				leseZinssatz();
				leseLaufzeit();
				leseZinsart();
				//Verarbeitung
				VerarbeiteZinsart();
				//Ausgabe
				schreibeEndkapital();
				diagrammPanel.setJaehrlicheZahlungen(Zinsrechner.getJaehrlicheZahlungen());
			}
		});
		btBerechnen.setBounds(82, 415, 589, 46);
		contentPane.add(btBerechnen);
		
		taEndkapital = new JTextArea();
		taEndkapital.setFont(new Font("SansSerif", Font.PLAIN, 18));
		taEndkapital.setBackground(SystemColor.menu);
		taEndkapital.setBounds(416, 518, 255, 132);
		contentPane.add(taEndkapital);
	}
	
	
	public Zinsrechner getZinsrechner() {
		return Zinsrechner;
	}

	public void setZinsrechner(Zinsrechner zinsrechner) {
		Zinsrechner = zinsrechner;
	}



			//Hilfsmethoden
			/*Deklariere und Implementiere die Lesemethoden*/
			public void leseBetrag(){
			double betrag = Double.valueOf(tfBetrag.getText());
			Zinsrechner.setBetrag(betrag);	
			
			}
			public void leseZinssatz() {
			double zinssatz = Double.valueOf(tfZinssatz.getText());
			zinssatz = zinssatz / 100;
			Zinsrechner.setZinssatz(zinssatz);
			}
			public void leseLaufzeit() {
			int laufzeit = Integer.valueOf(tfLaufzeit.getText());
			Zinsrechner.setLaufzeit(laufzeit);
			}
			public void leseZinsart() {
				this.selectedOption = (String) cbZinsart.getSelectedItem();
				
			}
			
			public void VerarbeiteZinsart() {
				if (this.selectedOption == "Zinsberechnung") {
					Zinsrechner.berechneZinssatzlinear();
				}else {
					Zinsrechner.berechneZinssatzexponentiell();
				}
			}
		//SchreibeMethoden
			public void schreibeEndkapital(){
			String ergebnis = Zinsrechner.schreibeZins();
			taEndkapital.setText(ergebnis);
		}
		
			
}
