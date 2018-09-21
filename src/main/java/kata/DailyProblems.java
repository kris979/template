package kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DailyProblems {

	public DailyProblems() {
	}

	char firstNonRepeatingChar(String input) {
		LinkedHashMap<Character, Integer> counterMap = new LinkedHashMap<>();
		
		char[] charArray = input.toCharArray();
		for (char c : charArray) {
			Integer counter = counterMap.get(c);
			if (counter != null) {
				counterMap.put(c, ++counter);
			} else {
				counterMap.put(c,1);
			}
		}
		
		Set<Entry<Character, Integer>> counters = counterMap.entrySet();
		for (Entry<Character, Integer> entry : counters) {
			Integer value = entry.getValue();
			if (value < 2) {
				return entry.getKey();
			}
		}
		
		return 0;
	}

	int numberOfDistinctPairs(int[] input, int k) {
		Set<Integer> reminders = new HashSet<>();
		
		int counter = 0;
		for (Integer integer : input) {
			int reminder = k - integer;
			if (reminders.contains(integer)) {
				counter+=1;
			} else {
				reminders.add(reminder);
			}
		}
		return counter;
	}
	
	void substraings(String input) {
		Map<Character, String> substrings = new HashMap<>();
		char[] charArray = input.toCharArray();
		Character previous = charArray[0];
		int counter = 0;
		int index = 0;
		for (int i = 0; i < charArray.length; i++) {
			Character c = charArray[i]; 
			if (c.equals(previous)) {
				counter+=1;
			} else {
				String largestSoFar = substrings.get(previous);
				if (largestSoFar == null || largestSoFar.length() < counter) {
					substrings.put(previous, new String(charArray,index,counter));
					counter = 1;
					index = i;
				}
			}
			previous=c;
		}
		String largestSoFar = substrings.get(previous);
		if (largestSoFar == null || largestSoFar.length() < counter) {
			substrings.put(previous, new String(charArray,index,counter));
		}
		System.out.println(substrings);
	}
	
	int numWays(int input) {
		if( input == 0 || input == 1) {
			return 1;
		} else if (input == 2) {
			int output = numWays(input-1) + numWays(input-2);
			return  output;
		}
		int output = numWays(input-1) + numWays(input-2) + numWays(input-3);
		return output;
	}
	
	String compress(String input) {
		if (input == null || input.equals("")) {
			return input;
		}
		
		StringBuilder s = new StringBuilder();
		Character previous = input.toCharArray()[0];
		s.append(previous);
		int counter = 0;
		for (Character c  : input.toCharArray()) {
			if (c.equals(previous)) {
				counter+=1;
			} else {
				s.append(previous);
				s.append(counter);
				counter = 1;
			}
			previous=c;
		}
		s.append(previous);
		s.append(counter);
		return s.toString();
	}
	
	int[] sumOfFractions(int[] a, int[] b) {
		if (a.length != 2 && a.length != 2) {
			throw new IllegalArgumentException();
		}
		int[] result = new int[2];
		int commonDenominator = leastCommonDenominator(a[1],b[1]);
		int numeratorMultipA = commonDenominator/a[1];
		int numeratorMultipB = commonDenominator/b[1];
		int lA = a[0]*numeratorMultipA;
		int lB = b[0]*numeratorMultipB;
		result[0] = lA + lB;
		result[1] = commonDenominator;
		
		return result;
	}
	
	private int leastCommonDenominator(int a, int b) {
		List<Integer> multiplesA = new ArrayList<>();
		List<Integer> multiplesB = new ArrayList<>();
		multiplesA.add(a);
		multiplesB.add(b);
		int index = 0;
		for(;;) {
			Integer lcd = multiplesA.get(index);
			if (multiplesB.contains(lcd)) {
				return lcd;
			} else {
				index+=1;
				multiplesA.add(index*a);
				multiplesB.add(index*b);
				}
		}
	}

	public static void main(String[] args) {

//		String input = "sdfsdkfhskdjfhskjdhfksjdhfkjsdfnbkjifdjhkdahf";
//		int[] input2 = new int[] {4,3,4,3};

		DailyProblems d = new DailyProblems();
//		char firstNonRepeatingChar = d.firstNonRepeatingChar(input);
//		int numberOfDistinctPairs = d.numberOfDistinctPairs(input2, 8);
//		
//		d.substraings("aaabbaa");
//		System.out.println(d.numWays(5));
		System.out.println(d.compress("aasssscc"));
		System.out.println(Arrays.toString(d.sumOfFractions(new int[]{2, 4},new int[]{2,4})));
	}
}
