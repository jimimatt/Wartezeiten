package MATSEA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	
	private AusgabeInDatei anzeige;
	private ArrayList<Zeitmodell> modelle = new ArrayList<Zeitmodell>();
	
	public Controller(String eingabedatei, AusgabeInDatei anzeige) throws FileNotFoundException, IOException {
		this.anzeige = anzeige;
		BufferedReader fileReader = new BufferedReader(new FileReader(eingabedatei));
		Scanner sc = null;
		String line, titel;
		try {
			while((line = fileReader.readLine()) != null)
			{
				// System.out.println(line);
				if(line.equals(""))
					continue;
				titel = line;
				sc = new Scanner(fileReader.readLine());
				modelle.add(new Zeitmodell(titel, sc.nextInt(), sc.nextInt(), sc.nextInt()));
				sc.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		fileReader.close();
	}
	
	public void evaluate() {
		for(Zeitmodell zm : modelle) {
			anzeige.writeModell(zm);
		}
		anzeige.close();
	}

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("Falscher Programmaufruf!\nBitte rufen Sie das Programm mit 2 Parametern auf:");
			System.out.println("1. Parameter: Name der Eingabedatei");
			System.out.println("2. Parameter: Name der Ausgabedatei");
		} else {
			System.out.println("Eingabedatei: " + args[0]);
			System.out.println("Ausgabedatei: " + args[1]);
			Controller ctrl;
			try {
				ctrl = new Controller(args[0], new AusgabeInDatei(args[1]));
				ctrl.evaluate();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException f) {
				f.printStackTrace();
			}
		}
		System.out.println("Programmende");
	}

}
