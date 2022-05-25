package functional.courseamigoscode.functionalinterface;

import java.util.function.Function;

public class Lambdas {

    public static void main(String[] args) {

        Function<String, String> toUpperCase = name -> name.toUpperCase();

        System.out.println(toUpperCase.apply("lerak"));
    }
}
