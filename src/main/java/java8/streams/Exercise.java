package java8.streams;

import com.google.common.collect.Maps;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise {

    static final Consumer<Person> sayHello = person -> System.out.println("Hello " + person.getFirstName() + "!");

    static final Function<Person, String> firstAndLastNameExtractor = person -> person.getFirstName() + " " + person.getLastName();
    static final Function<Person, String> lastNameAndAgeExtractor = person -> person.getLastName() + " (" + person.getAge() + ")";

    static final Predicate<Person> lastNameStartsWithR = person -> person.getLastName()
                                                                         .startsWith("R");

    static final Predicate<Person> under18 = person -> person.getAge() < 18;
    static final Predicate<Person> over18 = person -> person.getAge() > 18;

    static final Comparator<Person> personLastNameComparator = Comparator.comparing(Person::getLastName);
    static final Comparator<Person> personAgeComparator = Comparator.comparing(Person::getAge);


    static final List<Person> ppl = Arrays.asList(new Person("Kris", "Bliszczak", 40),
                                                  new Person("Amy", "Bliszczak", 8),
                                                  new Person("Hue", "Grant", 8),
                                                  new Person("Agnieszka", "Rozanska", 45));


    public static void main(String[] args) {
        ppl.stream()
           .filter(over18)
           .sorted(personAgeComparator)
           .forEach(System.out::println);
    }


    public static List<String> convertPeople(List<Person> ppl, Function<Person, String> conversionFunction) {
        return ppl.stream()
                  .map(conversionFunction)
                  .collect(Collectors.toList());
    }

    public static void performActionForEachPerson(List<Person> ppl, Consumer<Person> action) {
        ppl.forEach(action);
    }

}
