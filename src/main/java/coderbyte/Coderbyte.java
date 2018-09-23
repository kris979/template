package coderbyte;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coderbyte {

	public Coderbyte() {
	}

	public String longestWord(String sen) {
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
	
	public String reverse(String input) {
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
	
	public void simpleAdding() {
		
	}
}
