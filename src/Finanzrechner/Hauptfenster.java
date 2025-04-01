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
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
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
        setBounds(100, 100, 331, 331);
        Startseite = new JPanel();
        Startseite.setBackground(Color.DARK_GRAY);
        setContentPane(Startseite);
        Startseite.setLayout(new BorderLayout(0, 0));
        
        JLabel lblFinanzrechner = new JLabel("Finanzrechner");
        lblFinanzrechner.setForeground(Color.WHITE);
        lblFinanzrechner.setFont(new Font("Arial", Font.PLAIN, 46));
        Startseite.add(lblFinanzrechner, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        panel.setForeground(Color.WHITE);
        panel.setBackground(Color.DARK_GRAY);
        Startseite.add(panel, BorderLayout.CENTER);
        
        JButton btKreditrechner = new JButton("Kreditrechner");
        btKreditrechner.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Kreditview Kredit = new Kreditview();
        	}
        });
        btKreditrechner.setForeground(Color.WHITE);
        btKreditrechner.setBackground(new Color(0, 153, 204));
        btKreditrechner.setFont(new Font("Arial", Font.PLAIN, 33));
        btKreditrechner.setFocusPainted(false);
        panel.add(btKreditrechner);
        
        JButton btZinsrechner = new JButton("Zinsrechner");
        btZinsrechner.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Zinsview Zinsen = new Zinsview();
        		Zinsen.setVisible(true);
        	}
        });
        btZinsrechner.setForeground(Color.WHITE);
        btZinsrechner.setBackground(new Color(0, 153, 204));
        btZinsrechner.setFont(new Font("Arial", Font.PLAIN, 33));
        panel.add(btZinsrechner);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.DARK_GRAY);
        Startseite.add(panel_1, BorderLayout.SOUTH);
        
        JButton btSchliessen = new JButton("Schlie\u00DFen");
        btSchliessen.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        btSchliessen.setForeground(SystemColor.text);
        btSchliessen.setBackground(Color.DARK_GRAY);
        btSchliessen.setFont(new Font("Arial", Font.PLAIN, 28));
        panel_1.add(btSchliessen);
    }
	
}


