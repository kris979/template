package java8.streams;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CharactersCounter {

    public static Map<String, Long> countChars(String input) {
        return Arrays.stream(input.split(""))
                     .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }
}
