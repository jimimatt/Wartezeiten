package MATSEA;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class AusgabeInDatei {

	private PrintWriter ausgabe;

	public AusgabeInDatei(String ausgabedatei) throws FileNotFoundException {
		ausgabe = new PrintWriter(new File(ausgabedatei));
	}

	public boolean writeModell(Zeitmodell zm) {
		ausgabe.println(zm.getTitel());
		ausgabe.println("Terminverteilung bei dieser Strategie:");
		ausgabe.println(zm.getTermine());
		ausgabe.println();
		ausgabe.println(String.format(
				"Bei %d Kombinationen der Behandlungsdauern ergeben sich folgende Zeiten:",
				zm.getAnzahlPermutationen()
				));
		ausgabe.println(String.format(
				" durschnittliche mittlere Wartezeit  WZ = %.4f",
				zm.getWz()
				));
		ausgabe.println(String.format(
				" durschnittliche maximale Wartezeit MWZ = %.4f",
				zm.getMwz()
				));
		ausgabe.println(String.format(
				" durschnittliche Leerlaufzeit        LZ = %.4f",
				zm.getLeer()
				));
		ausgabe.println(String.format(
				" Gesamtbewertung der Strategie       BS = %.4f",
				zm.getBs()
				));
		ausgabe.println();
		return true;
	}
	
	public void close() {
		ausgabe.close();
	}

}
