package functional.workingWithStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter {

    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> listOfIntegers = new ArrayList(Arrays.asList(intArray));

        Predicate<Integer> isEven = (x) -> x % 2 == 0;
        List<Integer> evenNumbers = listOfIntegers.stream()
//                .filter(x -> x % 2 == 0)
                .filter(isEven)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);
        System.out.println("=====================================================================================");

        String[] wordsArray = {"hello", "functional", "programming", "is", "cool"};
        List<String> words = new ArrayList<String>(Arrays.asList(wordsArray));


        /**Higher Order Function that return a Predicated that will depend of the minLength param */
        Function<Integer, Predicate<String>> createLengthTest = (minLength) -> {
          return (str) -> str.length() > minLength;
        };

        Predicate<String> isLongerThan5 = (str) -> str.length() > 5; // fixed length predicate
        Predicate<String> isLongerThan3 = createLengthTest.apply(3);

        List<String> largeWords = words.stream()
//                .filter(isLongerThan5) or use dynamic length test predicate using Higher-Order Function
                .filter(isLongerThan3)
                .collect(Collectors.toList());
        System.out.println(largeWords);
    }
}
