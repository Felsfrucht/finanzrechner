package Finanzrechner;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Rechner
{	//Variable
	private double betrag;
	private double zinssatz;
	private Integer laufzeit;
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
	public Integer getLaufzeit() {
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
	public void setLaufzeit(Integer pLaufzeit) {
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
	

	public String schreibeKredit1und2undZins() {
		return "|Endbetrag:     " + String.format("%.2f", this.endbetrag) + " € "
	    		+ "\n|Gesamtzinsen: " + String.format("%.2f", this.gesamtzinsen) + " €";
	}

	public String schreibeAnuitaet() {
	    return "|Endbetrag:     " + String.format("%.2f", this.endbetrag) + " € "
	    	    + "\n|Gesamtzinsen: " + String.format("%.2f", this.gesamtzinsen) + " €"
	          	+ "\n|Annuität:                 " + String.format("%.2f", this.annuitaet);
	}
	
	
	
	//Fehlercodes
	public String fehlercode_1(){
		return "Fehler: Der Betrag muss größer als 0 sein.\n\n Betrag wird auf 120000.00 gesetzt";
	}
	public String fehlercode_2(){
		return "Fehler: Der Zinssatz muss größer als 0 sein.\n\n Zinssatz wird auf 4.5% gesetzt";
	}
	public String fehlercode_3(){
		return "Fehler: Die Laufzeit muss größer als 0 sein.\n\n Laufzeit wird auf 7 Jahre gesetzt";
	}
	public String fehlercode_4(){
		return "Fehler: Bitte geben Sie eine gültige Zahl ein.\n\n Fehlerhafte Zahl wird auf einen Standartwert zurück gesetzt";
	}

	@Override
	public String toString() {
		return  "Eingabe:\n"+
		           "| Betrag = " + betrag + "\n" +
		           "| Zinssatz = " + zinssatz + "\n" +
		           "| Laufzeit = " + laufzeit;
	}
	
	//ToString Methode
	
}

