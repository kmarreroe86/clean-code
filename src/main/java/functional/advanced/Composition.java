package functional.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Composition {

    public static void main(String[] args) {

        Employee[] employeesArr = {
                new Employee("John", 34, "developer", 80000f),
                new Employee("Hannah", 24, "developer", 95000f),
                new Employee("Bart", 50, "sales executive", 100000f),
                new Employee("Sophie", 49, "construction worker", 40000f),
                new Employee("Darren", 38, "writer", 50000f),
                new Employee("Nancy", 29, "developer", 75000f),
        };
        List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));

        Function<Integer, Integer> timesTwo = x -> x * 2;
        Function<Integer, Integer> minusOne = x -> x - 1;

        Function<Integer, Integer> timesTwoMinusOne = minusOne.compose(timesTwo); // Creates a composed function that execute in reverse order. Apply first timesTwo and then minusOne

        Function<Integer, Integer> timesTwoMinusOne_2 = timesTwo.andThen(minusOne); // Creates a composed function that execute in the same order that functions are chained.
                                                                                    // Apply first timesTwo and then minusOne

        Function<Integer, Integer> minusOneTimesTwo = minusOne.andThen(timesTwo);

        System.out.println(timesTwoMinusOne.apply(5));
        System.out.println(timesTwoMinusOne_2.apply(5));
        System.out.println(minusOneTimesTwo.apply(5));



        // Print all employees names in reverse and upper case.
        Function<Employee, String> getName = employee -> employee.name;
        Function<String, String> reverseStr = str -> new StringBuilder(str).reverse().toString();
        Function<String, String> toUpperCase = str -> str.toUpperCase();
        Function<Employee, String> getReversedUppercaseName = getName.andThen(reverseStr).andThen(toUpperCase);

        List<String> results = employees.stream()
                .map(getReversedUppercaseName)
                .collect(Collectors.toList());

        System.out.println(results);

    }

    protected static class Employee {
        public final String name;
        public final Integer age;
        public final String jobTitle;
        public final Float salary;

        public Employee(String name, Integer age, String jobTitle, Float salary) {
            this.name = name;
            this.age = age;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }
    }
}
