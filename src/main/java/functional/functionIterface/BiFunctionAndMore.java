package functional.functionIterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionAndMore {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        System.out.println("BiFunction add: " + add.apply(34, 32));

        Function<Integer, Integer> timesTwo = x -> x * 2;
        BiFunction<Integer, Integer, Integer> kaka = add.andThen(timesTwo);
        System.out.println(kaka.apply(1,2));


        TriFunction<Integer, Integer, Integer, Integer> addThree = (x, y, z) -> x + y + z;
        System.out.println("Add three: " + addThree.apply(10, 20, 30));


        NoArgFunction<String> sayHello = () -> "Hello!";
        System.out.println("Say hello: " + sayHello.apply());
    }
}
