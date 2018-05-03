package MATSEA;

public class Permutator {
	
	private int count = 0;
	private int n;
	
	public Permutator(int n) {
		this.n = n;
	}
	
	public String get() {
		String erg = wandle();
		++count;
		return erg;
	}
	
	private String wandle() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; ++i) {
			sb.append('a');
		}
		int zahl = this.count; 
		int rest, i = 0;
		while(zahl > 0) {
			rest = zahl % 3;
			zahl = zahl / 3;
			switch(rest) {
				case 2:	sb.setCharAt(i, 'c');
						break;
				case 1: sb.setCharAt(i, 'b');
						break;
				case 0: break;
				default: 
					System.out.println("Fehler in 'wandle(), switch-Block");
			}
			++i;
		}
		return sb.toString();
	}
	
}
