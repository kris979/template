package questions;

import java.util.HashMap;
import java.util.Map;

public class PermutationsDetector {

    public boolean detect(String src, String dst) {
        if (src.length() != dst.length()) {
            return false;
        }
        Map<Character, Integer> srcCounter = countChars(src);
        Map<Character, Integer> dstCounter = countChars(dst);
        return dstCounter.equals(srcCounter);
    }

    private Map<Character, Integer> countChars(final String src) {
        Map<Character, Integer> counters = new HashMap<>();
        for (Character c : src.toCharArray()) {
            Integer count = counters.get(c);
            if (count == null) {
                counters.put(c, 1);
            } else {
                counters.put(c, ++count);
            }
        }
        return counters;
    }
}
