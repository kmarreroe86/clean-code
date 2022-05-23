package functional.advanced;

import functional.functionIterface.TriFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class PartialApplication {

    public static void main(String[] args) {

        // General function
        TriFunction<Integer, Integer, Integer, Integer> add = (x, y, z) -> x + y + z;

        // Partial function
        Function<Integer, BiFunction<Integer, Integer, Integer>> addPartial = (x) -> (y, z) -> add.apply(x, y, z);

        // Calling addPartial function and fix the x value to 5
        BiFunction<Integer, Integer, Integer> add5 = addPartial.apply(5);

        System.out.println(add5.apply(6, 7));

         // =======================
        Function<Integer, Function<Integer, Function<Integer, Integer>>> addPartialII =
                (x) -> (y) -> (z) -> add.apply(x, y, z);

        Function<Integer, Function<Integer, Integer>> add5II = addPartialII.apply(5); // (x) -> {...}
        Function<Integer, Integer> add5And6 = add5II.apply(6); // (y) -> {...}
        Integer sum = add5And6.apply(7);
    }
}
