package functional.courseamigoscode.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {

        /** Functions */
        Function<Integer, Integer> incrementerByOne = number -> number + 1;
        Function<Integer, Integer> multiplyByTen = number -> number * 10;

        var increment = incrementerByOne.apply(10);
        System.out.println(increment);

        var combinedOperation = incrementerByOne.andThen(multiplyByTen);
        var combineResult = combinedOperation.apply(5);
        System.out.println(combineResult);


        /** BiFunction */
        BiFunction<Integer, Integer, Integer> incrementByOneAndMultiply = (number, numberToMultiply) -> (number + 1) * numberToMultiply;
        System.out.println("BiFunction: " + incrementByOneAndMultiply.apply(7, 100));
    }
}
