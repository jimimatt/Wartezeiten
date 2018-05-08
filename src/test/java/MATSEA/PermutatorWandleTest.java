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
	
	@Parameterized.Parameters(name= "{index}: baseThreeInputs({0})={1}")
	public static Iterable<Object[]> baseThreeInputs() {
		return Arrays.asList(new Object[][]
				{
					{-1, "aaaa"},
					{0, "aaaa"},
					{1, "aaab"},
					{79, "cccb"},
					{80, "cccc"},
					{81, "aaaa"}
				}
		);
	}
	
	@Test
	public void testWandle() {
		permutator.count = input;
		if(input > 80 || input < 0) {
			try {
				permutator.wandle();
				fail("Exception not thrown");
			} catch (IllegalArgumentException i) {
				assertTrue(true);
			} catch (Exception e) {
				assertTrue(e instanceof IndexOutOfBoundsException);
			}
		} else {
			assertEquals(expected, permutator.wandle());
		}
	}

}
