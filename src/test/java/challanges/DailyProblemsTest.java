package challanges;

import static org.junit.Assert.assertArrayEquals;

import challanges.DailyProblems;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class DailyProblemsTest {
	
	private DailyProblems dp = new DailyProblems();

	@Test
	public void firstUniqueCharTest() { 
		String input = "sdfsdkfhskdjfhskjdhfksjdhfkjsdfnbkjifdjhkdahf";
		char firstNonRepeatingChar = dp.firstNonRepeatingChar(input);
		assertThat(firstNonRepeatingChar, is(equalTo('n')));
	}
	
	@Test
	public void numberOfDistinctPairs() { 
		int[] input = new int[] {4,3,4,3};
		int numberOfDistinctPairsThatAddUpTo8 = dp.numberOfDistinctPairsThatAddUpToK(input, 8);
		assertThat(numberOfDistinctPairsThatAddUpTo8, is(equalTo(1)));
		int[] input2 = new int[] {3,7,2,9};
		int numberOfDistinctPairsThatAddUpTo10 = dp.numberOfDistinctPairsThatAddUpToK(input2, 10);
		assertThat(numberOfDistinctPairsThatAddUpTo10, is(equalTo(1)));
	}
	
	@Test
	public void sumOfFractionsTest() { 
		int[] sumOfFractions = dp.sumOfFractions(new int[]{2, 4},new int[]{2,4});
		assertArrayEquals(sumOfFractions, new int[] {4,4});
		sumOfFractions = dp.sumOfFractions(new int[]{2, 4},new int[]{1,4});
		assertArrayEquals(sumOfFractions, new int[] {3,4});
	}
	
	@Test
	public void compressStringTest() { 
		String compressed = dp.compress("aasssscc");
		assertThat(compressed, is(equalTo("a2s4c2")));
	}
	
	@Test
	public void numberOfWaysToClimbStairsTest() { 
		assertThat(dp.numWays(3), is(equalTo(4)));
	}
	
	@Test
	public void substringsTest() { 
//		dp.substraings("aaabbaa");
	}
	
	@Test
	public void findFirstPositiveMissingIntegerTest() {
		assertThat(dp.findFirstPositiveMissingInteger(new int[] {3, 4, -1, 1}), is(equalTo(2)));
		assertThat(dp.findFirstPositiveMissingInteger(new int[] {1, 2, 0}), is(equalTo(3)));
	}
}
