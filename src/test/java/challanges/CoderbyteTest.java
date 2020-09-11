package challanges;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import challanges.Coderbyte;
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
	
	@Test
	public void capitalizeFirstLetterTest() {
		assertThat(cb.capitalize("hello world"), is("Hello World"));
		assertThat(cb.capitalize("i ran there"), is("I Ran There"));
	}

//	TODO:finish it
//	@Test
//	public void simpleSymbolsTest() {
//		assertThat(cb.simpleSymbols("f++d+"), is("false"));
//		assertThat(cb.simpleSymbols("+d+=3=+s+"), is("true"));
//		assertThat(cb.simpleSymbols("+f++d+"), is("true"));
//		assertThat(cb.simpleSymbols("+f++"), is("false"));
//		assertThat(cb.simpleSymbols("+"), is("false"));
//		assertThat(cb.simpleSymbols("a"), is("false"));
////		assertThat(cb.simpleSymbols("+z+z+z+"), is("true"));
//		assertThat(cb.simpleSymbols("+a++"), is("true"));
//		assertThat(cb.simpleSymbols("+z+z+==+a+"), is("true"));
//	}
}
