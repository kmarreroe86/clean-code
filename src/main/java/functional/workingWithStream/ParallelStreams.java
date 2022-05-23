package functional.workingWithStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreams {

    public static void main(String[] args) {
        String[] wordsArray = {"hello", "functional", "programming", "is", "cool"};
        List<String> words = new ArrayList<String>(Arrays.asList(wordsArray));

        List<String> processedWords = words.parallelStream()
                .map(w -> {
                    System.out.println("Uppercasing: " + w);
                    return w.toLowerCase();
                })
                .map(w -> {
                    System.out.println("Adding exclamation point to: " + w);
                    return w + "!";
                })
                .collect(Collectors.toList());

        System.out.println(processedWords);
    }
}
