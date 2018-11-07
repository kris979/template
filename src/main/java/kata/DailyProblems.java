package kata;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Stream;

/**
 * @author kris9
 */

/**
 * @author kris9
 */
public class DailyProblems {

    public DailyProblems() {
    }

    /**
     * @param input
     * @return
     */
    public char firstNonRepeatingChar(String input) {

        LinkedHashMap<Character, Integer> counterMap = new LinkedHashMap<>();

        Stream<Character> chars = input.chars().mapToObj(i -> (char) i);

        chars.forEach(
                c -> {
                    Integer counter = counterMap.get(c);
                    if (counter != null) {
                        counterMap.put(c, ++counter);
                    } else {
                        counterMap.put(c, 1);
                    }
                }
        );

        Set<Entry<Character, Integer>> counters = counterMap.entrySet();

        Optional<Entry<Character, Integer>> first =
                counters.stream().filter(entry -> entry.getValue() < 2).findFirst();

        return first.get().getKey();
    }

    /**
     * @param input
     * @param k
     * @return
     */
    public int numberOfDistinctPairsThatAddUpToK(int[] input, int k) {
        Set<Integer> reminders = new HashSet<>();
        int counter = 0;
        for (Integer integer : input) {
            int reminder = k - integer;
            if (reminders.contains(integer)) {
                counter += 1;
            } else {
                reminders.add(reminder);
            }
        }
        return counter;
    }

    /**
     * @param input
     */
    public void substraings(String input) {
        Map<Character, String> substrings = new HashMap<>();
        char[] charArray = input.toCharArray();
        Character previous = charArray[0];
        int counter = 0;
        int index = 0;
        for (int i = 0; i < charArray.length; i++) {
            Character c = charArray[i];
            if (c.equals(previous)) {
                counter += 1;
            } else {
                String largestSoFar = substrings.get(previous);
                if (largestSoFar == null || largestSoFar.length() < counter) {
                    substrings.put(previous, new String(charArray, index, counter));
                    counter = 1;
                    index = i;
                }
            }
            previous = c;
        }
        String largestSoFar = substrings.get(previous);
        if (largestSoFar == null || largestSoFar.length() < counter) {
            substrings.put(previous, new String(charArray, index, counter));
        }
        System.out.println(substrings);
    }

    /**
     * number of ways you can climb the stairs
     * <p>
     * you can jump by 1,2 or 3 steps at a time
     * <p>
     * if jump was only allowed by 1 or 2 steps then we woudl remove else and int
     * output = numWays(input-1) + numWays(input-2);
     */
    public int numWays(int input) {
        if (input == 0 || input == 1) {
            return 1;
        } else if (input == 2) {
            int output = numWays(input - 1) + numWays(input - 2);
            return output;
        }
        int output = numWays(input - 1) + numWays(input - 2) + numWays(input - 3);
        return output;
    }

    /**
     * i.e. aaabbcc becomes a3b2c2
     */
    public String compress(String input) {
        if (input == null || input.equals("")) {
            return input;
        }

        StringBuilder s = new StringBuilder();
        Character previous = input.toCharArray()[0];
        int counter = 0;
        for (Character c : input.toCharArray()) {
            if (c.equals(previous)) {
                counter += 1;
            } else {
                s.append(previous);
                s.append(counter);
                counter = 1;
            }
            previous = c;
        }
        s.append(previous);
        s.append(counter);
        return s.toString();
    }

    /**
     * @param a
     * @param b
     * @return
     */
    public int[] sumOfFractions(int[] a, int[] b) {
        if (a.length != 2 && a.length != 2) {
            throw new IllegalArgumentException();
        }
        int[] result = new int[2];
        int commonDenominator = leastCommonDenominator(a[1], b[1]);
        int numeratorMultipA = commonDenominator / a[1];
        int numeratorMultipB = commonDenominator / b[1];
        int lA = a[0] * numeratorMultipA;
        int lB = b[0] * numeratorMultipB;
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
        for (; ; ) {
            Integer lcd = multiplesA.get(index);
            if (multiplesB.contains(lcd)) {
                return lcd;
            } else {
                index += 1;
                multiplesA.add(index * a);
                multiplesB.add(index * b);
            }
        }
    }

    /**
     * For example for 3 vendors in the shop: [{0, 4, 5}, {2, 8, 3}, {7, 11, 10}],
     * the result should be [{0, 2, 5}, {2, 8, 3}, {8, 11, 10}]”
     */
    public static int lowestPrice(int[] timeSlot) {

        class Vendor {

            int start;
            int end;
            int price;

            public Vendor(int start, int end, int price) {
                super();
                this.start = start;
                this.end = end;
                this.price = price;
            }

            boolean isValid(int[] slot) {
                if (start <= slot[0] && end >= slot[1]) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        List<Vendor> vendors = new ArrayList<>();
        vendors.add(new Vendor(0, 4, 5));
        vendors.add(new Vendor(2, 8, 3));
        vendors.add(new Vendor(7, 11, 10));

        List<Integer> validPrices = new ArrayList<>();

        for (Vendor vendor : vendors) {
            if (vendor.isValid(timeSlot)) {
                validPrices.add(vendor.price);
            }
        }

        if (validPrices.isEmpty()) {
            throw new IllegalArgumentException("invalid slot");
        }

        Collections.sort(validPrices);

        return validPrices.get(0);
    }

    /**
     * Given an array of integers, find the first missing positive integer in
     * linear time and constant space.
     * In other words, find the lowest positive integer that does not exist in the array.
     * The array can contain duplicates and negative numbers as well.
     * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
     *
     * @param input
     * @return
     */
    int findFirstPositiveMissingInteger(int[] input) {
        int[] present = new int[1000];

        for (int i = 0; i < present.length; i++) {
            present[i] = -1;
        }

        for (int i : input) {
            if (i >= 0) {
                present[i] = 1;
            }
        }

        for (int i = 1; i < present.length; i++) {
            if (present[i] == -1) {
                return i;
            }
        }

        return -1;
    }

}
