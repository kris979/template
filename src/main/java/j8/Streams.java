package j8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {


    public static void main(String[] args) {

        //   ===================== stream creation  =====================
        String[] array = new String[]{"a", "b", "c"};
        List<String> list = Arrays.asList(array);

        Stream<String> s1 = Arrays.stream(array);
        Stream<String> s2 = Stream.of("A", "B", "C");
        Stream<String> s3 = list.stream();

        /**   ===================== info =====================

         A stream pipeline consists of a stream source, followed by a zero or more intermediate operation
         and a terminal operation.

         lazy evaluation - computation of data is only performed when the terminal operation is initiated
                            and source elements are only consumed as needed.
        **/

        //   ===================== common operations =====================


        //forEach
        // - calls a supplied function on each element
        s3.forEach(e -> e.toUpperCase());

        //map
        // - produces a new stream after applying a function on each element. New stream can be of a
        //different type. For example: I have a stream of userIds and service class to retrieve user by Id.
        //I can then call: ids.stream().map(e -> service.getUserById(e)).collect();
        List<String> collected = s3.map(e -> e.toLowerCase()).collect(Collectors.toList());

        //collect
        // - is the common way of getting stuff out of the stream after we are done with processing.

        //filter
        // - this produces a new stream that contains elements of the original stream that pass a given test
        s1.filter(Objects::nonNull).filter(e -> e.length() > 0).collect(Collectors.toList());

        //findFirst
        Optional<String> first = s1.findFirst();

        //toArray - String[]::new creates an empty array of strings which is then populated.
        final String[] strings = s1.toArray(String[]::new);

        //flatMap
        //helps to flatten data structure. in below case we have Stream<List<String>> stream of lists.
        //then using flatMap we convert it to Stream<String>
        List<List<String>> nested = Arrays.asList(
                Arrays.asList(array),
                Arrays.asList(array));
        final List<String> flattened = nested.stream().flatMap(Collection::stream).collect(Collectors.toList());


        //   ===================== intermediate operations =====================

        //peek
        //- performs operation on each element of a stream and returns a new stream which can be used further.
        List<String> uppered = s1.peek(e -> e.toUpperCase()).collect(Collectors.toList());


        //   ===================== multi-threading =====================
        s2.parallel().forEach(element -> doSomeWorkInParallel(element));
    }



    private static void doSomeWorkInParallel(String element) {
        System.out.println(element);
    }

}
