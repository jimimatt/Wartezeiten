package MATSEA;

public class Zeitmodell {
	
	private String titel;
	
	private int morgens;
	private int vormittags;
	private int mittags;
	
	private int patientenAnzahl;
	private int[] termine;
	private int[] dauer;
	
	private double wz = 0.;
	private double mwz = 0.;
	private double leer = 0.;
	private double bs = 0.;
	
	public Zeitmodell(String titel, int morgens, int vormittags, int mittags) {
		this.titel = titel;
		this.morgens = morgens;
		this.vormittags = vormittags;
		this.mittags = mittags;
		bestimmePatientenAnzahl();
		erstelleTermine();
	}
	
	private void bestimmePatientenAnzahl( ) {
		int n = 0;
		int buff = 0;
		n = new Double(Math.ceil(60./morgens)).intValue();
		buff = n*morgens - 60;
		n += Math.ceil(((double)(120 - buff))/vormittags);
		buff = new Double(Math.ceil(((double)(120 - buff))/vormittags)).intValue() - 120;
		n += new Double(Math.ceil(((double)(60 - buff))/mittags)).intValue();
		this.patientenAnzahl = n;
	}
	
	private void erstelleTermine() {
		int zeit = 0;
		this.termine = new int[patientenAnzahl];
		for(int i = 0; i < patientenAnzahl; ++i) {
			termine[i] = zeit;
			if(zeit < 60) {
				zeit += morgens;
			} else {
				if(zeit < 180) {
					zeit += vormittags;
				} else {
					if(zeit < 240) {
						zeit += mittags;
					}
				}
			}
			
		}
	}
	
	private void erstelleDauer() {
		
	}
	
	private void werteAus() {
		
	}
	
	private void berechneModell() {
		
	}

	public double getWz() {
		return wz;
	}

	public double getMwz() {
		return mwz;
	}

	public double getLeer() {
		return leer;
	}

	public double getBs() {
		return bs;
	}
	
}
