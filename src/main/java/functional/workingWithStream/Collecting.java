package functional.workingWithStream;

import java.util.*;
import java.util.stream.Collectors;

public class Collecting {

    public static void main(String[] args) {

        String[] wordsArray = {"hello", "functional", "programming", "is", "cool", "java", "apple"};
        List<String> words = new ArrayList<String>(Arrays.asList(wordsArray));


        // To List
        List<String> largeWords = words.stream()
                .filter(s -> s.length() > 3)
                .collect(Collectors.toList());


        // To Set
        Set<String> largeWordsSet = words.stream()
                .filter(s -> s.length() > 3)
                .collect(Collectors.toSet());


        // String join with delimiter
        String largeWordsJoin = words.stream()
                .filter(s -> s.length() > 3)
                .collect(Collectors.joining(", "));


        // Counting
        Long howMany = words.stream()
                .filter(s -> s.length() > 3)
                .collect(Collectors.counting());

        Long howMany2 = words.stream()
                .filter(s -> s.length() > 3).count();


        // Grouping. Map each word to its length
        Map<Integer, List<String>> wordsLengthMap = words.stream()
                .collect(Collectors.groupingBy(
                        (word) -> word.length()
                ));


        // Similar to groupingBy, but only return two partitions, and receive a Predicate same as filter.
        Map<Boolean, List<String>> wordsLengthMapPartitioning = words.stream()
                .collect(Collectors.partitioningBy(
                        (word) -> word.length() > 4
                ));

        System.out.println("List: " + largeWords);
        System.out.println("Set: " + largeWordsSet);
        System.out.println("Joining: " + largeWordsJoin);
        System.out.println("Counting: " + howMany);
        System.out.println("Grouping by word length: " + wordsLengthMap);
        System.out.println("Partitioning word length > 4: " + wordsLengthMapPartitioning);
    }
}
