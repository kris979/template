package coderbyte;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class CoderbyteTest {

	private Coderbyte cb = new Coderbyte();

	@Test
	public void testLongestWord() {
		assertThat(cb.longestWord("fun&!! time"), is("time"));
	}

	@Test
	public void reverseArray() {
		assertThat(cb.reverse("Coderbyte"), is("etybredoC"));
	}

	@Test
	public void simpleAdding() {
		assertThat(cb.simpleAdding(12), is(78));
		assertThat(cb.simpleAdding(140), is(9870));
	}
	
	@Test
	public void convertStringTest() {
		assertThat(cb.letterChanges("hello*3"), is("Ifmmp*3"));
		assertThat(cb.letterChanges("fun times!"), is("gvO Ujnft!"));
	}
}
