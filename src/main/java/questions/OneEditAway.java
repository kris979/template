package questions;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * There are 3 types of edits: insert, remove, replace char
 * Given 2 strings write a function to check if they are 1 or 0 edits away.
 */
public class OneEditAway {

    boolean oneAway(String one, String two) {
        final int abs = Math.abs(one.length() - two.length());
        if (one.equals(two) || abs == 1) {
            //strings are exactly the same or only 1 char diff that can be fixed by insert or removal
            return true;
        } else if (abs == 0) {
            //strings have the same length so let's check if we can make them the same with one replace
            return oneReplace(one, two);
        } else {
            //more than 1 char diff
            return false;
        }
    }

    private boolean oneReplace(final String one, final String two) {
        Map<Character, Integer> oneCounts = PermutationsDetector.countChars(one);
        Map<Character, Integer> twoCounts = PermutationsDetector.countChars(two);
        MapDifference<Character, Integer> difference = Maps.difference(oneCounts, twoCounts);
        Map<Character, Integer> onlyOnLeft = difference.entriesOnlyOnLeft();
        Map<Character, Integer> onlyOnRight = difference.entriesOnlyOnRight();
        Map<Character, MapDifference.ValueDifference<Integer>> diff = difference.entriesDiffering();
        if (onlyOnLeft.size() > 1 || onlyOnRight.size() > 1 || diff.size() > 1) {
            return false;
        } else {
            return true;
        }
    }

}
