package uber;

import static org.junit.Assert.assertArrayEquals;

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
		int[] output = new int[input.length];
		int product = 1;
		for (int i : input) {
			product*=i;
		}
		for (int i = 0; i < input.length; i++) {
			output[i]=product/input[i];
		}
		return output;
	}
	
	@Test
	public void productArray() {
		assertArrayEquals(new int[]{120,60,40,30,24} , productArray(new int[]{1,2,3,4,5}));
		assertArrayEquals(new int[]{2, 3, 6} , productArray(new int[]{3,2,1}));
	}

}
