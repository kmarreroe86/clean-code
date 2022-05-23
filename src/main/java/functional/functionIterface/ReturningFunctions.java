package functional.functionIterface;

import java.util.function.Function;

public class ReturningFunctions {

    public static void main(String[] args) {

        // Function that return a Function that return a string
        NoArgFunction<NoArgFunction<String>> createGreeter = () -> () -> "Hello functional!";
        System.out.println(createGreeter.apply().apply());


        // or
        NoArgFunction<String> greeter = createGreeter.apply();
        System.out.println(greeter.apply());


        Function<Integer, Integer> timesTwo = MyMathOperationII.createMultiplier(2);
        System.out.println(timesTwo.apply(4));

        Function<Integer, Integer> timesThree = MyMathOperationII.createMultiplier(3);
        System.out.println(timesThree.apply(5));

        Function<Integer, Integer> timesFour = MyMathOperationII.createMultiplier(4);
        System.out.println(timesFour.apply(6));
    }
}


class MyMathOperationII {
    public static Integer timesTwo(Integer x) {
        return x * 2;
    }
    public static Integer timesThree(Integer x) {
        return x * 3;
    }
    public static Integer timesFour(Integer x) {
        return x * 4;
    }

    public static Function<Integer, Integer> createMultiplier(Integer multiple) {
        return (Integer x) -> x * multiple;
    }
}
