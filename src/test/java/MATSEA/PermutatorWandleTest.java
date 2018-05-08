package MATSEA;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class PermutatorWandleTest {
	
	private Permutator permutator;
	private int input;
	private String expected;
	
	@Before
	public void tearUp() {
		this.permutator = new Permutator(4);
	}
	
	public PermutatorWandleTest(final int inputNumber, final String expectedResult) {
		this.input = inputNumber;
		this.expected = expectedResult;
	}
	
	@Parameterized.Parameters(name= "index baseThreeInputs (0) => value 1")
	public static Iterable<Object[]> baseThreeInputs() {
		return Arrays.asList(new Object[][]
				{
					{0, "aaaa"},
					{1, "aaab"},
					{79, "cccb"},
					{80, "cccc"}
				}
		);
	}
	
	@Test
	public void testWandle() {
		permutator.count = input;
		assertEquals(expected, permutator.wandle());
	}

}
