package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Exercise {

    static final Consumer<Person> sayHello = person -> System.out.println("Hello " + person.getFirstName() + "!");

    static final Function<Person, String> firstAndLastNameExtractor = person -> person.getFirstName() + " " + person.getLastName();
    static final Function<Person, String> lastNameAndAgeExtractor = person -> person.getLastName() + " (" + person.getAge() + ")";

    static final Predicate<Person> lastNameStartsWithR = person -> person.getLastName()
                                                                         .startsWith("R");

    static final Predicate<Person> under18 = person -> person.getAge() < 18;
    static final Predicate<Person> over18 = person -> person.getAge() > 18;

    static final List<Person> ppl = Arrays.asList(new Person("Kris", "Bliszczak", 40),
                                                  new Person("Amy", "Bliszczak", 8),
                                                  new Person("Agnieszka", "Rozanska", 45));

    static final Comparator<Person> personLastNameComparator = Comparator.comparing(Person::getLastName);
    static final Comparator<Person> personAgeComparator = Comparator.comparing(Person::getAge);

    public static void main(String[] args) {


        ppl.stream()
           .filter(over18)
           .sorted(personAgeComparator)
           .forEach(System.out::println);

        performActionForEachPerson(ppl, sayHello);
        final List<String> listOfFirstAndLastNames = convertPerson(ppl, firstAndLastNameExtractor);
        System.out.println(listOfFirstAndLastNames);
        final List<String> listOfLastNamesWithAge = convertPerson(ppl, lastNameAndAgeExtractor);
        System.out.println(listOfLastNamesWithAge);
    }

    public static List<String> convertPerson(List<Person> ppl, Function<Person, String> conversionFunction) {
        List<String> converted = new ArrayList<>();
        for (Person person : ppl) {
            converted.add(conversionFunction.apply(person));
        }
        return converted;
    }

    public static void performActionForEachPerson(List<Person> ppl, Consumer<Person> action) {
        ppl.forEach(action);
    }

}
