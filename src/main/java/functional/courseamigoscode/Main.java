package functional.courseamigoscode;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        var people = List.of(
                new Person("Jane", Gender.FEMALE),
                new Person("Alice", Gender.FEMALE),
                new Person("Jane", Gender.MALE),
                new Person("Bob", Gender.MALE),
                new Person("Marie", Gender.FEMALE));


        // Who are the females?
        Predicate<Person> predicate = person -> Gender.FEMALE == person.gender;
        people
                .stream()
                .filter(predicate)//.filter(person -> Gender.FEMALE == person.gender)
                .forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        FEMALE, MALE
    }
}
