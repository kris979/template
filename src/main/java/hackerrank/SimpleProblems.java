package hackerrank;

import java.io.IOException;
import java.util.*;

public class SimpleProblems {

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

        long count = s.chars().filter(c -> c == 'a').count();

        int length = s.length();

        long howManyTImes = n / length;

        long total = count * howManyTImes;

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

}
