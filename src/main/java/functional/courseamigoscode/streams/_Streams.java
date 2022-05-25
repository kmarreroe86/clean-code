package functional.courseamigoscode.streams;

import java.util.List;
import java.util.stream.Collectors;

public class _Streams {

    public static void main(String[] args) {

        var people = List.of(
                new Person("Jane", Gender.FEMALE),
                new Person("Alice", Gender.FEMALE),
                new Person("Jane", Gender.MALE),
                new Person("Bob", Gender.MALE),
                new Person("Marie", Gender.FEMALE));

        people.stream()
                .map(p -> p.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);


        var containsOnlyFemales = people.stream()
                .allMatch(p -> Gender.FEMALE.equals(p.gender));
        System.out.println("ContainsOnlyFemales: " + containsOnlyFemales);

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
