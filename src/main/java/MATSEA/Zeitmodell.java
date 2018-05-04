package MATSEA;

public class Zeitmodell {
	
	private Permutator generator;
	
	private String titel;
	
	private int morgens;
	private int vormittags;
	private int mittags;
	
	private int patientenAnzahl;
	private int[] termine;
	private int[] dauer;
	private int anzahlPermutationen;
	
	private long wzKumulativ = 0; /* wird in berechneModell() durch die Anzahl der Patienten geteilt */
	private long mwzKumulativ = 0;
	private int leerKumulativ = 0;
	
	private double wz = 0.;
	private double mwz = 0.;
	private double leer = 0.;
	private double bs = 0.;
	
	public Zeitmodell(String titel, int morgens, int vormittags, int mittags) {
		this.titel = titel;
		this.morgens = morgens;
		this.vormittags = vormittags;
		this.mittags = mittags;
		this.patientenAnzahl = Zeitmodell.bestimmePatientenAnzahl(morgens, vormittags, mittags);
		this.anzahlPermutationen = (int) Math.pow(3, patientenAnzahl);
		this.generator = new Permutator(this.patientenAnzahl);
		erstelleTermine();
		berechneModell();
	}
	
	public static int bestimmePatientenAnzahl(int morgens, int vormittags, int mittags) {
		int nMorgens = 0, nVormittags = 0, nMittags = 0;
		int buff = 0;
		nMorgens = new Double(Math.ceil(60./morgens)).intValue();
		buff = nMorgens*morgens - 60;
		nVormittags += Math.ceil(((double)(120 - buff))/vormittags);
		buff = new Double(Math.ceil(((double)(120 - buff))/vormittags)).intValue()*vormittags - 120 + buff;
		nMittags += new Double(Math.ceil(((double)(60 - buff))/mittags)).intValue();
		return nMorgens + nVormittags + nMittags;
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
		String tWort = generator.get();
		int[] dauer = new int[patientenAnzahl];
		for(int i = 0; i < patientenAnzahl; ++i) {
			switch(tWort.charAt(i)) {
				case 'a':	dauer[i] = 15; break;
				case 'b':	dauer[i] = 20; break;
				case 'c':	dauer[i] = 30; break;
				default:	System.out.println("Fehler in 'erstelleDauer()', switch-Block");
			}
		}
		this.dauer = dauer;
	}
	
	private void werteAus() {
		int überhang = 0;
		int mwz = 0, wz = 0, leer = 0;
		for(int i = 0; i < patientenAnzahl - 1; ++i) {
			überhang += termine[i] + dauer[i] - termine[i+1];
			if(überhang < 0) {
				leer -= überhang;
				überhang = 0;
			} else {
				wz += überhang;
				if(überhang > mwz) {
					mwz = überhang;
				}
			}
		}
		überhang += termine[patientenAnzahl-1] + dauer[patientenAnzahl-1] - 240;
		if(überhang < 0) {
			leer -= überhang;
		}
		wzKumulativ += wz; /* wird in berechneModell() durch die Anzahl der Patienten geteilt */
		mwzKumulativ += mwz;
		leerKumulativ += leer;
	}
	
	private void berechneModell() {
		wzKumulativ = 0;
		mwzKumulativ = 0;
		leerKumulativ = 0;
		for(int i = 0; i < anzahlPermutationen - 1; ++i) {
			erstelleDauer();
			werteAus();
		}
		wz = (double) wzKumulativ / patientenAnzahl / anzahlPermutationen;
		mwz = (double) mwzKumulativ / anzahlPermutationen;
		leer = (double) leerKumulativ / anzahlPermutationen;
		bs = wz + 0.1*mwz + 5.*leer;
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

	public String getTitel() {
		return titel;
	}
	
	public String getTermine() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < patientenAnzahl; ++i) {
			sb.append(String.format("%02d:%02d ", termine[i] / 60 + 8, termine[i] % 60));
		}
		sb.deleteCharAt(sb.length()-1); /* Leerzeichen am Ende entfernen */
		return sb.toString();
	}
	
	public int getAnzahlPermutationen() {
		return anzahlPermutationen;
	}

}
