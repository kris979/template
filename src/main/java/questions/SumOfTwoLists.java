package questions;

import java.util.Stack;
import java.util.stream.Collectors;

public class SumOfTwoLists {

    public static void main(String[] args) {
        Stack<Integer> one = new Stack<>();
        one.push(8);
        one.push(0);
        one.push(0);

        Stack<Integer> two = new Stack<>();
        two.push(4);
        two.push(0);
        two.push(0);

        int sum = sumList(one, two);
        System.out.println(sum);
    }

    private static int sumList(final Stack<Integer> one, final Stack<Integer> two) {

        final String oneNum = one.stream()
                                  .map(e -> Integer.toString(e))
                                  .collect(Collectors.joining());
        final int left = Integer.parseInt(oneNum);

        final String twoNum = two.stream()
                                 .map(e -> Integer.toString(e))
                                 .collect(Collectors.joining());
        final int right = Integer.parseInt(twoNum);

        return left + right;
    }
}
