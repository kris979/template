package hackerrank;

import java.io.IOException;
import java.util.*;

public class Problems {

    static int simpleArraySum(int[] ar) {
        /*
         * Write your code here.
         */
        int sum = 0;
        for (int i : ar) {
            sum += i;
        }
        return sum;
    }

    static int countingValleys(int n, String s) {
        char[] chars = s.toCharArray();
        int level = 0;
        int mountains = 0;
        int valleys = 0;
        for (char aChar : chars) {
            if (aChar == 'U') {
                level += 1;
                if (level == 0)
                    valleys += 1;
            } else if (aChar == 'D') {
                level -= 1;
                if (level == 0)
                    mountains += 1;
            } else {
                System.out.println("bad char");
            }

        }

        return valleys;
    }


    static int jumpingOnClouds(int[] c) {
        int numberOfJumps = 0;
        for (int i = 0; i < c.length; ) {
            if (i + 2 < c.length && c[i + 2] == 0) {
                i += 2;
            } else if (i + 1 < c.length) {
                i += 1;
            } else {
                return numberOfJumps;
            }
            numberOfJumps++;
        }
        return numberOfJumps;
    }

    static long repeatedString(String s, long n) {

        long total = 0;

        long count = s.chars().filter(c -> c == 'a').count();

        int length = s.length();

        long howManyTImes = n / length;

        total = count * howManyTImes;

        long rest = n % length;

        if (rest > 0) {
            String substring = s.substring(0, (int) rest);
            long count2 = substring.chars().filter(c -> c == 'a').count();
            total += count2;
        }

        return total;
    }

    static String timeConversion(String s) {
        String substring = s.substring(s.length() - 2, s.length());
        String hour = s.substring(0, 2);

        if (substring.equals("AM")) {
            if (hour.equals("12")) {
                hour = "00";
            } else {

            }
        } else if (substring.equals("PM")) {
            if (hour.equals("12")) {

            } else {
                int i = Integer.parseInt(hour);
                hour = Integer.toString(12 + i);
            }
        }

        StringBuilder newTime = new StringBuilder();
        newTime.append(hour).append(s.substring(2, s.length() - 2));
        return newTime.toString();
    }

    static long countTriplets(List<Long> arr, long r) {

        if (arr.size() < 3)
            return 0;

        Long[] objects = arr.toArray(new Long[]{});

        Map<Long, List<Integer>> elements = new HashMap<>();

        for (int i = 0; i < objects.length; i++) {
            List<Integer> indexes = elements.get(objects[i]);
            if (indexes == null) {
                indexes = new ArrayList<>();
            }
            indexes.add(i);
            elements.put(objects[i], indexes);
        }

        long triplets = 0;
        Set<Long> longs = elements.keySet();
        for (Long aLong : longs) {

            long firstTripletElem = aLong;
            long secondTripletElem = firstTripletElem * r;
            long thirdTripletElem = secondTripletElem * r;

            List<Integer> indexesOfFirstElem = elements.get(firstTripletElem);
            List<Integer> indexesOfSecondElem = elements.get(secondTripletElem);
            List<Integer> indexesOfThirdElem = elements.get(thirdTripletElem);

            if (indexesOfFirstElem != null && indexesOfSecondElem != null && indexesOfThirdElem != null) {
                for (Integer integer : indexesOfFirstElem) {
                    for (Integer integer1 : indexesOfSecondElem) {
                        for (Integer integer2 : indexesOfThirdElem) {
                            triplets++;
                        }
                    }
                }
            }
        }
        return triplets;
    }

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> ret = new LinkedList<>();
        Map<Integer, Long> digits = new HashMap<>(); //coutners
        for (List<Integer> list : queries) {
            Integer action = list.get(0);
            Integer digit = list.get(1);

            Long counter = digits.get(digit);
            if (action == 1) {
                if (counter == null) {
                    digits.put(digit, 1L);
                } else {
                    digits.put(digit, ++counter);
                }
            } else if (action == 2) {
                if (counter != null) {
                    digits.put(digit, --counter);
                }
            } else if (action == 3) {
                boolean found = false;
                Collection<Long> counters = digits.values();
                for (Long integer : counters) {
                    if (integer == Long.valueOf(digit)) {
                        found = true;
                    }
                }
                if (found) {
                    ret.add(1);
                } else {
                    ret.add(0);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {

        List<List<Integer>> inputs = new Reader().readInput();
        List<Integer> expectedoutput = new Reader().readOutput();
        List<Integer> output = freqQuery(inputs);
        System.out.println(output);
        System.out.println(output.size());
        System.out.println(expectedoutput.size());
        for (int i=0;i<33246;i++){
            Integer out = output.get(i);
            Integer expectedOut = expectedoutput.get(i);
            if (out != expectedOut) {
                System.out.println("out = " + out + ", exp = " +expectedOut + " at index " +i);
            }
        }
    }
}
