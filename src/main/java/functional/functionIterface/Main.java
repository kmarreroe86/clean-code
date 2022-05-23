package functional.functionIterface;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Function<Integer, Integer> myTriple = MyMath::triple;
        Integer result = myTriple.apply(5);
        System.out.println("Triple of 5: " + result);

        Function<Integer, Integer> myDouble = (arg) -> arg * 2; // or (Integer arg) -> arg * 2;
        System.out.println("Double of 6: " + myDouble.apply(6));

        Function<String, Integer> getStringLength = strArg -> strArg.length();
        System.out.println("Length of \"lorem ipsum\" is: " + getStringLength.apply("lorem ipsum"));


        Function<Integer, Integer> getAbsoluteValue = (Integer arg) -> {
            if (arg < 0)
                return -arg;
            else
                return arg;
        };
        System.out.println("Absolute value of -159: is: " + getAbsoluteValue.apply(-159));
    }
}
