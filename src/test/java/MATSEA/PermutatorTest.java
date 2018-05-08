package MATSEA;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class PermutatorTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testPermutator() {
		thrown.expect(IllegalArgumentException.class);
		@SuppressWarnings("unused")
		Permutator permutator = new Permutator(-1);
	}

}
