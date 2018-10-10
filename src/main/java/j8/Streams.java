package j8;

import java.util.Arrays;
import java.util.stream.Stream;

public class Streams {



    public static void main(String[] args) {


//   ===================== stream creation  =====================
        String[] arr = new String[]{"a", "b", "c"};

        Stream<String> s1 = Arrays.stream(arr);
        Stream<String> s2 = Stream.of("A", "B", "C");

//   ===================== multi-threading =====================
        s2.parallel().forEach(element -> doSomeWorkInParallel(element));


















    }

    private static void doSomeWorkInParallel(String element) {
        System.out.println(element);
    }

}
