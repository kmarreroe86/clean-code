package functional.workingWithStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Reduce {

    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> listOfIntegers = new ArrayList(Arrays.asList(intArray));

        // Example 1. Inline lambda
        // Integer sum = listOfIntegers.stream().reduce(0, (acc, el) -> acc + el);


        // Example 2. Creating BinaryOperator function
        // Generic type in BinaryOperator is the same type for all the operands
        BinaryOperator<Integer> getSum = (acc, el) -> {
            Integer r = acc + el;
            System.out.println("acc: " + acc + ", el: " + el + ", result: " + r);
            return r;
        };
        Integer sum = listOfIntegers.stream().reduce(0, getSum);


        System.out.println("Reduce result: " + sum);
    }
}
