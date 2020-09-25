package java8.lambdas;

import java8.streams.Person;

import java.util.List;
import java.util.stream.IntStream;

public class Performer {

    public void perform(Performance performance) {
        performance.perform();
    }

    public void greet(List<Person> audience) {
        audience.forEach(person -> System.out.println("Hello " + person.getFirstName()));
    }

    public void printScoresFromAudience(final List<Person> audience) {
        IntStream audienceScores = audience.stream()
                                           .mapToInt(person -> person.getAsInt());
        audienceScores.forEach(System.out::println);
    }


}
