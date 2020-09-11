package datastructures.memoization;

public class Fibonacci {

    private int[] memo = new int[1001];

    /**
     * O(2^N)
     */
    public int slowFib(final int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return slowFib(n - 1) + slowFib(n - 2);
        }
    }

    /**
     * O(n)
     */
    public int fastFib(final int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            memo[n] = fastFib(n - 1) + fastFib(n - 2);
        }
        return memo[n];
    }
}

