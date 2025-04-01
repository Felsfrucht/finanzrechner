package Finanzrechner;

public class Zinsrechner extends Rechner{
	//Methoden für Zinsberechnen
	
		//Zinsberechnung linear
		public void berechneZinssatzlinear() {
			double endbetrag = this.getBetrag() * (1 + this.getZinssatz() * this.getLaufzeit());
			this.setEndbetrag(endbetrag);
			this.setAnnuitaet(0);
			berechnegessamtzinsen();
			// Jährliche Zahlung: Zinsen + Tilgung
		    double zinsenJahr = this.getBetrag() * this.getZinssatz();
		    double tilgungJahr = (endbetrag - this.getBetrag()) / this.getLaufzeit();
		    double jahreszahlung = zinsenJahr + tilgungJahr;
		    
		    double[] jaehrlicheZahlungen = new double[ (int) this.getLaufzeit()];
		    for (int i = 0; i < this.getLaufzeit(); i++) {
		    	jaehrlicheZahlungen[i] = jahreszahlung;
		    }
		}
		
		//Zinsberechnung exponentiell --> Zinseszins
		public void berechneZinssatzexponentiell() {
			double endbetrag = this.getBetrag() * Math.pow(1 + this.getZinssatz(), this.getLaufzeit());
			this.setEndbetrag(endbetrag);
			this.setAnnuitaet(0);
			this.setJaehrlicheZahlungen(null);
			berechnegessamtzinsen();
		}
}
