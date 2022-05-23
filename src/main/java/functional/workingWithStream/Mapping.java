package functional.workingWithStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mapping {

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> listOfIntegers = new ArrayList(Arrays.asList(intArray));

        Function<Integer, Integer> timesTwo = (number) -> number * 2;

        Function<Integer, Function<Integer, Integer>> createMultiplier = (multiple) -> (num) -> num * multiple;

        Function<Integer, Integer> doubleTimes = createMultiplier.apply(2);
        Function<Integer, Integer> triTimes = createMultiplier.apply(3);

        List<Integer> doubled = listOfIntegers.stream()
//                .map(timesTwo)
                .map(triTimes)
                .collect(Collectors.toList());

        System.out.println(doubled);
    }
}
