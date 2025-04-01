package Finanzrechner;

public class Zinsrechner extends Rechner{
	//Methoden für Zinsberechnen
	// Zinsberechnung exponentiell (Zinseszins)
	public void berechneZinssatzexponentiell() {
	    int laufzeit = (int) this.getLaufzeit();
	    double[] jaehrlicheZahlungen = new double[laufzeit];
	    double betrag = this.getBetrag();
	    double zinssatz = this.getZinssatz();

	    // Berechnung des Endkapitals mit jährlicher Speicherung
	    for (int jahr = 0; jahr < laufzeit; jahr++) {
	        betrag *= (1 + zinssatz);  // Zinseszins-Berechnung
	        jaehrlicheZahlungen[jahr] = betrag; // Speichern des Kapitals nach jedem Jahr
	    }

	    // Setze den Endbetrag und die jährlichen Zahlungen
	    this.setEndbetrag(betrag);
	    this.setAnnuitaet(0);
	    this.setJaehrlicheZahlungen(jaehrlicheZahlungen);
	    berechnegessamtzinsen(); 
	}

	// Zinsberechnung linear
	public void berechneZinssatzlinear() {
	    double betrag = this.getBetrag();
	    double zinssatz = this.getZinssatz();
	    int laufzeit = (int) this.getLaufzeit();
	    // Endbetrag berechnen
	    double endbetrag = betrag * (1 + zinssatz * laufzeit);
	    this.setEndbetrag(endbetrag);
	    this.setAnnuitaet(0);
	    berechnegessamtzinsen();

	    // Array für jährliche Zahlungen erstellen
	    double[] jaehrlicheZahlungen = new double[laufzeit];
	    double zinsenJahr = betrag * zinssatz;
	    for (int jahr = 0; jahr < laufzeit; jahr++) {    
	        betrag = betrag + zinsenJahr; // Betrag wächst jedes Jahr durch die Zinsen
	        jaehrlicheZahlungen[jahr] = betrag;
	    }
	    this.setJaehrlicheZahlungen(jaehrlicheZahlungen);
	    
	    
	}

	

}
