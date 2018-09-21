package uber;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class UberTest {

	/**
	 * Given an array of integers, return a new array such that each element at
	 * index i of the new array is the product of all the numbers in the original
	 * array except the one at i.
	 * 
	 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be
	 * [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would
	 * be [2, 3, 6].
	 */
	private int[] productArray(int[] input) {
		int product = Arrays.stream(input).reduce(1, (a,b) -> a*b);
		return Arrays.stream(input).map((n) -> product/n).toArray();
	}
	
	@Test
	public void productArray() {
		assertArrayEquals(new int[]{120,60,40,30,24} , productArray(new int[]{1,2,3,4,5}));
		assertArrayEquals(new int[]{2, 3, 6} , productArray(new int[]{3,2,1}));
	}

}
