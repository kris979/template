package coderbyte;

import java.util.HashMap;
import java.util.Map;
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
		int end = charArray.length - 1;
		while (start < end) {
			char tmp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = tmp;
			start += 1;
			end -= 1;
		}
		return new String(charArray);
	}

	public int simpleAdding(int num) {
		if (num == 0) {
			return 0;
		}
		return num + simpleAdding(--num);
	}

	public String letterChanges(String str) {
		StringBuilder result = new StringBuilder();
		char[] strChars = str.toLowerCase().toCharArray();
		char[] replacements = { 'b', 'c', 'd', 'E', 'f', 'g', 'h', 'I', 'j', 'k', 'l', 'm', 'n', 'O', 'p', 'q', 'r',
				's', 't', 'U', 'v', 'w', 'x', 'y', 'z', 'A' };
		for (int i = 0; i < str.length(); i++) {
			result.append(strChars[i] >= 'a' && strChars[i] <= 'z' ? replacements[strChars[i] - 97] : strChars[i]);
		}
		return result.toString();
	}

	public String capitalize(String input) {
		StringBuilder sb = new StringBuilder();
		String[] split = input.split(" ");
		for (String string : split) {
			char charAt = string.charAt(0);
			Character.toUpperCase(charAt);
			sb.append(Character.toUpperCase(charAt)).append(string.substring(1)).append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}


//	Input:"f++d+"
	public String simpleSymbols(String input) {
		char[] array = input.toCharArray();
		for (int i = 0; i < array.length; i++) {
			char left = array[i];
			char middle;
			if (i+1 >= array.length) {
				middle = '!';
			} else {
				middle = array[i+1];
			}
			char right;
			if (i+2 >= array.length) {
				right = '!';
			} else {
				right = array[i+2];
			}
			
			if (Character.isLetter(middle) && (left != '+' || right != '+')) {
				return "false";
			}
			
		}
		return "true";
	}
}
