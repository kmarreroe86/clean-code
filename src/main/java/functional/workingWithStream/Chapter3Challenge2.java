package functional.workingWithStream;

import java.util.*;
import java.util.stream.Collectors;

public class Chapter3Challenge2 {

    public static void main(String[] args) {
        Employee2[] employeesArr = {
                new Employee2("John", 34, "developer", 80000f),
                new Employee2("Hannah", 24, "developer", 95000f),
                new Employee2("Bart", 50, "sales executive", 100000f),
                new Employee2("Sophie", 49, "construction worker", 40000f),
                new Employee2("Darren", 38, "writer", 50000f),
                new Employee2("Nancy", 29, "developer", 75000f),
        };
        List<Employee2> employees = new ArrayList<>(Arrays.asList(employeesArr));

        // Your answer goes here. Get the average salary for each job title
        Map<String, Float> averageSalaryByJobTitle = employees.stream()
                .collect(Collectors.groupingBy(
                        employee -> employee.jobTitle
                ))
                .entrySet().stream()
                    .collect(Collectors.toMap(
                            (entry) -> entry.getKey(),
                            (entry) -> entry.getValue().stream()
                                    .map(emp -> emp.salary)
                                    .reduce(0f, (acc, x) -> acc + x) / entry.getValue().size()
                    ));

        System.out.println(averageSalaryByJobTitle);

        // Another solution
        Map<String, Double> employeeByJobTitle =  employees.stream()
                .collect(Collectors.groupingBy(
                        Employee2::getJobTitle,
                        Collectors.averagingDouble(Employee2::getSalary))
                );

        System.out.println(employeeByJobTitle);
    }
}

class Employee2 {
    public final String name;
    public final Integer age;
    public final String jobTitle;
    public final Float salary;

    public Employee2(String name, Integer age, String jobTitle, Float salary) {
        this.name = name;
        this.age = age;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public static String getJobTitle(Employee2 e) {
        return e.jobTitle;
    }

    public static double getSalary(Employee2 e) {
        return e.salary;
    }
}
