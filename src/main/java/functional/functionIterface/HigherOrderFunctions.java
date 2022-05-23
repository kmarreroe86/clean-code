package functional.functionIterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class HigherOrderFunctions {

    public static void main(String[] args) {

        BiFunction<Float, Float, Float> divide = (x, y) -> x / y;

        // Receives a BiFunction<Float, Float, Float> and returns a BiFunction<Float, Float, Float>
        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> secondArgIsNotZeroCheck =
                (func) -> (x, y) -> {
                    if (y == 0f) {
                        System.out.println("Error: second argument is zero!");
                        return 0f;
                    }
                    return func.apply(x, y);
                };

        BiFunction<Float, Float, Float> divideSafe = secondArgIsNotZeroCheck.apply(divide);

        System.out.println(divideSafe.apply(10f, 0f));
        System.out.println(divideSafe.apply(9f, 2f));
    }
}
