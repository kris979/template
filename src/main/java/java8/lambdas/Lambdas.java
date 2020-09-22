package java8.lambdas;

import java8.streams.Person;

import java.util.Arrays;
import java.util.List;

/**
 * -enables functional programming
 * -readable and concise code
 * -easier to use APIs and libraries
 * -enables support for parallel processing
 */
public class Lambdas {


    public static void main(String[] args) {

        final List<Person> ppl = Arrays.asList(new Person("Kris", "Bliszczak", 40),
                                               new Person("Amy", "Bliszczak", 8),
                                               new Person("Agnieszka", "Rozanska", 45));
        Performer performer = new Performer();
        performer.greet(ppl);
        performer.perform(() -> System.out.println("Performing Hello World"));
        performer.printScoresFromAudience(ppl);


    }
}
