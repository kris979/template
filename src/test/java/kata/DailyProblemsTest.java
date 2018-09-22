package kata;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class DailyProblemsTest {
	
	private DailyProblems dp = new DailyProblems();


//		
//		d.substraings("aaabbaa");
//		System.out.println(d.numWays(5));
//		System.out.println(d.compress("aasssscc"));
//		System.out.println(Arrays.toString(d.sumOfFractions(new int[]{2, 4},new int[]{2,4})));
//	}

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
	
	
}
