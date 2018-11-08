package kata;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;

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
        int[] input = new int[]{4, 3, 4, 3};
        int numberOfDistinctPairsThatAddUpTo8 = dp.numberOfDistinctPairsThatAddUpToK(input, 8);
        assertThat(numberOfDistinctPairsThatAddUpTo8, is(equalTo(1)));
        int[] input2 = new int[]{3, 7, 2, 9};
        int numberOfDistinctPairsThatAddUpTo10 = dp.numberOfDistinctPairsThatAddUpToK(input2, 10);
        assertThat(numberOfDistinctPairsThatAddUpTo10, is(equalTo(1)));
    }

    @Test
    public void sumOfFractionsTest() {
        int[] sumOfFractions = dp.sumOfFractions(new int[]{2, 4}, new int[]{2, 4});
        assertArrayEquals(sumOfFractions, new int[]{4, 4});
        sumOfFractions = dp.sumOfFractions(new int[]{2, 4}, new int[]{1, 4});
        assertArrayEquals(sumOfFractions, new int[]{3, 4});
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
        assertThat(dp.findFirstPositiveMissingInteger(new int[]{3, 4, -1, 1}), is(equalTo(2)));
        assertThat(dp.findFirstPositiveMissingInteger(new int[]{1, 2, 0}), is(equalTo(3)));
    }

    @Test
    public void dailyCodingProblem49Test() {
//        assertThat(dp.findMaxSumOfContinuousSubarray(new int[]{34, -50, 42, 14, -5, 86}), is(equalTo(137)));
//        assertThat(dp.findMaxSumOfContinuousSubarray(new int[]{-5, -1, -8, -9}), is(equalTo(0)));
//		For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.
//		Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.
    }

    @Test
    public void dailyCodingProblem47Test() {
        assertThat(dp.findMaxProfit(new Integer[] {9,11,8,10,15}), is(equalTo(7)));
        assertThat(dp.findMaxProfit(new Integer[] {9,4,8,10,7,1}), is(equalTo(6)));
        assertThat(dp.findMaxProfit(new Integer[] {3,9,11,10,1,9}), is(equalTo(8)));
        assertThat(dp.findMaxProfit(new Integer[] {9,4,8,10,7,10}), is(equalTo(6)));
        assertThat(dp.findMaxProfit(new Integer[] {9,8,10,7,10}), is(equalTo(3)));
    }
}
