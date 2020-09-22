package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CollectorsPractise {

    static final List<Person> ppl = Arrays.asList(new Person("Kris", "Bliszczak", 40),
                                                  new Person("Amy", "Bliszczak", 8),
                                                  new Person("Hue", "Grant", 8),
                                                  new Person("Agnieszka", "Rozanska", 45));

    public static void main(String[] args) {
        System.out.println(groupPeopleByAge(ppl));
        System.out.println(groupPeopleBySurname(ppl));
        System.out.println(countPeopleInEachFamily(ppl));
    }

    public static final Map<Integer, List<Person>> groupPeopleByAge(List<Person> ppl) {
        return ppl.stream()
                  .collect(Collectors.groupingBy(Person::getAge));
    }

    public static final Map<String, List<String>> groupPeopleBySurname(List<Person> ppl) {
        return ppl.stream()
                  .collect(Collectors.groupingBy(Person::getLastName,
                                                 Collectors.mapping(Person::getFirstName, toList())));
    }

    private static Map<String, Long> countPeopleInEachFamily(final List<Person> ppl) {
        return ppl.stream()
                  .collect(Collectors.groupingBy(Person::getLastName, Collectors.counting()));
    }
}
