package Finanzrechner;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;

public class Rechner
{	//Variable
	private double betrag;
	private double zinssatz;
	private double laufzeit;
	private double endbetrag;
	private double gesamtzinsen;
	private double tilgung;
	private double zinsbetrag;
	private double annuitaet;
	
	//Array
	public double[] jaehrlicheZahlungen;
	

	//Konstruktor
	public Rechner() {
		
	}
	
	//Getter Methoden
	public double getBetrag() {
		return this.betrag;
	}
	public double getZinssatz() {
		return this.zinssatz;
	}
	public double getLaufzeit() {
		return this.laufzeit;
	}
	public double getEndbetrag() {
		return this.endbetrag;
	}
	public double getGesamtzinsen() {
		return this.gesamtzinsen;
	}
	public double getTilgung() {
		return this.tilgung;
	}
	public double getZinsbetrag() {
		return this.zinsbetrag;
	}
	public double getAnnuitaet() {
		return this.annuitaet;
	}
	public double[]getJaehrlicheZahlungen(){
		return this.jaehrlicheZahlungen;
	}
		
	//Setter Methoden
	public void setBetrag(double pBetrag) {
		this.betrag = pBetrag;
	}
	public void setZinssatz(double pZinssatz) {
		this.zinssatz = pZinssatz;
	}
	public void setLaufzeit(double pLaufzeit) {
		this.laufzeit = pLaufzeit;
	}
	public void setEndbetrag(double pEndbetrag) {
		this.endbetrag = pEndbetrag;
	}
	public void setGesamtzinsen(double pGesamtzinsen) {
		this.gesamtzinsen = pGesamtzinsen;
	}
	public void setTilgung(double pTilgung) {
		this.tilgung = pTilgung;
	}
	public void setZinsbetrag(double pZinsbetrag) {
		this.zinsbetrag = pZinsbetrag;
	}
	public void setAnnuitaet(double pAnnuitaet) {
		this.annuitaet = pAnnuitaet;
	}
	public void setJaehrlicheZahlungen(double[] pJaerlicheZahlung){
		this.jaehrlicheZahlungen= pJaerlicheZahlung;
	}
	
	
	
	
	
	//Methoden für Kreditrechnung und Zinsberechnung
	public void berechnegessamtzinsen() {
		this.gesamtzinsen =  this.endbetrag - this.betrag;
	}
	
	// Schreibmethoden
	public String schreibeZins() {
	    return String.format(
	        "Endbetrag: %.2f €\nGesamtzinsen: %.2f €", 
	        this.endbetrag, 
	        this.gesamtzinsen
	    );
	   
	}

	public String schreibeKredit1und2() {
	    return String.format(
	        "Endbetrag: %.2f €\nGesamtzinsen: %.2f €", 
	        this.endbetrag, 
	        this.gesamtzinsen
	    );
	}

	public String schreibeAnuitaet() {
	    return String.format(
	        "Endbetrag: %.2f €\nGesamtzinsen: %.2f €\nAnnuität: %.2f ", 
	        this.endbetrag, 
	        this.gesamtzinsen, 
	        this.annuitaet
	    );
	}

	
	
	//ToString Methode
	public String toString() {
		return "";
	}
}

