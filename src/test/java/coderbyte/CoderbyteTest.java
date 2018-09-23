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

}
