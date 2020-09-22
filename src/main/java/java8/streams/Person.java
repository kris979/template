package java8.streams;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.Random;
import java.util.function.IntSupplier;

public class Person implements IntSupplier {

    private String firstName;
    private String lastName;
    private int age;

    public Person(final String firstName, final String lastName, final int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "(" + age + ")";
    }

    @Override
    public int getAsInt() {
        return new Random().nextInt(10);
    }
}
