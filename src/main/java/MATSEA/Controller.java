package MATSEA;

import java.util.ArrayList;

public class Controller {
	
	private View anzeige;
	private ArrayList<Zeitmodell> modelle;
	
	public Controller(String eingabedatei, View anzeige) {
		this.anzeige = anzeige;
	}
	
	public void evaluate() {
		
	}

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("Falscher Programmaufruf!\nBitte rufen Sie das Programm mit 2 Parametern auf:");
			System.out.println("1. Parameter: Name der Eingabedatei");
			System.out.println("2. Parameter: Name der Ausgabedatei");
		} else {
			Controller ctrl = new Controller(args[0], new View(args[1]));
			ctrl.evaluate();
		}

	}

}
