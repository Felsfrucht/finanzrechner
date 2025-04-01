package Finanzrechner;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import java.awt.Graphics;
import java.awt.Graphics2D;
public class Hauptfenster extends JFrame
{
	private JPanel Startseite;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Hauptfenster frame = new Hauptfenster();
					frame.setVisible(true);
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
	
	public Hauptfenster()
	{
		setTitle("Finanzrechner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 700);
        Startseite = new JPanel();
        Startseite.setBackground(SystemColor.control);
        Startseite.setLayout(null);
        setContentPane(Startseite);
        
        JLabel lb‹berschrift = new JLabel("Finanzrechner");
		lb‹berschrift.setForeground(Color.WHITE);
		lb‹berschrift.setBackground(SystemColor.textHighlight);
		lb‹berschrift.setOpaque(true);
		lb‹berschrift.setFont(new Font("Impact", Font.PLAIN, 22));
		lb‹berschrift.setBounds(10, 11, 711, 48);
		Startseite.add(lb‹berschrift);

        // Button erstellen
        
        JButton btZinsrechner = new JButton("Zinsrechner");
        btZinsrechner.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Zinsview Zinsen = new Zinsview();
        		Zinsen.setVisible(true);
        	}
        });
        btZinsrechner.setBounds(129, 313, 143, 44);
        Startseite.add(btZinsrechner);
        
        JButton btKreditrechner = new JButton("Kreditrechner");
        btKreditrechner.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Kreditview Kredit = new Kreditview();
        		
        		
        	}
        });
        btKreditrechner.setBounds(452, 313, 143, 44);
        Startseite.add(btKreditrechner);  
    }
	
}


