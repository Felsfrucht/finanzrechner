package Finanzrechner;

import java.awt.Color;

import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.lang.reflect.Array;

public class Kreditrechner extends Rechner {
    // Methoden für Kreditrechnung


    // Fälligkeitsdarlehen
    public void berechneFaelligkeitsdarlehen() {
        double zinsbetrag = this.getBetrag() * this.getZinssatz();
        this.setZinsbetrag(zinsbetrag);
        double gesamtzinsen = this.getZinsbetrag() * this.getLaufzeit();
        this.setGesamtzinsen(gesamtzinsen);
        double endbetrag = this.getBetrag() + this.getGesamtzinsen();
        this.setEndbetrag(endbetrag);
        double[] jaehrlicheZahlungen = new double[(int) this.getLaufzeit()];
        for (int jahr = 0; jahr < this.getLaufzeit(); jahr++) {
            jaehrlicheZahlungen[jahr] = Math.round(this.getBetrag() * this.getZinssatz() * 100.0) / 100.0;
        }
        
       
        if (this.getLaufzeit() <= 0) {
            System.out.println("Ungültiger Wert für Laufzeit: " + this.getLaufzeit());
            return;
        }
        jaehrlicheZahlungen[jaehrlicheZahlungen.length - 1] += this.getBetrag();
       
        this.setJaehrlicheZahlungen(jaehrlicheZahlungen);
        this.setAnnuitaet(0);
    }

    // Ratendarlehen
    public void berechneRatendarlehen() {
        double gesamtzinsen = this.getZinssatz() * ((this.getBetrag() * (this.getLaufzeit() + 1)) / 2);
        this.setGesamtzinsen(gesamtzinsen);
        this.setEndbetrag(this.getBetrag() + this.getGesamtzinsen());
        this.setAnnuitaet(0);
    }

    public void berechneRatendarlehenJaerlicheZahlungen() {
        this.setJaehrlicheZahlungen(berechneRatendarlehenJaerlicheZahlungen(this.getBetrag(), (int) this.getLaufzeit(), this.getZinssatz()));
    }

    public double[] berechneRatendarlehenJaerlicheZahlungen(double betrag, int laufzeit, double zinssatz) {
        double jaehrlicheTilgung = betrag / laufzeit;
        double restschuld = betrag;
        double[] zahlungen = new double[laufzeit];

        for (int jahr = 0; jahr < laufzeit; jahr++) {
            double jaehrlicheZinsen = restschuld * zinssatz;
            zahlungen[jahr] = jaehrlicheTilgung + jaehrlicheZinsen;
            restschuld -= jaehrlicheTilgung;
        }
        return zahlungen;
    }

    // Annuitätendarlehen
    public void berechneAnnuitaetenfaktor() {
        this.setAnnuitaet((this.getZinssatz() * Math.pow(1 + this.getZinssatz(), this.getLaufzeit())) /
                (Math.pow(1 + this.getZinssatz(), this.getLaufzeit()) - 1));
    }

    public void berechneAnnuitaetendarlehen() {
        this.berechneAnnuitaetenfaktor();
        double[] jaehrlicheZahlungen = new double[ (int) this.getLaufzeit()];
        for (int jahr = 0; jahr < this.getLaufzeit(); jahr++) {
            jaehrlicheZahlungen[jahr] = Math.round(this.getBetrag() * this.getAnnuitaet() * 100.0) / 100.0;
        }
        this.setJaehrlicheZahlungen(jaehrlicheZahlungen);
        this.setEndbetrag(this.getBetrag() * this.getAnnuitaet() * this.getLaufzeit());
        this.berechneGesamtzinsen();
    }

    private void berechneGesamtzinsen() {
        this.setGesamtzinsen(this.getEndbetrag() - this.getBetrag());
    }
    
  
    
	
}
