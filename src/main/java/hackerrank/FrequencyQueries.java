package hackerrank;

import java.util.*;

public class FrequencyQueries {

    static List<Integer> freqQuery(List<List<Integer>> queries) {

        List<Integer> ret = new LinkedList<>();
        Map<Integer, Integer> digitsWithCounters = new HashMap<>();
        Map<Integer, Set<Integer>> countersWIthListOfDigits = new HashMap<>();
        for (List<Integer> list : queries) {
            Integer action = list.get(0);
            Integer digit = list.get(1);

            Integer counter = digitsWithCounters.get(digit);
            if (action == 1) {
                if (counter != null) {
                    //remove digit from old counter
                    Set<Integer> digits2 = countersWIthListOfDigits.get(counter);
                    if (digits2 != null) {
                        digits2.remove(digit);
                        countersWIthListOfDigits.put(counter, digits2);
                    }
                    ++counter;
                    //add digit to a new counter
                    Set<Integer> digits3 = countersWIthListOfDigits.get(counter);
                    if (digits3 != null) {
                        digits3.add(digit);
                        countersWIthListOfDigits.put(counter, digits3);
                    } else {
                        Set<Integer> digits4 = new HashSet<>();
                        digits4.add(digit);
                        countersWIthListOfDigits.put(counter, digits4);
                    }
                    digitsWithCounters.put(digit, counter);
                } else {
                    digitsWithCounters.put(digit, 1);
                    Set<Integer> digits3 = countersWIthListOfDigits.get(1);
                    if (digits3 != null) {
                        digits3.add(digit);
                        countersWIthListOfDigits.put(1, digits3);
                    } else {
                        Set<Integer> digits4 = new HashSet<>();
                        digits4.add(digit);
                        countersWIthListOfDigits.put(1, digits4);
                    }
                }
            } else if (action == 2) {
                if (counter != null) {
                    //remove digit from old counter
                    Set<Integer> digits2 = countersWIthListOfDigits.get(counter);
                    if (digits2 != null) {
                        digits2.remove(digit);
                        countersWIthListOfDigits.put(counter, digits2);
                    }
                    --counter;
                    if (counter.compareTo(0) > 0) {
                        Set<Integer> digits3 = countersWIthListOfDigits.get(counter);
                        if (digits3 != null) {
                            digits3.add(digit);
                            countersWIthListOfDigits.put(counter, digits3);
                        }
                        digitsWithCounters.put(digit, counter);
                    } else {
                        //do nothing
                    }
                } else {
                    //if it was not there we can not remove it
                }
            } else if (action == 3) {
                if (countersWIthListOfDigits.containsKey(digit)) {
                    ret.add(1);
                } else {
                    ret.add(0);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        List<List<Integer>> inputs = Arrays.asList(
                Arrays.asList(1,3),
                Arrays.asList(2,3),
                Arrays.asList(3,2),
                Arrays.asList(1,4),
                Arrays.asList(1,5),
                Arrays.asList(1,5),
                Arrays.asList(1,4),
                Arrays.asList(3,2),
                Arrays.asList(2,4),
                Arrays.asList(3,2)
        );
//        List<List<Integer>> inputs = new Reader().readInput();
//        List<Integer> expected = new Reader().readOutput();
        List<Integer> output = freqQuery(inputs);
//        System.out.println("exp.size=" + expected.size());
//        System.out.println("out.size=" + output.size());
//        System.out.println(expected.equals(output));
//        for (int i = 0; i < output.size(); i++) {
//            Integer out = output.get(i);
//            Integer expectedOut = expected.get(i);
//            if (out != expectedOut) {
//                System.out.println("index:" + i + " exp:" + expectedOut + " got:" + out);
//            }
//        }
        System.out.println(output.toString());
        System.out.println("END!");
    }
}
