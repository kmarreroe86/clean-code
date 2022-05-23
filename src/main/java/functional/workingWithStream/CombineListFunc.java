package functional.workingWithStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class CombineListFunc {

    public static void main(String[] args) {
        Chapter3Challenge1.Employee[] employeesArr = {
                new Chapter3Challenge1.Employee("John", 34, "developer", 80000f),
                new Chapter3Challenge1.Employee("Hannah", 24, "developer", 95000f),
                new Chapter3Challenge1.Employee("Bart", 50, "sales executive", 100000f),
                new Chapter3Challenge1.Employee("Sophie", 49, "construction worker", 40000f),
                new Chapter3Challenge1.Employee("Darren", 38, "writer", 50000f),
                new Chapter3Challenge1.Employee("Nancy", 29, "developer", 75000f),
        };
        List<Chapter3Challenge1.Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));

        // Ex. Get the average salary of developers employees
        Float totalDevSalaries = employees.stream()
                .filter(emp -> "developer".equals(emp.jobTitle))
                .map(dev -> dev.salary)
                .reduce(0f, (acc, x) -> acc + x);

        Long numberOfDevelopers = employees.stream()
                .filter(e -> "developer".equals(e.jobTitle))
                .count();

        Float averageDevSalary = totalDevSalaries / numberOfDevelopers;
        System.out.println("Ave Dev salary: " + averageDevSalary);



        // Ex. Get the average salary of non developers employees
        Float totalEmpNoDevSalaries = employees.stream()
                .filter(emp -> !"developer".equals(emp.jobTitle))
                .map(dev -> dev.salary)
                .reduce(0f, (acc, x) -> acc + x);

        Long numberOfEmpNoDev = employees.stream()
                .filter(e -> !"developer".equals(e.jobTitle))
                .count();

        float averageSalary = totalEmpNoDevSalaries / numberOfEmpNoDev;
        System.out.println("Ave no dev salary: " + averageSalary);



    }
}


