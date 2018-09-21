package coderbyte;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class CoderbyteTest {

	public static String longestWord(String sen) {
		Pattern p = Pattern.compile("[a-zA-Z]+");
		Matcher m = p.matcher(sen);
		String longestWord = "";
		while (m.find()) {
			if (m.group().length() > longestWord.length()) {
				longestWord = m.group();
			}
		}
		return longestWord;
	}
	
	public static String reverse(String input) {
		char[] charArray = input.toCharArray();
		int start = 0;
		int end = charArray.length-1;
		while (start < end) {
			char tmp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = tmp;
			start +=1;
			end-=1;
		}
		return new String(charArray);
	}

	@Test
	public void testLongestWord() {
		assertThat(longestWord("fun&!! time"), is("time"));
	}
	
	@Test
	public void reverseArray() {
		assertThat(reverse("Coderbyte"), is("etybredoC"));
	}

}
